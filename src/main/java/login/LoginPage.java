package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

    @FindBy(id="nav-discover")
    private WebElement informer;
    @FindBy(id="dl-lastname")
    private WebElement lastName;
    @FindBy(id="dl-firstname")
    private WebElement firstName;

    @FindBy(id="dl-email")
    private     WebElement email;
    @FindBy(id="dl-phone")
    private WebElement phone;
    @FindBy(id="dl-level")
    private WebElement niveauEtude;
    @FindBy(id="dl-campus")
    private WebElement choixCampus;
    @FindBy(id="dl-channel")
    private WebElement reception;
    @FindBy(id="popin-close")
    private WebElement closePub;
    @FindBy(id = "axeptio_btn_acceptAll")
    private WebElement alertAccept;
    @FindBy(id="nav-discover")
    private WebElement informerButtton;
    @FindBy(xpath = "//label[@for='dl-efap']")
    private WebElement checkDoc;
    @FindBy(id="dl-address")
    private WebElement adresse;
    @FindBy(id="dl-zipcode")
    private WebElement zipCode;
    @FindBy(id="dl-city")
    private WebElement city;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement enregistrer;
    @FindBy(xpath= "//h2[text()='Merci']")
    private  WebElement merci;
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    public void acceptAlert(){
        Actions actions = new Actions(driver);
        if (alertAccept.isEnabled()) {
            actions.doubleClick(alertAccept).perform();
        }
    }
    public void clickInformer(){
        informer.click();
    }
    public void closeSetPub(){
        closePub.click();
    }
    public void setForm(){
        lastName.sendKeys("khelifa");
        firstName.sendKeys("tighedine");
        phone.sendKeys("000");
        email.sendKeys("votrechanche@gmaile.com");



    }

    public void ClickNiveauEtude(String niveau){
        Select select = new Select(niveauEtude);
        select.selectByVisibleText(niveau);
    }
    public void slectCampus(String campus){
        Select select1= new Select(choixCampus);
        select1.selectByVisibleText(campus);
    }

    public void modeReception(String mode){
        Select select2 = new Select(reception);
        select2.selectByVisibleText(mode);

        String selectOption = select2.getFirstSelectedOption().getText();
        System.out.println(selectOption);
        if (selectOption.equals(mode)){
            System.out.println("passe a la suite");
            adresse.sendKeys("souk el had");
            zipCode.sendKeys("94300");
            city.sendKeys("tadart");
        }


    }
    public void setCheckDoc(){
        if (checkDoc.isSelected()) {
            System.out.println("le travail est fait");
        }else{
            checkDoc.click();
        }
    }
    public void clickEnrigestrer(){
        enregistrer.click();

    }
    public String getMerci(){
        return merci.getText();
    }

    public InformePage clickInfomerPage(){
        informerButtton.click();
        return new InformePage(driver);
    }
}

