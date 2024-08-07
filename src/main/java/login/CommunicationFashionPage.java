package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommunicationFashionPage {
    WebDriver driver;
    public CommunicationFashionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
