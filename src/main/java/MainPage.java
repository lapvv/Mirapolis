import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPage extends AbstractPage{

    public MainPage(WebDriver driver) {
        super(driver);
        this.url="https://lmslite47vr.demo.mirapolis.ru/mira/";
    }

    @Override
    public void open() {
        super.open();
    }

    public void statusCheckIsVisible(){
        WebElement status = driver.findElement(By.xpath("//div[@title='Мой статус']"));
        Assert.assertTrue(status.isDisplayed());
    }

    public void logout(){
        WebElement userPanel = driver.findElement(By.xpath("//div[@class='drop_down_container guest-drop-down mira-user-info-widget-desktop']"));
        userPanel.click();
        WebElement logout = driver.findElement(By.xpath("//div[@class='mira-user-info-logout']"));
        logout.click();
    }


}
