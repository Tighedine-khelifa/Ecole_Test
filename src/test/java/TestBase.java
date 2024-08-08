
import io.github.bonigarcia.wdm.WebDriverManager;
import login.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;
@TestMethodOrder(MethodOrderer.MethodName.class)


public class TestBase {
    public static String browser = "edge" ;
    public static WebDriver driver;

    @BeforeAll
    public static void SetUp(){
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }


        driver.get("https://www.efap.com/agenda");
        driver.manage().window().maximize();

    }
    @Test
    public void t001_login(){
        LoginPage loginPage2 = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        loginPage2.acceptAlert();
        loginPage2.clickInformer();
        loginPage2.closeSetPub();


    }
    @Test
    public void t002_closeNavigate(){
        LoginPage loginPage2 = new LoginPage(driver);
        loginPage2.setForm();
        loginPage2.ClickNiveauEtude("Seconde");
        loginPage2.slectCampus("Lille");
        loginPage2.modeReception("Papier");
        loginPage2.setCheckDoc();
        loginPage2.clickEnrigestrer();
        Assertions.assertEquals(loginPage2.getMerci(),"Merci","rien");
        loginPage2.clickInfomerPage();


    }
    @Test
    public void t003_informertest(){
       HomePage homePage = new HomePage(driver);
        homePage.getUrlPage();
        homePage.getliste("NOUS RENCONTRER");
    }
    @Test
    public void t004_nosActualités(){
        HomePage homePage = new HomePage(driver);
        FestivalDeCannesPage festivalDeCannesPage = new FestivalDeCannesPage(driver);
        homePage.getliste("NOS ACTUALITÉS");
        festivalDeCannesPage.optionHeader("FESTIVAL DE CANNES");
    }

    @Test
    public void t005_nosActivités(){
        NosActivitesPage nosActivitesPage = new NosActivitesPage(driver);
        nosActivitesPage.getTitleNosActivites();
        nosActivitesPage.clickFestivaleDeCannesBas();
    }

    @Test
    public void t006_lesProgrammes(){
        HomePage homePage = new HomePage(driver);
        LesProgrammePage lesProgrammePage  = new LesProgrammePage(driver);
        homePage.getliste("LES PROGRAMMES");
        lesProgrammePage.listProgramme("VAE");
        Assertions.assertTrue(homePage.getUrlPage().contains("vae-formation-continue"),"Erreur de page");

    }
    @Test
    public  void t007_getDocument(){
        LesProgrammePage lesProgrammePage =new LesProgrammePage(driver);
        HomePage homePage = new HomePage(driver);
        lesProgrammePage.clickTelechargement();
        lesProgrammePage.clickMbaSpcialises();
        homePage.getUrlPage();
        lesProgrammePage.ouvrirUneNouvelleFenetre("MBA Communication Spécialisés EFAP - École de Communication EFAP");

    }
    @Test
    public void t008_choixDesSpécialites(){
        MbaSpecialitesPage mbaSpecialitesPage = new MbaSpecialitesPage(driver);
        mbaSpecialitesPage.selectLesThematiques("Luxe");
        mbaSpecialitesPage.selectCity("Paris");
        mbaSpecialitesPage.clickFashionPage();
    }
    @Test
    public void t009_fashionIndustrie(){
        CommunicationFashionPage communicationFashionPage = new CommunicationFashionPage(driver);
        communicationFashionPage.clickStartVideo();
    }
}
