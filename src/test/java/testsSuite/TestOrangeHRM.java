package testsSuite;

import lombok.extern.log4j.Log4j2;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    public void testOrangeHRM(){
        //Arrange
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePages = new HomePage(driver);

        loginPage.goToLoginPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.inputUsername("Admin");
        loginPage.inputPassword("admin123");
        loginPage.goToHomePage();

    }
}
