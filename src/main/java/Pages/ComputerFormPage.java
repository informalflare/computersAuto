package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputerFormPage extends BasePage {

    @FindBy(id = "company")
    private WebElement companyDropDown;
    @FindBy(id = "name")
    private WebElement computerNameField;
    @FindBy(xpath = "//div[@class='actions']//input[@type='submit']")
    private WebElement createSaveComputerButton;
    @FindBy(xpath = "//input[@value='Delete this computer']")
    private WebElement deleteComputerButton;
    @FindBy(id = "discontinued")
    private WebElement discontinueddDateField;
    @FindBy(id = "introduced")
    private WebElement introducedDateField;
    @FindBy (xpath= "//option[@selected]")
    private WebElement selectedCompany;

    public WebElement getSelectedCompany() {
        return selectedCompany;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    @FindBy (xpath= "//section/h1")
    private WebElement pageTitle;


    public WebElement getCompanyDropDown() {
        return companyDropDown;
    }

    public WebElement getComputerNameField() {
        return computerNameField;
    }

    public WebElement getCreateSaveComputerButton() {
        return createSaveComputerButton;
    }

    public WebElement getDeleteComputerButton() {
        return deleteComputerButton;
    }

    public WebElement getDiscontinueddDateField() {
        return discontinueddDateField;
    }

    public WebElement getIntroducedDateField() {
        return introducedDateField;
    }

}
