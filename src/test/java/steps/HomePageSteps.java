package steps;

import io.cucumber.java.en.And;
import org.example.pages.HomePage;
import org.example.pages.PIMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageSteps {
    HomePage homepage;
    public HomePageSteps(StandardSteps std){
        WebDriver driver = std.getDriver();
        homepage = PageFactory.initElements(driver, HomePage.class);
    }
    @And("je clique sur PIM")
    public void clickerPimPage(){
        homepage.goToPIMPage();
    }
}
