import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @Test
    public void Sberbank() throws InterruptedException {
        driver.navigate().to(properties.getProperty("app.url"));
        WebDriverWait wait = new WebDriverWait(driver, 30);

        SberbankPage sberbankPage = new SberbankPage(driver);
        MortgagePage mortgagePage = new MortgagePage(driver);

        sberbankPage.moveToMortgage();
        sberbankPage.MortgageFinishedButton();

        driver.switchTo().frame(mortgagePage.element);
       // wait.until(ExpectedConditions.elementToBeClickable(mortgagePage.estateCost));

        Thread.sleep(3000);
        mortgagePage.inputEstateCost();
        mortgagePage.inputInitialFee();
        mortgagePage.inputCreditTerm();

        Assert.assertEquals("Стоимость квартиры не совпадает",
                mortgagePage.estateCost.getAttribute("value").replaceAll("[^\\d]",""),"5180000");
        Thread.sleep(5000);

        //mortgagePage.paidToCard(mortgagePage.paidToCardButton());
        mortgagePage.paid();
Thread.sleep(5000);
    }
}
