import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MortgagePage;
import pages.SberbankPage;
import steps.MortgageSteps;
import steps.SberbankSteps;

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

//    @Attachment(type = "image/png", value = "Screenshot")
//    public static byte[] takeScreenshot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }

    @Test
    public void Sberbank() throws InterruptedException {
        driver.navigate().to(properties.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, 30);

        SberbankSteps sberbankSteps = new SberbankSteps(driver);
        MortgageSteps mortgageSteps = new MortgageSteps(driver);
        MortgagePage mortgagePage = new MortgagePage();

        sberbankSteps.moveToMortgage();
        sberbankSteps.MortgageFinishedButton();

        driver.switchTo().frame(mortgagePage.iframe);
        Thread.sleep(1500);
        mortgageSteps.inputEstateCost();
        Thread.sleep(3000);
        mortgageSteps.inputInitialFee();
        Thread.sleep(3000);
        mortgageSteps.inputCreditTerm();
        Thread.sleep(3000);
        mortgageSteps.paid();
        Thread.sleep(1000);
        wait.until(driver -> mortgagePage.canConfirmIncome.isEnabled());
        mortgageSteps.youngFamily();
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
