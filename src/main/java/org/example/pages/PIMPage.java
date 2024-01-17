package org.example.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@Log4j2
public class PIMPage {
    private final WebDriver driver;
    WebDriverWait wait;

        public PIMPage(WebDriver driver){

            this.driver= driver;
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        }
    @FindBy(css = "button.oxd-button--secondary:first-child")
    WebElement AddButton;
    @FindBy(css = "input[name='firstName']")
    WebElement firstName;
    @FindBy(css = "input[name='middleName']")
    WebElement middleName;
    @FindBy(css = "input[name='lastName']")
    WebElement lastName;
    @FindBy(className = "oxd-switch-input")
    WebElement createLoginDetailsButton;
    @FindBy(xpath = "//label[text()='Username']/ancestor::div[@data-v-957b4417]/div/input")
    WebElement userNameDetails;
    @FindBy(xpath = "//label[text()='Password']/ancestor::div[@data-v-957b4417]/div/input")
    WebElement passwordDetails;
    @FindBy(xpath = "//label[text()='Confirm Password']/ancestor::div[@data-v-957b4417]/div/input")
    WebElement confirmPasswordDetails;
    @FindBy(css="button.oxd-button:nth-child(3)")
    WebElement submitBtn;
    public PIMPage clickAddButton() {
        wait.until(ExpectedConditions.visibilityOfAllElements(AddButton));
        log.info("click on the Add button");
        AddButton.click();
        return this;
    }
    public PIMPage inputFirstName(String firstname) {
    wait.until(ExpectedConditions.visibilityOf(firstName));
    log.info("Renseigner firstname");
    firstName.sendKeys(firstname);
    return this;}
    public PIMPage inputMiddleName(String middlename){
        wait.until(ExpectedConditions.visibilityOf(middleName));
        log.info("Renseigner middlename");
        middleName. sendKeys(middlename);
        return this;}
    public PIMPage inputLastName(String lastname){
        wait.until(ExpectedConditions.visibilityOf(lastName));
        log.info("Renseigner lastname");
        lastName. sendKeys(lastname);
    return this;}
    public PIMPage inputUsernameDetails(String usernamedetails) {
        wait.until(ExpectedConditions.visibilityOfAllElements(userNameDetails));
        log.info("Entering username");
        userNameDetails.sendKeys(usernamedetails);
        return this;
    }

    public PIMPage inputPasswordDetails(String passworddetails) {
        wait.until(ExpectedConditions.visibilityOfAllElements(passwordDetails));
        log.info("Entering password");
        passwordDetails.sendKeys(passworddetails);
        return this;
    }

    public PIMPage confirmPasswordDetails(String Confpassworddetails) {
        wait.until(ExpectedConditions.visibilityOfAllElements(confirmPasswordDetails));
        log.info("Entering confirm password");
        confirmPasswordDetails.sendKeys(Confpassworddetails);
        return this;
    }
    public PIMPage clickLoginDetailsBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-switch-input--active")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.elementToBeClickable(createLoginDetailsButton));
        log.info("click on Create Login Details button");
        createLoginDetailsButton.click();

        return this;
    }


    public PIMPage ViewPersonalDetails() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.visibilityOfAllElements(submitBtn));
        log.info("Clicking on save button");
        submitBtn.click();
        return this;
    }


}

