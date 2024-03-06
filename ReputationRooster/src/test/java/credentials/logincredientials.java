package credentials;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class logincredientials {
    private WebDriver driver;
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;


    public logincredientials(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Email
        WebElement validcredentials1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='text']")));
        validcredentials1.sendKeys("Sparkotest@gmail.com");
        //Password
        WebElement validcredentials2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='password']")));
        validcredentials2.sendKeys("Sparkosol123");
        Thread.sleep(1500);
        WebElement validcredentials3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
        validcredentials3.click();

    }
}
