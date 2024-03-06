package SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Signup {

    public WebDriver driver;
    public WebElement usernameField;
    public WebElement passwordField;
    public WebElement loginButton;

    public Signup(WebDriver driver) throws InterruptedException {
        // TC No:2
        this.driver=driver;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement signup1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[2]")));
        signup1.click();

        //Tc No: 3

        WebElement signup2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
        signup2.click();

        // Tc No:4

        //Company name
        WebElement signup3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-47']")));
        signup3.sendKeys("Sparkosol");
        //Name
        WebElement signup4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-50']")));
        signup4.sendKeys("Sparko");
        // Email

        WebElement signup5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-53']")));
        signup5.sendKeys("Sparkotest@gmail.com");
        //Country selector

        WebElement signup6 = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@class='country-selector input-country-selector has-value lg']"))));
        signup6.click();
        //Pakistan select
        WebElement signup7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Pakistan (\u202Bپاکستان\u202C\u200E)')]")));
        signup7.click();
        // Phone number
        WebElement signup8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='input-tel__input']")));
        signup8.sendKeys("03069082821");
        //  enter the password
        WebElement signup10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-62")));
        signup10.sendKeys("Sparkosol123");
        //Confirm password
        WebElement signup11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-66")));
        signup11.sendKeys("Sparkosol123");

        //Tc No: 5

        WebElement signup12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
        signup12.click();

        // Tc No: 7
        WebElement Okbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn__content'])[2]")));
        Okbutton.click();
        Thread.sleep(1000);
        driver.navigate().

                back();
    }
}
