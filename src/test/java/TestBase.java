import io.github.bonigarcia.wdm.WebDriverManager;
import login.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)



public class TestBase {
   static String browser = "edge";
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if ("edge".equals(browser)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get("https://www.efap.com/agenda");
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    @DisplayName("US1 - Verify Login and Initial Page Elements")
  void LoginAndInitialPageElements() {
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        loginPage.acceptAlert();
        loginPage.clickInformer();
        loginPage.closeSetPub();
    }

    @Test
    @Order(2)
    @DisplayName("US2 - Fill and Submit Form, Verify Success Message")
    void lormSubmissionAndSuccessMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setForm();
        loginPage.clickNiveauEtude("Seconde");
        loginPage.slectCampus("Lille");
        loginPage.modeReception("Papier");
        loginPage.setCheckDoc();
        loginPage.clickEnrigestrer();
        Assertions.assertEquals("Merci", loginPage.getMerci(), "Success message did not match");
        loginPage.clickInfomerPage();
    }

    @Test
    @Order(3)
    @DisplayName("US3 - Verify Home Page Navigation")
    void lomePageNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.getUrlPage();
        homePage.getliste("NOUS RENCONTRER");
    }

    @Test
    @Order(4)
    @DisplayName("US4 - Navigate to Festival de Cannes Page")
    void navigateToFestivalDeCannesPage() {
        HomePage homePage = new HomePage(driver);
        FestivalDeCannesPage festivalDeCannesPage = new FestivalDeCannesPage(driver);
        homePage.getliste("NOS ACTUALITÉS");
        festivalDeCannesPage.optionHeader("FESTIVAL DE CANNES");
    }

    @Test
    @Order(5)
    @DisplayName("US5 - Verify Activities and Festival Page")
    void verifyActivitiesAndFestivalPage() {
        NosActivitesPage nosActivitesPage = new NosActivitesPage(driver);
        nosActivitesPage.getTitleNosActivites();
        nosActivitesPage.clickFestivaleDeCannesBas();
    }

    @Test
    @Order(6)
    @DisplayName("US6 - Verify Program List and URL")
    void verifyProgramListAndUrl() {
        HomePage homePage = new HomePage(driver);
        LesProgrammePage lesProgrammePage = new LesProgrammePage(driver);
        homePage.getliste("LES PROGRAMMES");
        lesProgrammePage.listProgramme("VAE");
        Assertions.assertTrue(homePage.getUrlPage().contains("vae-formation-continue"), "URL did not contain expected text");
    }

    @Test
    @Order(7)
    @DisplayName("US7 - Verify Document Download and New Window")
    void documentDownloadAndNewWindow() {
        LesProgrammePage lesProgrammePage = new LesProgrammePage(driver);
        HomePage homePage = new HomePage(driver);
        lesProgrammePage.clickTelechargement();
        lesProgrammePage.clickMbaSpcialises();
        homePage.getUrlPage();
        lesProgrammePage.ouvrirUneNouvelleFenetre();
    }

    @Test
    @Order(8)
    @DisplayName("US8 - Select Specialties and City")
    void selectSpecialtiesAndCity() {
        MbaSpecialitesPage mbaSpecialitesPage = new MbaSpecialitesPage(driver);
        mbaSpecialitesPage.selectLesThematiques("Luxe");
        mbaSpecialitesPage.selectCity("Paris");
        mbaSpecialitesPage.clickFashionPage();
    }

    @Test
    @Order(9)
    @DisplayName("US9 - Interact with Fashion Industry Social Media")
    void fashionIndustrySocialMediaInteraction() {
        CommunicationFashionPage communicationFashionPage = new CommunicationFashionPage(driver);
        communicationFashionPage.clickStartVideo();
        communicationFashionPage.clickReseauSociaux("fb");
        communicationFashionPage.gererLesFenteres();
        communicationFashionPage.clickReseauSociaux("tw");
        communicationFashionPage.clickReseauSociaux("ig");
        communicationFashionPage.clickReseauSociaux("tk");
        communicationFashionPage.clickReseauSociaux("lk");
        communicationFashionPage.fermerToutesLesfenetres();
    }
}
