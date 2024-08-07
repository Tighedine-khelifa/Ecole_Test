package login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommunicationFashionPage {


    WebDriver driver;
    public CommunicationFashionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void clickStartVideo(){
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonStart =  driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        if (buttonStart.isDisplayed()) {
            buttonStart.click();
        } else {
            System.out.println("Le bouton de lecture n'est pas visible.");
        }
    }
}
