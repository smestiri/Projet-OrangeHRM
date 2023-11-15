package org.example.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.sql.JDBCType.TIME;

@Log4j2
public class LoginPage {
        WebDriver driver;
        public LoginPage(WebDriver driver){

            this.driver= driver;
            PageFactory.initElements(driver, this);
        }
        @FindBy(xpath = "//input[@class='oxd-input' and @name='username']")
        WebElement InputUsername;
        @FindBy(name="password")
        WebElement InputPassword;
        @FindBy(css="[type=submit]")
        WebElement LoginButton;

        public void goToLoginPage(String url){driver.get(url);}

        /*public void goToHomePage(String username, String password) {
                InputUsername. sendKeys(username);
                InputPassword. sendKeys(password);
                LoginButton. click();
                new HomePage(driver);
                log.info("La connexion est OK");
        }*/
        public void inputUsername(String username){
                InputUsername. sendKeys(username);
        }
        public void inputPassword(String password){
                InputPassword. sendKeys(password);
        }
        public void goToHomePage(){
                LoginButton. click();
                new HomePage(driver);
                log.info("La connexion est OK");
        }

}



