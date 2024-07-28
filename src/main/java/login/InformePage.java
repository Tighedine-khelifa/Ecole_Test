package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InformePage {
    @FindBy(id = "sec")
    private WebElement header;
    WebDriver driver;
    public InformePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getUrlPage(){
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        return URL;
    }
    public void getliste(String text){
        List<WebElement> Liste= header.findElements(By.tagName("a"));

        System.out.println("Found " + Liste.size() + " elements inside the header:");
        for (WebElement element:Liste){
            String textElement = element.getText();
            System.out.println(textElement);

            if (textElement.equals(text)){
                moveToElement(element);
                return;
            }

        }
         System.out.println("je ne trouve pas ");
    }
    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);

        actions.moveToElement(element).perform();

        if (element.getText().equals(0)){
            System.out.println("l'element est bien survoler");

        }
    }
}
