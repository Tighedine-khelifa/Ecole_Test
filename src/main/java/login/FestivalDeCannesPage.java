package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.System.out;

public class FestivalDeCannesPage {

     WebDriver driver;
    public FestivalDeCannesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public void optionHeader(String element) {
        // Trouver tous les éléments <li> dans la liste <ul> avec la classe spécifiée
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='five-columns two-rows active']/li"));

        // Parcourir chaque élément <li> trouvé
        for (WebElement listItem : list) {
            // Obtenir le texte de l'élément <li> actuel
            String text = listItem.getText();
            System.out.println(text);

            // Vérifier si le texte de l'élément <li> correspond au texte recherché
            if (text.equals(element)) {
                // Cliquer sur l'élément <li> correspondant
                listItem.click();
                // Optionnel : arrêter la boucle après avoir cliqué sur l'élément
                break;
            }

        }
    }

}
