package org.example.pages;

import com.beust.jcommander.Parameterized;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Log4j2
public class AdminPage {
    WebDriver driver;
    WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "button.oxd-button--secondary:nth-child(1)")
    WebElement addButton;
    @FindBy(xpath ="//label[text()= 'User Role']/ancestor::div[@data-v-957b4417]/div/div")
    WebElement userRole;
    @FindBy(xpath = "//div[@class='oxd-select-option']//span[text()='Admin']")
    WebElement chooseAdmin;
    @FindBy(xpath = "//label[text()= 'Status']/ancestor::div[@data-v-957b4417]/div/div")
    WebElement statuts;
    @FindBy(xpath = "//div[@class='oxd-select-option']//span[text()='Enabled']")
    WebElement chooseEnabled;
    @FindBy(xpath = "//div/div[2]/div/div[2]/div/div/input")
    WebElement employeeName;
    @FindBy(xpath = "//label[text()='Username']/ancestor::div[@data-v-957b4417]/div/input")
    WebElement userName;
    @FindBy(xpath = "//label[text()='Password']/ancestor::div[@data-v-957b4417]/div/input")
    WebElement passWord;
    @FindBy(xpath = "//label[text()='Confirm Password']/ancestor::div[@data-v-957b4417]/div/input")
    WebElement confirmPW;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement saveButton;
    @FindBy(css = ".oxd-userdropdown-icon")
    WebElement profilButtom;
    @FindBy(css = "a[href*='logout']")
    WebElement logout;


    public AdminPage clickAddButton(){
        wait.until(ExpectedConditions.visibilityOfAllElements(addButton));
        addButton.click();
        return this;
    };
    public AdminPage setUserRoleToAdmin (){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.visibilityOf(userRole));
        log.info("click on user Roles");
        userRole.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.visibilityOf(chooseAdmin));
        log.info("Click on Admin");
        chooseAdmin.click();

        return this;}

    public AdminPage setStatutsToEnable() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.visibilityOf(statuts));
        log.info("click on statuts");
        statuts.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.visibilityOf(chooseEnabled));
        log.info("Click on Enabled");
        chooseEnabled.click();
        return this;}

    public AdminPage setEmployeeName(String name) {
        wait.until(ExpectedConditions.visibilityOf(employeeName));
        log.info("set Employee name: [{}]",name);
        employeeName.sendKeys(name);
        employeeName.sendKeys(Keys.RETURN);
        log.info("Person found in search results.");
        return this;
    }

    public AdminPage setUserName(String uName) {
        wait.until(ExpectedConditions.visibilityOf(userName));
        log.info("set username");
        userName.sendKeys(uName);
        return this;
    }
    public AdminPage setPassWord(String pWord) {
        wait.until(ExpectedConditions.visibilityOf(passWord));
        log.info("set password");
        passWord.sendKeys(pWord);
        return this;
    }
    public AdminPage setConfirmPW(String cPW) {
        wait.until(ExpectedConditions.visibilityOf(confirmPW));
        log.info("confirm password");
        confirmPW.sendKeys(cPW);
        return this;
    }
    public AdminPage setSaveButton(){
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        log.info("Click on Save button");
        saveButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;}
    public AdminPage setProfilButton(){wait.until(ExpectedConditions.visibilityOf(profilButtom));
        log.info("click on profil button");
        profilButtom.click();
        return this;}
    public LoginPage setLogout(){
        wait.until(ExpectedConditions.visibilityOf(logout));
        log.info("click on logout buttom");
        logout.click();
        return new LoginPage(driver);
    }



}
