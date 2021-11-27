import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PassRecoveryPage extends AbstractPage{

    public PassRecoveryPage(WebDriver driver) {
        super(driver);
        this.url="https://lmslite47vr.demo.mirapolis.ru/mira/";
    }

    @Override
    public void open() {
        super.open();
    }

    public void loginBox(){
        WebElement box = driver.findElement(By.xpath("//input[@type='text']"));
        box.sendKeys("fominaelena");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        WebElement message = driver.findElement(By.xpath("//div[@class='success']"));
        Assert.assertTrue(message.isDisplayed());
        WebElement backButton = driver.findElement(By.xpath("//a[@class='mira-page-forgot-password-link']"));
        backButton.click();
    }
}
