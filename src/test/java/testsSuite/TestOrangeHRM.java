package testsSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.beust.jcommander.Parameterized;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.example.pages.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Log4j2
public class TestOrangeHRM {
    WebDriver driver;


    @BeforeMethod
    public void setup (){
       driver = new FirefoxDriver();
       driver.manage().window().maximize();
        System.out.println("opened successfully");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        // Configurez les options pour le mode headless
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");

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
    @Test
    public void CamembertTest(){
        //Arrange
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Act
        loginPage.goToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.inputUserName("Admin");
        loginPage.inputPassWord("admin123");
        loginPage.clickLoginButton();
        homePage.clickOnLegend();
        homePage.isLegendStrikethrough();
    }
    @AfterMethod
    public void captureScreen(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String name = "screenshot.png";
            try {
                FileUtils.copyFile(scrFile, new File("test-output/screenshots/" + name));
            } catch (IOException e) {
                log.error("screenshot failed");
                throw new RuntimeException(e);
            }
        }
    }
    /*@AfterMethod
    public void teardown(){
        driver.quit();
        System.out.println("Teardown successful !");}*/
}
