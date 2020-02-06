package com.aplana.steps;

import com.aplana.pages.SberbankPage;
import org.openqa.selenium.interactions.Actions;

import static com.aplana.steps.BaseSteps.getDriver;


public class SberbankSteps {


    SberbankPage sberbankPage = new SberbankPage();

    public void MortgageFinishedButton(){
        sberbankPage.mortgageFinishedButton.click();
    }

    public void moveToMortgage(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sberbankPage.mortgageButton).build().perform();
    }


}
