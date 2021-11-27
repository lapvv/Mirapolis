import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends AbstractPage{

    public LoginPage(WebDriver driver) {
        super(driver);
        this.url="https://lmslite47vr.demo.mirapolis.ru/mira";
    }

    @Override
    public void open() {
        super.open();
    }

    public void login() {
        driver.findElement(By.xpath("//input[@name='user']")).sendKeys(System.getProperty("user"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(System.getProperty("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='button_submit_login_form']"));
        loginButton.click();
    }

    public void login(String userT, String passT){
        driver.findElement(By.xpath("//input[@name='user']")).sendKeys(userT);
        WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys(passT);
        WebElement eyeButton = driver.findElement(By.xpath("//button[@id='show_password']"));
        eyeButton.click();
        String ch = pass.getAttribute("value");
        Assert.assertEquals(ch, passT);
        eyeButton.click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='button_submit_login_form']"));
        loginButton.click();
    }

    public void welcomeTextCheckIsVisible(){
        WebElement welcome = driver.findElement(By.xpath("//div[@class='mira-page-login-right-side-content-title']"));
        Assert.assertTrue(welcome.isDisplayed());
    }

    public void passRecoveryButtonClick(){
        WebElement passRecoveryButton = driver.findElement(By.xpath("//a[@class='mira-default-login-page-link']"));
        passRecoveryButton.click();
    }

    public void logo(){
        WebElement logo = driver.findElement(By.xpath("//img"));
        logo.click();
        WebElement welcome = driver.findElement(By.xpath("//div[@class='mira-page-login-right-side-content-title']"));
        Assert.assertTrue(welcome.isDisplayed());
    }
}
