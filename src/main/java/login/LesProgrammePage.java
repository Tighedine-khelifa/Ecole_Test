package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LesProgrammePage {

    WebDriver driver;
    public  LesProgrammePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void listProgramme(String element){

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='four-columns three-rows active']/li"));
        for (WebElement liste :list){
            String listePro = liste.getText();
            System.out.println(listePro);
            if (listePro.equals(element)){
                liste.click();
            }else {
                System.out.println("Element introuvable");
            }
            break;
        }

    }
}
