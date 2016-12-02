package com.interviewtask.steps;

import com.interviewtask.pages.ContactEditPagePO;
import com.interviewtask.pages.ContactsGridPO;
import com.interviewtask.pages.LeftPanelPO;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;


public class StepObject extends Steps {
    ContactsGridPO grid = new ContactsGridPO();
    ContactEditPagePO editContact = new ContactEditPagePO();
    LeftPanelPO panel = new LeftPanelPO();

    @Given("the user is on the contact grid page")
    public void openGridPage(){
        grid.open();
    }

    @When("the user click on \"+\" button")
    public void addContact(){
        grid.addNewContact();
    }

    @Then("contact edit page is opened")
    public void isOpened(){
        Assert.assertTrue(editContact.isOpened());
    }

    @When("clicks \"SAVE\" button")
    public void clickSave(){
        editContact.submit();
    }

    @Then("popup message $message appeared")
    public void checkPopupMsg(String message){
        Assert.assertEquals(grid.getPopupMsg(), message);
    }

    @When("he enters information to corresponding fields $name, $lastName, $twitter, $skype, $imgUrl, $notes")
    public void heEnters(String name, String lastName, String twitter, String skype, String imgUrl, String notes){
        editContact.fillNessessaryFields(name, lastName);
        editContact.fillUnnessessaryFields(twitter, skype, imgUrl, notes);
    }

    @When("he enters $name to the search field")
    public void searchField(String name){
        grid.searchFor(name);
    }

    @Then("the user with name $name $isPresent on the page")
    public void searchResultCheck(String name, String is){
        Assert.assertEquals(grid.isContactPresent(name), is.equals("is"));
    }
}
