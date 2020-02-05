package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SberbankPage extends BasePage{
        WebDriver driver;

        public SberbankPage (WebDriver driver){
            PageFactory.initElements(driver,this);
            this.driver = driver;
        }

        @FindBy(xpath = "//span[text()='Ипотека']")
        public WebElement mortgageButton;

        @FindBy(xpath = "//a[contains(text(),'готовое') and contains(@class,'lg')]")
        public WebElement mortgageFinishedButton;

        public void MortgageFinishedButton(){
            mortgageFinishedButton.click();
        }

        public void moveToMortgage(){
           Actions actions = new Actions(driver);
           actions.moveToElement(mortgageButton).build().perform();
        }


//        public void inputSearchPS(){
//            search.sendKeys("playstation");
//            search.sendKeys(Keys.ENTER);
//        }
}
