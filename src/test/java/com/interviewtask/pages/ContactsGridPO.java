package com.interviewtask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.interviewtask.utils.DriverUtil.getDriver;


public class ContactsGridPO {
    private By addContactButton = By.xpath(".//button[@aria-label=\"Add contact\"]");
    private By settings = By.xpath(".//button[@aria-label=\"Settings\"]");
    private By popupMsg = By.cssSelector("md-toast[md-theme]>span");
    private By searchField = By.id("input_24");

    public void open(){
        getDriver().get("http://ft-alexander-golovko.cl.dreamfactory.com/files/AddressBookForAngularJS/add_angular/index.html#/contacts");
    }

    public void addNewContact(){
        getDriver().findElement(addContactButton).click();
    }

    public String getPopupMsg(){
        return getDriver().findElement(popupMsg).getText();
    }

    public void searchFor(String searchWord){
        getDriver().findElement(searchField).sendKeys(searchWord);
        getDriver().findElement(searchField).sendKeys(Keys.RETURN);
    }

    public boolean isContactPresent(String name){
        return !getDriver().findElements(By.xpath(".//td[.='\\n\\t\\t\\t\\t" + name + "\n\t\t\t" +"']")).isEmpty();
    }

    public void openSettings(){
        getDriver().findElement(settings).click();
    }
}
