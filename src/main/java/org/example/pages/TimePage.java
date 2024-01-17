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
public class TimePage {
    WebDriver driver;
    WebDriverWait wait;
    public TimePage(WebDriver driver) {
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//span[contains(text(),'Reports')]")
    WebElement reportsButton;
    @FindBy(xpath = "//a[text()='Project Reports']")
    WebElement projectreportsButtom;
    public TimePage clickReport() {
        wait.until(ExpectedConditions.visibilityOf(reportsButton));
        log.info("click on report button ");
        reportsButton.click();
        return this;
    }
    public ProjectReportsPage goToProjectReport() {
        wait.until(ExpectedConditions.visibilityOf(projectreportsButtom));
        log.info("click on project reports button ");
        projectreportsButtom.click();
        return new ProjectReportsPage(driver);

    }
}
