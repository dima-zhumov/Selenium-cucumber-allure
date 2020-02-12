import com.aplana.pages.MortgagePage;
import com.aplana.steps.BaseSteps;
import com.aplana.steps.MortgageSteps;
import com.aplana.steps.SberbankSteps;
import com.google.common.base.Function;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest extends BaseSteps {

    @Test
    @DisplayName("Ипотека в сбербанке")
    public void Sberbank() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);

        SberbankSteps sberbankSteps = new SberbankSteps();
        MortgageSteps mortgageSteps = new MortgageSteps();
        MortgagePage mortgagePage = new MortgagePage();

        sberbankSteps.moveToMortgage();
        sberbankSteps.MortgageFinishedButton();

        mortgageSteps.switchToIframe();
        Thread.sleep(2000);
        mortgageSteps.inputEstateCost();
        Thread.sleep(2000);
        mortgageSteps.inputInitialFee();
        Thread.sleep(2000);
        mortgageSteps.inputCreditTerm();
        Thread.sleep(2000);
        mortgageSteps.paid();
        Thread.sleep(1000);
        wait.until((Function<? super WebDriver, Boolean>) driver -> mortgageSteps.canConfirm());
        mortgageSteps.youngFamily();
        Thread.sleep(2000);

        Assert.assertEquals("Стоимость квартиры не совпадает",
                "2 122 000 ₽", mortgageSteps.getAmountOfCredit());
        Assert.assertEquals("Сумма ежемесячного дохода не совпадает",
                "17 535 ₽", mortgageSteps.getMonthlyPayment());
        Assert.assertEquals("Сумма необходимого дохода не совпадет",
                "29 224 ₽", mortgageSteps.getRequiredIncome());
        Assert.assertEquals("Процентная ставка по ипотеке не совпадает",
                "9,3 %", mortgageSteps.getRate());
    }
}
