package com.herokuapp.computer_database.steps;

import org.testng.Assert;

import Container.Bucket;
import Models.Computer;
import Pages.ComputerFormPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ComputerFormSteps extends BaseSteps {

    ComputerFormPage computerFormPage;

    public ComputerFormSteps() {
        computerFormPage = new ComputerFormPage();
    }

    @And("^Edit all fields$")
    public void editAllFields() {
        Bucket.setComputerbefore(Bucket.getComputer());

        Computer comp = Computer.getRandomComputerDifferentFrom(Bucket.getComputer());
        Bucket.setComputer(comp);

        clearAndWriteInto(computerFormPage.getComputerNameField(),comp.getName());
        computerFormPage.getCompanyDropDown().sendKeys(comp.getCompany());
        clearAndWriteInto(computerFormPage.getIntroducedDateField(),comp.getDate());
        clearAndWriteInto(computerFormPage.getDiscontinueddDateField(),comp.getDate2());

    }

    @And("Entering Valid random computer data")
    public void enterComputerData() {
        Computer comp = Computer.getRandomComputer();
        Bucket.setComputer(comp);
        computerFormPage.getComputerNameField().sendKeys(comp.getName());
        computerFormPage.getIntroducedDateField().sendKeys(comp.getDate());
        computerFormPage.getDiscontinueddDateField().sendKeys(comp.getDate2());
        computerFormPage.getCompanyDropDown().sendKeys(comp.getCompany());
    }

    @And("Saving a computer")
    public void saveComputer(){
        computerFormPage.getCreateSaveComputerButton().click();
        System.out.println(Bucket.getComputer().toString());
    }
    @And("Page title should be (.*)")
    public void checkPageTitle(String title){
        Assert.assertEquals(computerFormPage.getPageTitle().getText(),title);

    }

    @Then("^Verify that data in all fields matches with imputed data$")
    public void verifyThatDataInAllFieldsMatchesWithImputedData() {
        Computer compFromFrontEnd = new Computer(
                computerFormPage.getComputerNameField().getAttribute("value"),
                computerFormPage.getIntroducedDateField().getAttribute("value"),
                computerFormPage.getDiscontinueddDateField().getAttribute("value"),
                computerFormPage.getSelectedCompany().getText());

        Assert.assertTrue(Bucket.getComputer().equals(compFromFrontEnd));
    }
    @Then ("Delete this computer")
    public void deleteThisComputer(){
        computerFormPage.getDeleteComputerButton().click();

    }
}
