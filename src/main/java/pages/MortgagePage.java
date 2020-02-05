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

    @FindBy(xpath = "//label[@class='dcCalc_switch dcCalc_switch_size_medium dcCalc_switch_checked']/input[@data-test-id='paidToCard']")
    public WebElement paidToCardCheck;

    @FindBy(xpath = "//label[@class='dcCalc_switch dcCalc_switch_size_medium dcCalc_switch_checked']/input[@data-test-id='canConfirmIncome']")
    public WebElement canConfirmCheck;

    @FindBy(xpath = "//label[@class='dcCalc_switch dcCalc_switch_size_medium']/input[@data-test-id='youngFamilyDiscount']")
    public WebElement youngFamilyCheck;

    @FindBy(xpath = "//div[@class='dcCalc_disclaimer']")
    public WebElement viewPort1;

    @FindBy(xpath = "//h2[contains(text(),'решение')]")
    public WebElement viewPort2;

    @FindBy(xpath = "//span[@class='dcCalc_switch__control']")
    public List<WebElement> switchControl;

    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    public WebElement amountOfCredit;

    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    public WebElement monthlyPayment;

    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    public WebElement requiredIncome;

    @FindBy(xpath = "//span[@data-test-id='rate']")
    public WebElement rate;


    public void inputEstateCost()throws InterruptedException{
        Actions actions = new Actions(this.driver);
        actions.moveToElement(estateCost).build().perform();
        actions.click();

       // (((Locatable)estateCost).getCoordinates()).inViewPort();
        estateCost.sendKeys(Keys.CONTROL+"a");
        Thread.sleep(2000);
        estateCost.sendKeys(Keys.BACK_SPACE);
        estateCost.sendKeys(Keys.CONTROL+"a");
        estateCost.sendKeys(Keys.BACK_SPACE);
//        estateCost.clear();
        String text = "5180000";
        for (char c: text.toCharArray()) {
            Thread.sleep(200);
            estateCost.sendKeys(String.valueOf(c));
        }
        //estateCost.sendKeys("5 180 000 ");
       // estateCost.click();
    }

    public void inputInitialFee() throws InterruptedException{
       Actions actions = new Actions(this.driver);
        actions.moveToElement(initialFee).build().perform();
        actions.click();
       // (((Locatable)initialFee).getCoordinates()).inViewPort();
        initialFee.sendKeys(Keys.CONTROL+"a");
        Thread.sleep(3000);
        initialFee.clear();
        String text = " 3058000";
        for (char c: text.toCharArray()) {
            Thread.sleep(500);
            initialFee.sendKeys(String.valueOf(c));
        }
//        initialFee.sendKeys("3 058 000 ");
    }

    public void inputCreditTerm()throws InterruptedException{
        Actions actions = new Actions(this.driver);
        actions.moveToElement(creditTerm).build().perform();
        actions.click();
        //(((Locatable)creditTerm).getCoordinates()).inViewPort();
        creditTerm.sendKeys(Keys.CONTROL+"a");
        Thread.sleep(2000);
//        creditTerm.sendKeys(Keys.BACK_SPACE);
        creditTerm.clear();
        String text = "30";
        for (char c: text.toCharArray()) {
            Thread.sleep(200);
            creditTerm.sendKeys(String.valueOf(c));
        }
    }

    public void paidToCard(){
        (((Locatable)viewPort1).getCoordinates()).inViewPort();
        if (paidToCardCheck.isEnabled()){
            switchControl.get(1).click();
        }
    }

    public void youngFamily(){
        this.driver.switchTo().defaultContent();
        (((Locatable)viewPort2).getCoordinates()).inViewPort();
        this.driver.switchTo().frame(iframe);
        if (youngFamilyCheck.isEnabled()){
            switchControl.get(switchControl.size()-1).click();
        }
    }

}
