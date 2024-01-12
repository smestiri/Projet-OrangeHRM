package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
    private final WebDriver driver;

        public PIMPage(WebDriver driver){

            this.driver= driver;
            PageFactory.initElements(driver, this);
            WebDriverWait wait;
        }
    @FindBy(name="firstName")
    private WebElement firstName;

    @FindBy(name="lastName")
    private WebElement lastName;

    @FindBy(css="[type='submit']")
    private WebElement submitBtn;

    public void inputFirstName(String fname){firstName. sendKeys(fname);}
    public void inputLastName(String lname){lastName. sendKeys(lname);}

    public void ViewPersonalDetails() {submitBtn.click();}


}

