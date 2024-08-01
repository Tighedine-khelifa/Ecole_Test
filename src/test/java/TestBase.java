
import io.github.bonigarcia.wdm.WebDriverManager;
import login.InformePage;
import login.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;



import java.time.Duration;
@TestMethodOrder(MethodOrderer.MethodName.class)

public class TestBase {

    static ChromeDriver driver;
    @BeforeAll
    public static void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
       InformePage informerPage = new InformePage(driver);
        informerPage.getUrlPage();
        informerPage.getliste("NOUS RENCONTRER");

    }
    @Test
    public void t004_nouActualités(){
        InformePage informePage = new InformePage(driver);
        informePage.getliste("NOS ACTUALITÉS");
        informePage.clickFestivalDeCannes("FESTIVAL DE CANNES");
    }
}
