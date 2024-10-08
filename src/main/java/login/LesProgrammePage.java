package login;

import net.bytebuddy.jar.asm.Handle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class LesProgrammePage {
    @FindBy(id="download")
    private WebElement telecharger;
    @FindBy(xpath = "//div/a[@href='https://www.efap.com/formation-communication/mba-specialises-communication' and text()='MBA spécialisés']")
    private WebElement mbaButton;
    WebDriver driver;
    private WebDriver.Navigation navigate;
    public  LesProgrammePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        navigate = driver.navigate();

    }
    public void listProgramme(String element){

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='four-columns three-rows active']/li"));
        for (WebElement liste :list){

            String listePro = liste.getText();
            System.out.println(listePro);
            if (listePro.equals(element)){
                Actions actions = new Actions(driver);
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
    public MbaSpecialitesPage clickMbaSpcialises(){
        mbaButton.click();
        return new MbaSpecialitesPage(driver);
    }

    public void ouvrirUneNouvelleFenetre(){
        String handlePr = driver.getWindowHandle();
       Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
        // Attendre que les nouvelles fenêtres soient complètement chargées
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       System.out.println(windows);
       for(String handle :windows){

           if (!handle.equals(handlePr)) {

               driver.switchTo().window(handle);
           String newHandles = driver.getTitle();

               // Si le titre correspond, sortir de la boucle
               System.out.println("Fenêtre trouvée avec le titre : " + newHandles);
               driver.close();
               break;
           }
           }
        driver.switchTo().window(handlePr);
       }








}
