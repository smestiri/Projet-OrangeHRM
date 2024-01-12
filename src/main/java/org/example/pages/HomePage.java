package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
     WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver= driver;
            PageFactory.initElements(driver, this);
            WebDriverWait wait;
    }
      @FindBy(css ="li:nth-child(2) > a > span" )
      WebElement PimButton;
      @FindBy(xpath = "//ul/li[1]/a/span")
      WebElement AdminButton;
    public void goToPIMPage(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        PimButton.click();
        new PIMPage(driver);
    }
    public void goToAdminPage(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        AdminButton.click();
        new AdminPage(driver);

    }

}
