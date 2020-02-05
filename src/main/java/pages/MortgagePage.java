package pages;

import org.openqa.selenium.By;
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
    public WebElement element;

    @FindBy(xpath = "//input[@id='estateCost']")
    public WebElement estateCost;

    @FindBy(xpath = "//input[@id='initialFee']")
    public WebElement initialFee;

    @FindBy(xpath = "//input[@id='creditTerm']")
    public WebElement creditTerm;

   // @FindBy(xpath = "//div[@class='dcCalc_switch-tablet']//input[@data-test-id='paidToCard']")
    @FindBy(xpath = "//label[@class='dcCalc_switch dcCalc_switch_size_medium dcCalc_switch_checked']/input[@data-test-id='paidToCard']")
    public WebElement paidToCardCheck;

//    @FindBy(xpath = "//span[@class='dcCalc_switch__control']")
//    public List<WebElement> paidToCardButton;

    public List<WebElement> paidToCardButton(){
        return this.driver.findElements(By.xpath("//span[@class='dcCalc_switch__control']"));
    }


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

//    public void paidToCard(List<WebElement> card){
//        if (paidToCardCheck.isEnabled()){
//            card.get(1).click();
//        }
//    }

    public void paid(){
        Actions actions = new Actions(this.driver);
        actions.moveToElement(paidToCardCheck).build().perform();
        paidToCardCheck.sendKeys(Keys.ENTER);
        paidToCardCheck.click();
    }



}
