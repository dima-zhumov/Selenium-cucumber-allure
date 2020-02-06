import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MortgagePage;
import pages.SberbankPage;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();

        baseUrl = properties.getProperty("app.url");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    public void Sberbank() throws InterruptedException {
        driver.navigate().to(properties.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, 30);

        SberbankPage sberbankPage = new SberbankPage(driver);
        MortgagePage mortgagePage = new MortgagePage(driver);

        sberbankPage.moveToMortgage();
        sberbankPage.MortgageFinishedButton();

        driver.switchTo().frame(mortgagePage.iframe);
        Thread.sleep(1500);
        mortgagePage.inputEstateCost();
        Thread.sleep(3000);
        mortgagePage.inputInitialFee();
        Thread.sleep(3000);
        mortgagePage.inputCreditTerm();
        Thread.sleep(3000);
        mortgagePage.paid();
        Thread.sleep(1000);
        wait.until(driver -> mortgagePage.canConfirmIncome.isEnabled());
        mortgagePage.youngFamily();
        Thread.sleep(2000);

        Assert.assertEquals("Стоимость квартиры не совпадает",
                "2 122 000 ₽", mortgagePage.amountOfCredit.getText());
        Assert.assertEquals("Стоимость квартиры не совпадает",
                "17 535 ₽", mortgagePage.monthlyPayment.getText());
        Assert.assertEquals("Стоимость квартиры не совпадает",
                "29 224 ₽", mortgagePage.requiredIncome.getText());
        Assert.assertEquals("Стоимость квартиры не совпадает",
                "11 %", mortgagePage.rate.getText());
    }
}
