package testsSuite;

import com.beust.jcommander.Parameterized;
import lombok.extern.log4j.Log4j2;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
   public void CreatePIM(){
        //Arrange
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PIMPage pimPage= new PIMPage(driver);

        //Act
        loginPage.goToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.inputUserName("Admin");
        loginPage.inputPassWord("admin123");
        loginPage.clickLoginButton();
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        homePage.goToPIMPage();
        pimPage.clickAddButton();
        pimPage.inputFirstName("Sirine");
        pimPage.inputMiddleName("sir");
        pimPage.inputLastName("Mestiri");
        pimPage.clickLoginDetailsBtn();
        pimPage.inputUsernameDetails("smestiri");
        pimPage.inputPasswordDetails("Mestiri123");
        pimPage.confirmPasswordDetails("Mestiri123");
        pimPage.ViewPersonalDetails();
        //Assert
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    /*@AfterMethod
    public void teardown(){
        driver.quit();
        System.out.println("Teardown successful !");}*/
    @Test
    public void CreateAdmin(){
    //Arrange
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AdminPage adminPage = new AdminPage(driver);
    //Act
        loginPage.goToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.inputUserName("Admin");
        loginPage.inputPassWord("admin123");
        loginPage.clickLoginButton();
        homePage.goToAdminPage();
        adminPage.clickAddButton();
        adminPage.setUserRoleToAdmin();
        adminPage.setStatutsToEnable();
        adminPage.setEmployeeName("Sirine sir Mestiri");
        adminPage.setUserName("sm.autom");
        adminPage.setPassWord("Mestiri123");
        adminPage.setConfirmPW("Mestiri123");
        adminPage.setSaveButton();
        adminPage.setProfilButton();
        adminPage.setLogout();
        loginPage.inputUserName("sm.autom");
        loginPage.inputPassWord("Mestiri123");
        loginPage.clickLoginButton();
    }
    /*@AfterMethod
    public void teardown(){
        driver.quit();
        System.out.println("Teardown successful !");}*/
    @Test
    public void Uploaddocument(){
        //Arrange
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        InfoPage infoPage = new InfoPage(driver);
        //Act
        loginPage.goToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.inputUserName("Admin");
        loginPage.inputPassWord("admin123");
        loginPage.clickLoginButton();
        homePage.goToInfoPage();
        infoPage.clickUploadButton();
        infoPage.uploadFile("Navigo Fev1.jpeg");
        infoPage.saveFile();
        infoPage.successAlert();
        infoPage.getNameFile();
    }
   /*@AfterMethod
    public void teardown(){
        driver.quit();
        System.out.println("Teardown successful !");}*/
   @Test
   public void TimeProject(){
       //Arrange
       LoginPage loginPage = new LoginPage(driver);
       HomePage homePage = new HomePage(driver);
       TimePage timePage = new TimePage(driver);
       ProjectReportsPage projectReportsPage = new ProjectReportsPage(driver);
       //Act
       loginPage.goToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       loginPage.inputUserName("Admin");
       loginPage.inputPassWord("admin123");
       loginPage.clickLoginButton();
       homePage.goToTimePage();
       timePage.clickReport();
       timePage.goToProjectReport();
       projectReportsPage.selectProject();
   }
   /*@AfterMethod
    public void teardown(){
        driver.quit();
        System.out.println("Teardown successful !");}*/


}
