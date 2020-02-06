package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SberbankPage;

public class SberbankSteps {
    WebDriver driver;

    public SberbankSteps (WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    SberbankPage sberbankPage = new SberbankPage();




}
