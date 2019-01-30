package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersDashboardPage extends BasePage {

    @FindBy(id = "add")
    private WebElement addNewComputerButton;
    @FindBy(id = "searchsubmit")
    private WebElement filterByNameButton;
    @FindBy(id = "searchbox")
    private WebElement searchField;
    @FindBy(xpath = "//div[@class='alert-message warning']")
    private WebElement message;
    @FindBy (xpath= "//tbody/tr")
    private List<WebElement> tableRows;
    @FindBy (xpath= "//tbody/tr/td[1]/a")
    private List<WebElement> tableCompNames;

    public WebElement getNoResultmessage() {
        return noResultmessage;
    }

    @FindBy (xpath= "//em[contains(text(),'Nothing to display')]")
    private WebElement noResultmessage;

    public List<WebElement> getTableCompNames() {
        return tableCompNames;
    }

    public List<WebElement> gettableRows() {
        return tableRows;
    }



    public WebElement getAddNewComputerButton() {
        return addNewComputerButton;
    }

    public WebElement getFilterByNameButton() {
        return filterByNameButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getMessage() {
        return message;
    }
}
