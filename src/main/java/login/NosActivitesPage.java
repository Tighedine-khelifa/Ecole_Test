package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NosActivitesPage {
    @FindBy(xpath = "//h3[text()='Festival de Cannes : Mélina, Assistante Communication et Marketing au sein de l’hôtel 5 étoiles, Mondrian Cannes']")
    private WebElement festivalDeCannes;
    @FindBy(xpath= "//p[text()='À l’occasion du Festival de Cannes, Mélina, étudiante en 4e année sur le campus d’Aix-en-Provence nous partage son expérience au sein du très prestigieux hôtel Mondrian Cannes.']")
    private WebElement textFestivalDeCannes;

    @FindBy(xpath = "//h3[text()='Le Parolo Project : un projet RP international pour les étudiants de 2e année 100% anglais']")
    private WebElement paroloProject;
    private WebDriver driver;
    public  NosActivitesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String getTitleNosActivites(){
        String title = driver.getCurrentUrl();
        System.out.println(title);
        return title;
    }

    public void clickFestivaleDeCannesBas(){
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(festivalDeCannes));
                action.moveToElement(festivalDeCannes).perform();
        System.out.println(festivalDeCannes.getText());
        if (textFestivalDeCannes.isDisplayed()){
            festivalDeCannes.click();
        }
    }

}
