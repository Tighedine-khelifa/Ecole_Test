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
    public MbaSpecialitesPage clickMbaSpcialises(){
        mbaButton.click();
        return new MbaSpecialitesPage(driver);
    }

    public void ouvrirUneNouvelleFenetre(String title){
       var windows =  driver.getWindowHandles();
       System.out.println(windows);
       for(String window :windows){
           driver.switchTo().window(window);
           System.out.println(driver.getTitle());

           if(title.equals(driver.getTitle())){
               break;
           }
       }



    }



}
