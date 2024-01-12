package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
    private WebDriver driver;
    public AdminPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait;
    }
    @FindBy(xpath = "//div[2]/div[1]/button")
    private WebElement addButton;
    @FindBy(xpath = "//div[1]/div/div[1]/div/div[2]/div/div")
    private WebElement userRole;
    @FindBy(xpath = "//div/div[3]/div/div[2]/div/div/div[1]")
    private WebElement statuts;
    @FindBy(xpath = "//div/div[2]/div/div[2]/div/div/input")
    private WebElement employeeName;
    @FindBy(xpath = "//div[1]/div/div[4]/div/div[2]/input")
    private WebElement userName;
    @FindBy(xpath = "//div/div[1]/div/div[2]/input")
    private WebElement passWord;
    @FindBy(xpath = "//div[2]/div/div[2]/div/div[2]/input")
    private WebElement confirmPW;
    @FindBy(xpath = "//div[3]/button[2]")
    private WebElement saveButton;

    public void clickAddButton(){addButton.click();};
    public void setUserRole (String uRole){userRole. sendKeys(uRole);}

    public void setStatuts(String stat) {statuts.sendKeys(stat);}

    public void setEmployeeName(String eName) {employeeName.sendKeys(eName);}
    public void setUserName(String uName) {userName.sendKeys(uName);}

    public void setPassWord(String pWord) {passWord.sendKeys(pWord);}
    public void setConfirmPW(String cPW) {confirmPW.sendKeys(cPW);}
    public void setSaveButton(){saveButton.click();}


}
