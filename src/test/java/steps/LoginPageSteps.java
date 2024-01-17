package steps;

import io.cucumber.java.en.And;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSteps {
    LoginPage pageLogin;
    public LoginPageSteps(StandardSteps std){
        WebDriver driver = std.getDriver();
        pageLogin = PageFactory.initElements(driver, LoginPage.class);
    }
    @And("je renseigne un username {string}")
    public void renseignerUsername(String username){
        pageLogin.inputUserName(username);
    }
    @And("je renseigne un mot de passe {string}")
    public void renseignerPassword(String password){
        pageLogin.inputPassWord(password);
    }
    @And("je clique sur le bouton connexion")
    public void clickerLogin(){
        pageLogin.clickLoginButton();
    }



}
