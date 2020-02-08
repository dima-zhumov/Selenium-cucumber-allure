package com.aplana.pages;
import com.aplana.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MortgagePage extends BasePage {


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


}
