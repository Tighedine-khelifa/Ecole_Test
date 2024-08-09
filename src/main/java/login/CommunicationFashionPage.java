package login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommunicationFashionPage {


    WebDriver driver;

    public CommunicationFashionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickStartVideo() {
        // Attendre que l'iframe soit disponible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://www.youtube.com/embed/_1N3XSllFO0?si=URfrhrVbaI7fcglN&enablejsapi=1&origin=https%3A%2F%2Fwww.efap.com']")));

        // Vérifier si l'iframe est visible
        if (iframe.isDisplayed()) {
            // Bascule vers l'iframe
            driver.switchTo().frame(iframe);

            try {
                // Attendre que le bouton de lecture soit cliquable
                WebElement buttonStart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ytp-play-button ytp-button']")));

                // Vérifier si le bouton est visible et cliquer
                if (buttonStart.isDisplayed()) {
                    try {
                        // Tenter le clic normal
                        buttonStart.click();
                    } catch (Exception e) {
                        // Si le clic échoue, utiliser JavaScript pour forcer le clic
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("arguments[0].click();", buttonStart);
                    }
                } else {
                    System.out.println("Le bouton de lecture n'est pas visible.");
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de l'attente du bouton : " + e.getMessage());
            }

            // Revenir au contenu principal
            driver.switchTo().defaultContent();
        } else {
            System.out.println("L'iframe n'est pas visible.");
        }
    }

    public void clickReseauSociaux(String Reseau) {
        List<WebElement>   reseauxSociaux = driver.findElements(By.cssSelector("div[class='rs']>a"));
        for (WebElement reseau : reseauxSociaux) {
            String reseauA = reseau.getAttribute("class");
            System.out.println(reseauA);
            if (reseauA.equals(Reseau)) {
                reseau.click();
                break;
            }
        }
    }
public void gererLesFenteres(){

    String mainHandles = driver.getWindowHandle();

       Set<String> windows = driver.getWindowHandles();
        List<String> listWindows = new ArrayList<>(windows);
        for (String window1:listWindows){
            if (!window1.equals(mainHandles)){
                driver.switchTo().window(window1);

                WebElement Accepte = driver.findElement(By.cssSelector("body > div.__fb-light-mode.x1n2onr6.x1vjfegm > div.x9f619.x1n2onr6.x1ja2u2z > div > div.x1uvtmcs.x4k7w5x.x1h91t0o.x1beo9mf.xaigb6o.x12ejxvf.x3igimt.xarpa2k.xedcshv.x1lytzrv.x1t2pt76.x7ja8zs.x1n2onr6.x1qrby5j.x1jfb8zj > div > div > div > div > div.x1exxf4d.x13fuv20.x178xt8z.x1l90r2v.x1pi30zi.x1swvt13 > div > div:nth-child(2) > div.x1i10hfl.xjbqb8w.x1ejq31n.xd10rxx.x1sy0etr.x17r0tee.x972fbf.xcfux6l.x1qhh985.xm0m39n.x1ypdohk.xe8uvvx.xdj266r.x11i5rnm.xat24cr.x1mh8g0r.xexx8yu.x4uap5.x18d9i69.xkhd6sd.x16tdsg8.x1hl2dhg.xggy1nq.x1o1ewxj.x3x9cwd.x1e5q0jg.x13rtm0m.x87ps6o.x1lku1pv.x1a2a7pz.x9f619.x3nfvp2.xdt5ytf.xl56j7k.x1n2onr6.xh8yej3 > div"));
                Accepte.click();
                driver.close();
                break;
            }
        }

        driver.switchTo().window(mainHandles);


}

public void fermerToutesLesfenetres(){
        String handle1 = driver.getWindowHandle();
        Set<String> Handles = driver.getWindowHandles();
        System.out.println(Handles);
        for (String window:Handles){
            if (!window.equals(handle1)){
                driver.close();
                break;
            }
        }
}

}

