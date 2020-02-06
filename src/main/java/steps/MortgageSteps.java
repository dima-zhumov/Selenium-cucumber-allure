package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import pages.MortgagePage;
import ru.yandex.qatools.allure.annotations.Step;

public class MortgageSteps {
    WebDriver driver;

    public MortgageSteps (WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    MortgagePage mortgagePage = new MortgagePage();

    @Step("Клик по ипотеке")
    public void inputEstateCost() throws InterruptedException {
        mortgagePage.estateCost.clear();
        mortgagePage.estateCost.sendKeys("5180000");
    }

    public void inputInitialFee() throws InterruptedException {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(mortgagePage.initialFee).build().perform();
        actions.click();
        mortgagePage.initialFee.clear();
        mortgagePage.initialFee.sendKeys("3058000");
    }

    public void inputCreditTerm() throws InterruptedException {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(mortgagePage.creditTerm).build().perform();
        actions.click();
        mortgagePage.creditTerm.sendKeys(Keys.CONTROL+"a");
        Thread.sleep(2000);
        mortgagePage.creditTerm.clear();
        String text = "30";
        for (char c: text.toCharArray()) {
            Thread.sleep(200);
            mortgagePage.creditTerm.sendKeys(String.valueOf(c));
        }
    }

    public void paid(){
        (((Locatable)mortgagePage.viewPort1).getCoordinates()).inViewPort();
        mortgagePage.paidToCardCheck.click();
    }

    public void youngFamily(){
        this.driver.switchTo().defaultContent();
        (((Locatable)mortgagePage.viewPort2).getCoordinates()).inViewPort();
        this.driver.switchTo().frame(mortgagePage.iframe);
        mortgagePage.youngFamilyDiscount.click();
    }
}
