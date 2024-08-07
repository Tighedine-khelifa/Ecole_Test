package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MbaSpecialitesPage {

    @FindBy(css = "a[href='https://www.efap.com/formation-communication/mba-mode-et-communication']")
    private WebElement enSavoirPlus;
    private WebDriver driver;
    public MbaSpecialitesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void selectLesThematiques(String option){

        WebElement select = driver.findElement(By.id("select2-thematique-container"));
        select.click();
        System.out.println("Select option " +select.getText());
        List<WebElement> listThematique = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
        for (WebElement thematique:listThematique){
            System.out.println(thematique.getText());
            if (thematique.getText().equals(option)){
                thematique.click();
                break;
            }

        }
        WebElement optionDigital = driver.findElement(By.id("select2-thematique-container"));
        System.out.println(optionDigital.getText());



    }
    public void selectCity(String city) {
        WebElement selectElement = driver.findElement(By.id("select2-campus-container"));
        selectElement.click();
        List<WebElement> selects = driver.findElements(By.cssSelector("li.select2-results__option"));
        System.out.println(selects);
        for (WebElement select:selects){
            if(select.getText().equals(city)){
                select.click();
                break;
            }
        }


    }

    public CommunicationFashionPage clickFashionPage(){
         enSavoirPlus.click();
         return  new CommunicationFashionPage(driver);
    }

}
