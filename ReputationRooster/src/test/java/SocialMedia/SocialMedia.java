package SocialMedia;

import credentials.logincredientials;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class SocialMedia {
    public WebDriver driver;
    public SocialMedia(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // (Google Connect Button)
        WebElement Google =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--rounded v-btn--text theme--light v-size--default primary--text']")));
        Google.click();
        //Send Value in Email textbox
        WebElement Email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='whsOnd zHQkBf']")));
        Email.sendKeys("foxajo8288@larland.com");
        // Click on Next button
        WebElement Next=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[2]")));
        Next.click();
        driver.navigate().refresh();


        //  (Facebook connect button)
        WebElement Facebook =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--rounded v-btn--text theme--light v-size--default primary--text'])[2]")));
        Facebook.click();
        // Enter Email and Password
        WebElement Facebook1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='inputtext _55r1 inputtext _1kbt inputtext _1kbt']")));
        Facebook1.sendKeys("foxajo8288@larland.com");
        WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='inputtext _55r1 inputtext _1kbt inputtext _1kbt'])[2]")));
        password.sendKeys("Sparkosol123");
        // Click on login
        WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='_42ft _4jy0 _52e0 _4jy6 _4jy1 selected _51sy']")));
        login.click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().back();

        // (Instagram Connect button)
        WebElement Instagram =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--rounded v-btn--text theme--light v-size--default primary--text'])[3]")));
        Instagram.click();
        // Email and Password
        WebElement Instagram1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='inputtext _55r1 inputtext _1kbt inputtext _1kbt']")));
        Instagram1.sendKeys("foxajo8288@larland.com");
        WebElement Instapassword=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='inputtext _55r1 inputtext _1kbt inputtext _1kbt'])[2]")));
        Instapassword.sendKeys("Sparkosol123");
        // Click on login
        WebElement Instalogin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='_42ft _4jy0 _52e0 _4jy6 _4jy1 selected _51sy']")));
        Instalogin.click();
        Thread.sleep(1000);
        driver.navigate().back();
        driver.navigate().back();

        //  (LinkedIn Connect button)
        WebElement LinkedIn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--rounded v-btn--text theme--light v-size--default primary--text'])[4]")));
        LinkedIn.click();
        // Email and Password
        WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        link.sendKeys("foxajo8288@larland.com");
        WebElement link2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        link2.sendKeys("12343567788");
        // Click on Sign in Button
        WebElement Signin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn__primary--large from__button--floating']")));
        Signin.click();
        Thread.sleep(1000);
        driver.navigate().back();
        driver.navigate().back();

        //  (Twitter Connect button)
        WebElement Twitter =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--rounded v-btn--text theme--light v-size--default primary--text'])[5]")));
        Twitter.click();
        //Email and Password
        WebElement twitter1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username_or_email")));
        twitter1.sendKeys("oxajo8288@larland.com");
        WebElement twitter2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        twitter2.sendKeys("12345678876544g");
        // Click on Authorized App
        WebElement submit=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("allow")));
        submit.click();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().back();

        //  (Click on Done button in Last)
        WebElement done =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[31]")));
        done.click();

    }


    }

