package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.example.pages.PIMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PIMPageSteps {
    PIMPage pimpage;
    public PIMPageSteps(StandardSteps std){
        WebDriver driver = std.getDriver();
        pimpage = PageFactory.initElements(driver, PIMPage.class);
    }
    @And("je clique sur le bouton ADD")
    public void clickerAddButton() {
        pimpage.clickAddButton();
    }
    @And("je renseigne un firstname {string}")
    public void renseignerFirstname(String firstname) {
        pimpage.inputFirstName(firstname);
    }
    @And("je renseigne un middlename {string}")
    public void renseignerMiddlename(String middlename) {
        pimpage.inputMiddleName(middlename);
    }
    @And("je renseigne un lastname {string}")
    public void renseignerlastname(String lastname) {
        pimpage.inputLastName(lastname);
    }
    @And("je clique sur le bouton create login details")
    public void cliquerBtnDetails(){
        pimpage.clickLoginDetailsBtn();
    }
    @And("je renseigne un username details {string}")
    public void renseignerusernamedetails(String usernamedetails) {
        pimpage.inputUsernameDetails(usernamedetails);
    }
    @And("je reseigne un password details {string}")
    public void renseignerpassworddetails(String passworddetails) {
        pimpage.inputPasswordDetails(passworddetails);
    }
    @When("je confirme le password details {string}")
    public void confirmerpassworddetails(String Confpassworddetails) {

        pimpage.confirmPasswordDetails(Confpassworddetails);
    }
    @Then("je clique sur le bouton save pour valider la création")
    public void clickersave() {
        pimpage.ViewPersonalDetails();
    }
}
