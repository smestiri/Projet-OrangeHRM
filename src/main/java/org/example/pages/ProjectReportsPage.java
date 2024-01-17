package org.example.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
@Log4j2
public class ProjectReportsPage {
    WebDriver driver;
    WebDriverWait wait;
    public ProjectReportsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Type for hints...']")
    WebElement projectName;
    List<String> projects = Arrays.asList("ACME", "COCA", "APACHE", "FRESH BOOKS");
    @FindBy(className = "oxd-button")
    WebElement viewButton;
    @FindBy(css = "div.oxd-report-table-footer span.oxd-text--footer")
    WebElement totalDurationText;
    // Variable pour stocker la somme des temps individuels
    double sum;
    public ProjectReportsPage selectProject() {
        // Attendre quelques secondes pour voir le résultat
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(projectName));

        for (String Element : projects) {
            projectName.sendKeys(Element);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement premierElement = driver.findElement(By.cssSelector("div.oxd-autocomplete-dropdown div"));
            log.info("select project: " + Element);
            premierElement.click();
            log.info("click on view buttom");
            wait.until(ExpectedConditions.visibilityOf(viewButton));
            viewButton.click();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wait.until(ExpectedConditions.visibilityOfAllElements(totalDurationText));
            String totalDuration = totalDurationText.getText();
            //replaceAll("[^\\d.]", "") est utilisée pour extraire uniquement les chiffres et le point décimal de la chaîne
            String durationValue = totalDuration.replaceAll("[^\\d.]", "");
            try {
                Assert.assertEquals(sumTimesValues(), Double.parseDouble(durationValue));
                log.info("Total Duration (Hours) matches the sum Times Values");
            } catch (AssertionError e) {
                log.error("Assertion Error: Total Duration (Hours) doesn't match the esum Times Values");
                throw e; // Rethrow the assertion error to mark the test as failed
            }
            driver.navigate().refresh();
            // Attendre quelques secondes pour voir le résultat
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return this;
    }

    public double sumTimesValues() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".col-alt")));
        List<WebElement> timeElements = driver.findElements(By.cssSelector(".col-alt"));
        sum = 0.00;
        for (WebElement timeElement : timeElements) {
            double timeValue = Double.parseDouble(timeElement.getText());
            sum += timeValue;
        }
        return sum;
    }
    // Méthode pour rechercher les projets et vérifier que le temps total correspond à la somme des temps
    /*public void searchAndVerifyTotalDuration() {
        for (String project : projects) {
            projectName.sendKeys(project);
            viewButton.click();
            // Attendre que la page se mette à jour avec les résultats de recherche
            wait.until(ExpectedConditions.visibilityOf(totalDurationText));
            double projectDuration = extractProjectDuration();
            // Ajouter la durée du projet à la somme totale
            sum += projectDuration;
            // Effacer le champ de recherche pour le projet suivant
            projectName.clear();
        }

        // Obtenir le temps total affiché sur la page
        String totalDurationTextValue = totalDurationText.getText();
        double totalDurationValue = Double.parseDouble(totalDurationTextValue);
        // Vérifier que le temps total correspond à la somme des temps individuels
        if (totalDurationValue == sum) {
            System.out.println("Le temps total correspond à la somme des temps individuels.");
        } else {
            System.out.println("Le temps total ne correspond pas à la somme des temps individuels.");
        }
    }
    private double extractProjectDuration() {
        WebElement projectDurationElement = driver.findElement(By.cssSelector("div.project-duration"));
        String projectDurationText = projectDurationElement.getText();
        return Double.parseDouble(projectDurationText);
    }*/

}
