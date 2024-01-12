package testsSuite;

import lombok.extern.log4j.Log4j2;
import org.example.pages.AdminPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.PIMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class TestOrangeHRM {
    WebDriver driver;
    @BeforeMethod
    public void setup (){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        log.info("opened successfully");
    }
    @Test
    public void testOrangeHRM1(){
        //Arrange
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePages = new HomePage(driver);
        PIMPage pimPage= new PIMPage(driver);

        //Act
        loginPage.goToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.inputUserName("Admin");
        loginPage.inputPassWord("admin123");
        loginPage.clickLoginButton();
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        homePages.goToPIMPage();
        pimPage.inputFirstName("Sirine");
        pimPage.inputLastName("Mestiri");
        pimPage.ViewPersonalDetails();
        //Assert
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
        System.out.println("Teardown successful !");}
    @Test
    public void testOrangeHRM2(){
    //Arrange
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePages = new HomePage(driver);
        AdminPage adminPage = new AdminPage(driver);
    //Act
        loginPage.goToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.inputUserName("Admin");
        loginPage.inputPassWord("admin123");
        loginPage.clickLoginButton();
        homePages.goToAdminPage();
        adminPage.clickAddButton();
        adminPage.setUserRole("Admin");
        adminPage.setStatuts("Enabled");
        adminPage.setEmployeeName("Sirine Mestiri");
        adminPage.setUserName("sm.autom");
        adminPage.setPassWord("Sirine123");
        adminPage.setConfirmPW("Sirine123");
        adminPage.setSaveButton();
    }
    @Test
    public void testOrangeHRM3(){

    }


}
