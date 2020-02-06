package com.aplana.steps;

import com.aplana.pages.MortgagePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import ru.yandex.qatools.allure.annotations.Step;

public class MortgageSteps extends BaseSteps{

    MortgagePage mortgagePage = new MortgagePage();

   // @Step("Клик по ипотеке")
    public void inputEstateCost() throws InterruptedException {
        mortgagePage.estateCost.clear();
        mortgagePage.estateCost.sendKeys("5180000");
    }

    public void inputInitialFee() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mortgagePage.initialFee).build().perform();
        actions.click();
        mortgagePage.initialFee.clear();
        mortgagePage.initialFee.sendKeys("3058000");
    }

    public void inputCreditTerm() throws InterruptedException {
        Actions actions = new Actions(getDriver());
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
        getDriver().switchTo().defaultContent();
        (((Locatable)mortgagePage.viewPort2).getCoordinates()).inViewPort();
        getDriver().switchTo().frame(mortgagePage.iframe);
        mortgagePage.youngFamilyDiscount.click();
    }
}
