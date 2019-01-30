package com.herokuapp.computer_database.steps;

import org.testng.Assert;

import Browsers.Browser;
import Container.Bucket;
import Pages.ComputersDashboardPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ComputerDashboardPageSteps extends BaseSteps {

    ComputersDashboardPage computersDashboardPage;

    public ComputerDashboardPageSteps() {
        this.computersDashboardPage = new ComputersDashboardPage();
    }

    @And("^Searching for the old Computer Name should give no results$")
    public void searchingForTheOldComputerNameShouldGiveResults() {
        computersDashboardPage.getSearchField().sendKeys(Bucket.getComputerbefore().getName());
        computersDashboardPage.getFilterByNameButton().click();

        computersDashboardPage.getNoResultmessage().getText();
        Assert.assertEquals(computersDashboardPage.getNoResultmessage().getText(), "Nothing to display");
    }

    @When("^User click on Add a new computer button$")
    public void userClickOnAddANewComputerButton() {
        computersDashboardPage.getAddNewComputerButton().click();
    }

    @And("User opens computers Dashboard page")
    public void userOpensDashboard() {
        Browser.getInstance().get(props.getProperty("BASE_URL"));
    }

    @And("Success message should be shown with the computer name in it")
    public void checkMessage() {
        String message = computersDashboardPage.getMessage().getText();
        String compName = Bucket.getComputer().getName();
        Assert.assertTrue(message.contains(compName), "computer name(" + compName + ") should have been in message");

    }

    @And("Searching for the computer Should return only (.*) result")
    public void searchForComputer(int size) {
        computersDashboardPage.getSearchField().clear();
        computersDashboardPage.getSearchField().sendKeys(Bucket.getComputer().getName());
        computersDashboardPage.getFilterByNameButton().click();
        Assert.assertTrue(computersDashboardPage.gettableRows().size() == size);

    }

    @And("Open newly created computer")
    public void openCreatedComputer() {
        clearAndWriteInto(computersDashboardPage.getSearchField(), Bucket.getComputer().getName());
        computersDashboardPage.getFilterByNameButton().click();
        if (computersDashboardPage.getTableCompNames().size() == 1) {
            computersDashboardPage.getTableCompNames().get(0).click();
        } else {
            Assert.fail();
        }
    }

}
