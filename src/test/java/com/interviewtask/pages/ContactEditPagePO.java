package com.interviewtask.pages;

import org.openqa.selenium.By;

import static com.interviewtask.utils.DriverUtil.getDriver;

public class ContactEditPagePO {
    private By firstName = By.id("input_43");
    private By lastName = By.id("input_44");
    private By twitter = By.id("input_45");
    private By skype = By.id("input_46");
    private By imageURL = By.id("input_47");
    private By notes = By.id("input_48");
    private By submitButton = By.xpath(".//button[@type=\"submit\"]");


    public void fillNessessaryFields(String firstName, String lastName){
        getDriver().findElement(this.firstName).sendKeys(firstName);
        getDriver().findElement(this.lastName).sendKeys(lastName);

    }

    public void fillUnnessessaryFields(String twitter, String skype, String imageURL, String notes){
        getDriver().findElement(this.twitter).sendKeys(twitter);
        getDriver().findElement(this.skype).sendKeys(skype);
        getDriver().findElement(this.imageURL).sendKeys(imageURL);
        getDriver().findElement(this.notes).sendKeys(notes);
    }

    public void fillUnnessessaryFields(String skype, String twitter){
        getDriver().findElement(this.twitter).sendKeys(twitter);
        getDriver().findElement(this.skype).sendKeys(skype);
    }

    public void fillUnnessessaryFields(String imageURL){
        getDriver().findElement(this.imageURL).sendKeys(imageURL);
    }

    public void submit(){
        getDriver().findElement(submitButton).click();
    }

    public boolean isOpened(){
       return  !getDriver().findElements(submitButton).isEmpty();
    }

}
