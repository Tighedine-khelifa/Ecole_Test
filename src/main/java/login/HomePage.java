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

public class HomePage {
    @FindBy(id = "sec")
    private WebElement header;

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getUrlPage(){
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        return URL;
    }
    public void getliste(String text){
        Actions actions = new Actions(driver);

        List<WebElement> Liste= header.findElements(By.tagName("a"));

        out.println("Found " + Liste.size() + " elements inside the header:");
        for (WebElement element:Liste){
            String textElement = element.getText();
            out.println(textElement);

            if (textElement.equals(text)){
               actions.moveToElement(element).perform();
                return;
            }

        }
         out.println("je ne trouve pas ");
    }




}
