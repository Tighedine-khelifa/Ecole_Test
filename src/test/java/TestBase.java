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
    public static String browser = "edge";
    public static WebDriver driver;

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
    @DisplayName("US1 - Verify Login and Initial Page Elements")
  void t001_LoginAndInitialPageElements() {
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        loginPage.acceptAlert();
        loginPage.clickInformer();
        loginPage.closeSetPub();
    }

    @Test
    @DisplayName("US2 - Fill and Submit Form, Verify Success Message")
    void t002_FormSubmissionAndSuccessMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setForm();
        loginPage.ClickNiveauEtude("Seconde");
        loginPage.slectCampus("Lille");
        loginPage.modeReception("Papier");
        loginPage.setCheckDoc();
        loginPage.clickEnrigestrer();
        Assertions.assertEquals("Merci", loginPage.getMerci(), "Success message did not match");
        loginPage.clickInfomerPage();
    }

    @Test
    @DisplayName("US3 - Verify Home Page Navigation")
    void t003_HomePageNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.getUrlPage();
        homePage.getliste("NOUS RENCONTRER");
    }

    @Test
    @DisplayName("US4 - Navigate to Festival de Cannes Page")
    void t004_NavigateToFestivalDeCannesPage() {
        HomePage homePage = new HomePage(driver);
        FestivalDeCannesPage festivalDeCannesPage = new FestivalDeCannesPage(driver);
        homePage.getliste("NOS ACTUALITÉS");
        festivalDeCannesPage.optionHeader("FESTIVAL DE CANNES");
    }

    @Test
    @DisplayName("US5 - Verify Activities and Festival Page")
    void t005_VerifyActivitiesAndFestivalPage() {
        NosActivitesPage nosActivitesPage = new NosActivitesPage(driver);
        nosActivitesPage.getTitleNosActivites();
        nosActivitesPage.clickFestivaleDeCannesBas();
    }

    @Test
    @DisplayName("US6 - Verify Program List and URL")
    void t006_VerifyProgramListAndUrl() {
        HomePage homePage = new HomePage(driver);
        LesProgrammePage lesProgrammePage = new LesProgrammePage(driver);
        homePage.getliste("LES PROGRAMMES");
        lesProgrammePage.listProgramme("VAE");
        Assertions.assertTrue(homePage.getUrlPage().contains("vae-formation-continue"), "URL did not contain expected text");
    }

    @Test
    @DisplayName("US7 - Verify Document Download and New Window")
    void t007_DocumentDownloadAndNewWindow() {
        LesProgrammePage lesProgrammePage = new LesProgrammePage(driver);
        HomePage homePage = new HomePage(driver);
        lesProgrammePage.clickTelechargement();
        lesProgrammePage.clickMbaSpcialises();
        homePage.getUrlPage();
        lesProgrammePage.ouvrirUneNouvelleFenetre();
    }

    @Test
    @DisplayName("US8 - Select Specialties and City")
    void t008_SelectSpecialtiesAndCity() {
        MbaSpecialitesPage mbaSpecialitesPage = new MbaSpecialitesPage(driver);
        mbaSpecialitesPage.selectLesThematiques("Luxe");
        mbaSpecialitesPage.selectCity("Paris");
        mbaSpecialitesPage.clickFashionPage();
    }

    @Test
    @DisplayName("US9 - Interact with Fashion Industry Social Media")
    void t009_FashionIndustrySocialMediaInteraction() {
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
