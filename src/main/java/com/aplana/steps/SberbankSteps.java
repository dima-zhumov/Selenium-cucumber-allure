package com.aplana.steps;

import com.aplana.pages.SberbankPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.aplana.steps.BaseSteps.getDriver;


public class SberbankSteps {


    SberbankPage sberbankPage = new SberbankPage();

    @Step("Клик по ипотеке")
    public void moveToMortgage(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sberbankPage.mortgageButton).build().perform();
    }

    @Step("Клик по вкладке готовое жилье")
    public void MortgageFinishedButton(){
        sberbankPage.mortgageFinishedButton.click();
    }






}
