package login;

import net.bytebuddy.jar.asm.Handle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class LesProgrammePage {
    @FindBy(id="download")
    private WebElement telecharger;
    private WebDriver.Navigation navigate;
    WebDriver driver;
    public  LesProgrammePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        navigate = driver.navigate();
    }
    public void listProgramme(String element){
     Actions actions = new Actions(driver);
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='four-columns three-rows active']/li"));
        for (WebElement liste :list){

            String listePro = liste.getText();
            System.out.println(listePro);
            if (listePro.equals(element)){
                actions.moveToElement(liste).perform();
                liste.click();
                break;
            }

        }

    }

    public void clickTelechargement(){
        List<WebElement> buttons = driver.findElements(By.xpath("//a[text()='Télécharger le référentiel de compétences']"));
        if(buttons.size()>=2){
           WebElement buttons1 = buttons.get(1);
           buttons1.click();
        }
    }
    public void SwitchToSecondWindow(){
        // Obtenez tous les handles de fenêtres/onglets ouverts
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Number of tabs: " + windowHandles.size());
        // Convertir le Set en tableau
        String[] handles = windowHandles.toArray(new String[0]);
        if (handles.length>=2){
            driver.switchTo().window(handles[1]);
            //  Vérifiez si j'ai réussi à passer au bon onglet
            System.out.println("Switched to window with handle: " + handles[1]);
            // Imprimer le titre de la nouvelle page pour vérifier
            System.out.println("New tab title: " + driver.getTitle());

            // Vous pouvez vérifier l'URL pour s'assurer que c'est la page PDF attendue
            String currentURL = driver.getCurrentUrl();
            if (currentURL.endsWith(".pdf")) {
                System.out.println("Le document PDF est ouvert: " + currentURL);
            }
        }
        // Identifier et cliquer sur le bouton de téléchargement
        try {
            // Modifier le sélecteur selon la structure réelle de votre page
            telecharger.click();
            System.out.println("Le bouton de téléchargement a été cliqué.");
        } catch (Exception e) {
            System.out.println("Le bouton de téléchargement n'a pas été trouvé ou n'a pas pu être cliqué.");
            e.printStackTrace();
        }

        // Créer une instance de JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Faire défiler jusqu'en bas de la page
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }


}
