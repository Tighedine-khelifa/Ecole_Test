package login;


import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MusicBusinessPage {
    @FindBy(css = "img[alt='MBA Music Business Management - École de Communication EFAP']")
            private WebElement musicButton;
    @FindBy(id="axeptio_btn_acceptAll")
            private WebElement popsButton;

    WebDriver driver;
    public MusicBusinessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public void clickMusicBusiness(){
       String text = musicButton.getText();

        System.out.println(text);
        musicButton.click();
        Set<String> handlesId = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(handlesId);
        for (String window:windowList){
            String title =  driver.switchTo().window(window).getTitle();;

            if(title.equals("Formation Management Musique ICART - MBA Music Business Management")){

                System.out.println(driver.getCurrentUrl());
                popsButton.click();

               driver.close();

            }

        }

        // Revenir à la fenêtre principale
        driver.switchTo().window(windowList.get(0));
        System.out.println(driver.getCurrentUrl());

        WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(3));
        try {
            mywait.until(ExpectedConditions.alertIsPresent());
            Alert myalert = driver.switchTo().alert();
            System.out.println(myalert.getText());
        }catch(TimeoutException e) {
            System.out.println("pas d'alert");
        }

    }
}
