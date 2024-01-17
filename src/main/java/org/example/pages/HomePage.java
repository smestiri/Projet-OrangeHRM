package org.example.pages;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class HomePage {
     WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver= driver;
            PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
      @FindBy(css ="li:nth-child(2) > a > span" )
      WebElement PimButton;
      @FindBy(xpath = "//ul/li[1]/a/span")
      WebElement AdminButton;
      @FindBy(css = "a[href*='viewTimeModule']")
      WebElement TimeButton;
     @FindBy(css = "a[href*='viewMyDetails']")
     WebElement InfoButton;

    public PIMPage goToPIMPage(){
        wait.until(ExpectedConditions.visibilityOfAllElements(PimButton));
        log.info("click PIM Button");
        PimButton.click();
        return new PIMPage(driver);
    }
    public AdminPage goToAdminPage(){
        wait.until(ExpectedConditions.visibilityOfAllElements(AdminButton));
        log.info("click Admin Button");
        AdminButton.click();
        return new AdminPage(driver);

    }
    public TimePage goToTimePage() {
        wait.until(ExpectedConditions.visibilityOfAllElements(TimeButton));
        log.info("click Time Button");
        TimeButton.click();
        return new TimePage(driver);
    }
    public InfoPage goToInfoPage(){
        wait.until(ExpectedConditions.visibilityOfAllElements(InfoButton));
        log.info("click Info Button");
        InfoButton.click();
        return new InfoPage(driver);}

}
