package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.System.out;

public class InformePage {
    @FindBy(id = "sec")
    private WebElement header;
    @FindBy(xpath = "//a[@href='https://www.efap.com/agenda/portes-ouvertes' and text()='Portes ouvertes']")
            private WebElement porteOuvrtes;
    WebDriver driver;
    public InformePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getUrlPage(){
        String URL = driver.getCurrentUrl();
        out.println(URL);
        return URL;
    }
    public void getliste(String text){
        List<WebElement> Liste= header.findElements(By.tagName("a"));

        out.println("Found " + Liste.size() + " elements inside the header:");
        for (WebElement element:Liste){
            String textElement = element.getText();
            out.println(textElement);

            if (textElement.equals(text)){
                moveToElement(element);
                return;
            }

        }
         out.println("je ne trouve pas ");
    }
    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);

        actions.moveToElement(element).perform();
        out.println(porteOuvrtes.getText());

         new WebDriverWait(driver, Duration.ofSeconds(5));

        if (porteOuvrtes.isDisplayed()){
        porteOuvrtes.click();
        }else {
            out.println("erreur");
        }





    }
}
