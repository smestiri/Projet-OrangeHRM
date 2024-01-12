package org.example.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

import static java.sql.JDBCType.TIME;

@Log4j2
public class LoginPage {

        WebDriver driver;
        WebDriverWait wait;

        @FindBy(xpath = "//input[@class=\"oxd-input oxd-input--active\" and @name=\"username\"]")
        WebElement InputUsername;
        @FindBy(xpath="//input[@type=\"password\"]")
        WebElement InputPassword;
        @FindBy(css="[type=submit]")
                //@FindBy(className = "oxd-button")
        WebElement loginButton;

        public void goToLoginPage(String url){driver.get(url);}
       public LoginPage(WebDriver driver) {
               this.driver = driver;
               wait = new WebDriverWait(driver, Duration.ofSeconds(8));
               PageFactory.initElements(driver, this);
       }

        public LoginPage inputUserName(String username) {
                wait.until(ExpectedConditions.visibilityOf(InputUsername));
                log.info("Entering username" );
                InputUsername.sendKeys(username);
                return this;
        }
        public LoginPage inputPassWord(String password) {
                wait.until(ExpectedConditions.visibilityOf(InputPassword));
                log.info("Entering password");
                InputPassword.sendKeys(password);
                return this;
        }
        public HomePage clickLoginButton(){
                log.info("Clicking on login button");
                loginButton.click();
                return new HomePage(driver);
        }

}



