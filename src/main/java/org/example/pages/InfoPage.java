package org.example.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
@Log4j2
public class InfoPage {
    WebDriver driver;
    WebDriverWait wait;
    public InfoPage(WebDriver driver) {
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "h6~button.oxd-button")
    WebElement attachmentAddButton;
    @FindBy(css = ".oxd-file-input")
    WebElement inputUploadFile;
    @FindBy(css = "button.oxd-button--medium:nth-of-type(2)")
    WebElement saveButtonforuploadedfile;
    @FindBy(css = "div.oxd-toast-icon-wrap--success")
    WebElement iconAlertSucsess;
    @FindBy(css="div.oxd-table>div.oxd-table-body>div>div>div.oxd-table-cell:nth-child(2)")
    WebElement nameFile;
    public InfoPage clickUploadButton() {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(attachmentAddButton));
            // Utilisez JavaScript pour faire défiler la page pour que l'élément cible soit visible.
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", attachmentAddButton);
            log.info("click on upload button");
            attachmentAddButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Upload button clicked");
        return this;}
    public InfoPage uploadFile(String filePath) {
        wait.until(ExpectedConditions.visibilityOf(inputUploadFile));
        log.info("Uploading file");
        File fileob = new File(filePath);
        inputUploadFile.sendKeys(fileob.getAbsolutePath());
        return this;
    }
    /*public InfoPage uploadFile(String filePath) {
        wait.until(ExpectedConditions.visibilityOf(inputUploadFile));
        log.info("click on the Add button");
        attachmentAddButton.click();
        wait.until(ExpectedConditions.visibilityOf(inputUploadFile));
        inputUploadFile.sendKeys(filePath);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-spinner")));
        return this;
    }*/
    public InfoPage saveFile(){
        wait.until(ExpectedConditions.visibilityOf(saveButtonforuploadedfile));
        log.info("click on save button");
        saveButtonforuploadedfile.click();
        return this;
    }
    public InfoPage successAlert(){
        log.info("Verification de l'alerte succès");
        wait.until(ExpectedConditions.visibilityOf(iconAlertSucsess));
        log.info("Success of uploading");
        return this;
    }
    public String getNameFile() {
        log.info("Get name of the File ...");
        wait.until(ExpectedConditions.visibilityOf(nameFile));
        String fileName = nameFile.getText();
        return fileName;
    }

}
