package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MortgagePage extends BasePage {
    WebDriver driver;

    public MortgagePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//iframe[@id='iFrameResizer0']")
    public WebElement iframe;

    @FindBy(xpath = "//input[@id='estateCost']")
    public WebElement estateCost;

    @FindBy(xpath = "//input[@id='initialFee']")
    public WebElement initialFee;

    @FindBy(xpath = "//input[@id='creditTerm']")
    public WebElement creditTerm;

    @FindBy(xpath = "//div[div[text()='Молодая семья']]//label")
    public WebElement youngFamilyDiscount;

    @FindBy(xpath = "//div[text()='Есть возможность подтвердить доход справкой']")
    public WebElement canConfirmIncome;

    @FindBy(xpath = "//div[div[text()='Есть зарплатная карта Сбербанка']]//label")
    public WebElement paidToCardCheck;

    @FindBy(xpath = "//div[@class='dcCalc_disclaimer']")
    public WebElement viewPort1;

    @FindBy(xpath = "//h2[contains(text(),'решение')]")
    public WebElement viewPort2;

    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    public WebElement amountOfCredit;

    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    public WebElement monthlyPayment;

    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    public WebElement requiredIncome;

    @FindBy(xpath = "//span[@data-test-id='rate']")
    public WebElement rate;


    public void inputEstateCost() throws InterruptedException {
        estateCost.clear();
        estateCost.sendKeys("5180000");
    }

    public void inputInitialFee() throws InterruptedException {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(initialFee).build().perform();
        actions.click();
        initialFee.clear();
        initialFee.sendKeys("3058000");
    }

    public void inputCreditTerm() throws InterruptedException {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(creditTerm).build().perform();
        actions.click();
        creditTerm.sendKeys(Keys.CONTROL+"a");
        Thread.sleep(2000);
        creditTerm.clear();
        String text = "30";
        for (char c: text.toCharArray()) {
            Thread.sleep(200);
            creditTerm.sendKeys(String.valueOf(c));
        }
    }

    public void paid(){
        (((Locatable)viewPort1).getCoordinates()).inViewPort();
        paidToCardCheck.click();
    }

    public void youngFamily(){
        this.driver.switchTo().defaultContent();
        (((Locatable)viewPort2).getCoordinates()).inViewPort();
        this.driver.switchTo().frame(iframe);
        youngFamilyDiscount.click();
    }
}
