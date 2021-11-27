import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;


public class LoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(System.getProperty("site.url"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    //smokeTest
    @Test
    public void smokeTest(){
        driver.get(System.getProperty("site.url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login();
        MainPage mainPage = new MainPage(driver);
        mainPage.statusCheckIsVisible();
        mainPage.logout();
        loginPage.welcomeTextCheckIsVisible();
    }

    //добавить проверку провала при неверном пароле + кнопка отображения символов пароля
    @Test(priority = 1)
    public void passwordTest(){
        driver.get(System.getProperty("site.url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("fominaelena", "1P73BP4");
        Alert alert = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assert.assertEquals(text, "Неверные данные для авторизации");
        alert.accept();
    }

    //добавить проверку провала при неверном логине (+кнопка отображения символов пароля)
    @Test(priority = 2)
    public void loginTest(){
        driver.get(System.getProperty("site.url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("fominaelen", "1P73BP4Z");
        Alert alert = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assert.assertEquals(text, "Неверные данные для авторизации");
        alert.accept();
    }

    //добавить проверку по восстановлению пароля
    @Test(priority = 3)
    public void passRecoveryTest(){
        driver.get(System.getProperty("site.url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.passRecoveryButtonClick();
        PassRecoveryPage passRecoveryPage = new PassRecoveryPage(driver);
        passRecoveryPage.loginBox();
    }

    @Test(priority = 4)
    public void logoClickTest(){
        driver.get(System.getProperty("site.url"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.logo();
    }
}
