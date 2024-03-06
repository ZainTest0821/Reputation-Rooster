import Reviewsites.Reviewsites;
import SignUp.Signup;
import SocialMedia.SocialMedia;
import com.beust.ah.A;
import credentials.logincredientials;
import io.github.bonigarcia.wdm.WebDriverManager;
import locationinfo.locationinfo;
import net.bytebuddy.build.Plugin;
import org.junit.runner.Request;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.http.WebSocket;
import java.time.Duration;


public class ReputationRooster {


    WebDriver driver;


    @BeforeTest
    public void LaunchBrowser() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://app-staging.reputationrooster.com/");

    }

  /* @Test(priority = 1)
    void Signup() throws InterruptedException {
        // TC No:2
        PageFactory.initElements(driver, Signup.class);

    }


    @Test(priority = 2)
    void loginscreenbuttonscheck() throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        //Tc No: 8

        //First check forgot password button is working then back
        WebElement forgotbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/auth/forgotpassword']")));
        forgotbutton.click();
        driver.navigate().back();
        // Check the Signin button
        WebElement signinbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
        signinbutton.click();
        // Check the Google button
        WebElement googlebutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='google-btn-text']")));
        googlebutton.click();
        Thread.sleep(1000);
        //Close the google popup

        // get the current window handle
        String parentWindowHandle = driver.getWindowHandle();
        // click on the "Sign in with Google" button to open the popup window
        // switch to the popup window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // close the popup window
        driver.close();
        // switch back to the parent window
        driver.switchTo().window(parentWindowHandle);


    }

    @Test(priority = 3)
    void loginwithinvalidcredentials() throws InterruptedException {
        // Tc: 9
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Email Type
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        WebElement invalidcredentials1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='text']")));
        invalidcredentials1.sendKeys("hina36166@gmail.com");
        // Password type
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        WebElement invalidcredentials2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='password']")));
        invalidcredentials2.sendKeys("Sparko123456789");
        // Click on Signin button
        Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        driver.findElement(By.xpath("//*[@class='v-btn__content']")).click();
// Refresh on dialog box
        Thread.sleep(2000);
        driver.navigate().refresh();
    }

    @Test(priority = 4)
    void loginwithvalidcredientials() throws InterruptedException {
        //Tc No: 10
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Valid Email
        WebElement validcredentials1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='text']")));
        validcredentials1.sendKeys("Sparkotest@gmail.com");
        // Valid Password
        WebElement validcredentials2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='password']")));
        validcredentials2.sendKeys("Sparkosol123");
        // Click on Signin button
        WebElement validcredentials3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
        validcredentials3.click();


    }

    @Test(priority = 5)
    void testallthebuttons() throws InterruptedException {

        //Tc No :11

        // Dashboard button
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(10000);
       driver.findElement(By.xpath("//div[@class='v-list-item__title']")).click();

       // Review Button
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-list-item__title'])[2]"))).click();
        Relatioship button
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-list-item__title'])[3]"))).click();

        //Request button
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-list-item__title'])[4]"))).click();

        // Reporting button
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-list-item__title'])[5]"))).click();

      //


    }

   @Test(priority = 6)
    void errormessagecheck() throws InterruptedException, AWTException {

        //Click on Add payment method
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        Thread.sleep(15000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        driver.findElement(By.className("blue--text")).click();
        // Select randomly package
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-input--selection-controls__ripple']")));
        element2.click();
        //
        WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-input--selection-controls__ripple'])[2]")));
        element3.click();

     // Enter card number and Submit button manually
    }

    @Test(priority = 7)
    void invalidcoupencode() throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Send value in coupon code text box
        WebElement invalidelement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[2]")));
        invalidelement1.sendKeys("Test14");
        // Waiting for dismiss the element
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        // Click on Apply button
        WebElement invalidelment2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn__content'])[2]")));
        invalidelment2.click();
        // Clear the text field
        driver.navigate().refresh();

    }

    @Test(priority = 8)
    void validcoupon1() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Send value in coupon code text box
        WebElement validelement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[2]")));
        validelement.sendKeys("Test10");
        // Waiting for dismiss the element
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        // Click on Apply button
        WebElement validelement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn__content'])[2]")));
        validelement2.click();
        //Click on Next
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-btn v-btn--has-bg theme--dark elevation-0 v-size--default primary']"))).click();

    }

    @Test(priority = 9)
    void locationinfo() throws InterruptedException {
        // Call locationinfoclass
        PageFactory.initElements(driver, locationinfo.class);
    }

    @Test(priority = 10)
        //Reviews sites Tc16
    void reviewsites() {
        //Call the Reviewsites clasa
        PageFactory.initElements(driver, Reviewsites.class);

        // Click on Next button
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement Next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary']")));
        executor.executeScript("arguments[0].click();", Next);

}

    @Test(priority = 11)
        // Realtionship window
        // Tc17
    void Relationship() throws AWTException, InterruptedException, IOException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
 //Click on Import file
        WebElement relationship = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-application.v-application--is-ltr.theme--light div.v-application--wrap:nth-child(1) main.v-main div.v-main__wrap div.pa-5 div.v-stepper.v-stepper--is-booted.v-sheet.theme--light div.v-stepper__items div.v-stepper__content:nth-child(4) div.v-stepper__wrapper div:nth-child(1) div:nth-child(1) div.mb-5:nth-child(3) button.mr-3.mb-3.mb-sm-0.v-btn.v-btn--outlined.theme--light.v-size--default.primary--text:nth-child(1) > span.v-btn__content")));
        relationship.click();
        //File Upload
        Thread.sleep(700);
        WebElement upload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='csvPickerWrapper grey lighten-3 py-8 d-flex justify-center align-center my-5']")));
        upload.click();

        String autoItScriptPath = "C:\\Scripts\\Importcsv.exe";
        Runtime.getRuntime().exec(autoItScriptPath);

        Thread.sleep(4000);
        // CLick on Submit
        WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary'])[5]")));
        executor.executeScript("arguments[0].click();", submit);

        //Click on Ok when dialog box appear
       WebElement Ok=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary'])[5]")));
        executor.executeScript("arguments[0].click();", Ok);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        // Click on Next
        WebElement nextbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary'])[2]")));
        executor.executeScript("arguments[0].click();", nextbutton);
    }

    @Test(priority = 12)
        // Tc No: 18
    void Widgets() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        // Scroll to end
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        // Click on Next
        WebElement Nextbutton = wait.until(driver -> driver.findElement(By.xpath("(//*[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary'])[3]")));
        Nextbutton.click();
    }

    @Test(priority = 13)
    void SocialMedia() {
        // Tc No:19
        // Call SocialMedia Class
        PageFactory.initElements(driver, SocialMedia.class);
//


    }

    @Test(priority = 14)
    void Google() throws InterruptedException {
        // Tc No:20
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));

        // Click on Profile button
        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-avatar profile-view']")));
        profile.click();

        // Click on Product Setting
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item v-list-item--link theme--light'])[5]")));
        executor.executeScript("arguments[0].click();", product);

        Thread.sleep(1500);
        // Scroll to google
        WebElement scroll=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--outlined v-btn--rounded theme--light v-size--default primary--text']")));
       executor.executeScript("arguments[0].scrollIntoView(true);",scroll);

        // Click on Google connect button
        WebElement google = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--outlined v-btn--rounded theme--light v-size--default primary--text']")));
        google.click();
        // Add email
        WebElement googleemail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='email']")));
        googleemail.sendKeys("postredi123@gmail.com");
        // Click on Next
        WebElement Next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[2]")));
        executor.executeScript("arguments[0].click();", Next);
        Thread.sleep(2500);
        driver.navigate().back();
        Thread.sleep(150);
        driver.navigate().back();

        // Password
      /* WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='password']")));
        password.sendKeys("a1234567890#");
        // Click on Next buton
        WebElement nextbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[2]")));
        nextbutton.click();//

}

    @Test(priority = 15)
    void facebook() throws InterruptedException {
        //Tc No: 21
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        // Click on Profile button
    /* WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-avatar profile-view']")));
        profile.click();
        // Click on Product Setting
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item v-list-item--link theme--light'])[5]")));
        executor.executeScript("arguments[0].click();",product);
        Thread.sleep(2000);
        // Scroll down to facebook
        WebElement scroll=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--outlined v-btn--rounded theme--light v-size--default primary--text'])[2]")));
        executor.executeScript("arguments[0].scrollIntoView(true);",scroll);
        //

        // Facebook connect button
        WebElement facebook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--outlined v-btn--rounded theme--light v-size--default primary--text'])[2]")));
        facebook.click();
        // Enter Email and password
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("postredi222@gmail.com");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        password.sendKeys("a1234567890#");
        // Login
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbutton")));
        login.click();
        Thread.sleep(4000);

        // Select Facebook Profile
        WebElement fb=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='x1n2onr6 x1ja2u2z x78zum5 x2lah0s xl56j7k x6s0dn4 xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l x1qhh985 xm0m39n x9f619 xn6708d x1ye3gou xtvsq51 x1r1pt67']")));
        fb.click();
        //Select Page
        WebElement page=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-chevron-right theme--light']")));
         executor.executeScript("arguments[0].click();", page);


    }

    @Test(priority = 16)
    void SociaMedia() throws InterruptedException {
        // Tc No: 22
        Thread.sleep(3000);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        //Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        // Click on Profile button
        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-avatar profile-view']")));
        profile.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        // Click on Product Setting
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item v-list-item--link theme--light'])[5]")));
        executor.executeScript("arguments[0].click();",product);
        // Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        //Click on Social Media
        WebElement SocialMedia = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-tab']")));
        SocialMedia.click();

      //Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        //Click on Instagram button
        WebElement Instagram = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instagramConnectBtn")));
        executor.executeScript("arguments[0].click();",Instagram);

        // Login into other account because when we add facebook then it direct take that account for login with instagram, but when you have another account instagram then this code wil be use
        WebElement loginwithother=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lkfr7t x1lbecb7 xo1l8bm x1qq9wsj']")));
        loginwithother.click();

        // Email and Password
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);;
        email.sendKeys("nabeelahmed0294@gmail.com");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        password.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);;
        password.sendKeys("Sparkosol123");
        // Login
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbutton")));
        login.click();
        Thread.sleep(1500);
        // Select profile of insta
        WebElement insta=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='x1n2onr6 x1ja2u2z x78zum5 x2lah0s xl56j7k x6s0dn4 xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l x1qhh985 xm0m39n x9f619 xn6708d x1ye3gou xtvsq51 x1r1pt67']")));
        executor.executeScript("arguments[0].click();",insta);
        // Select insta page profile
        WebElement isntapage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-chevron-right theme--light']")));
        executor.executeScript("arguments[0].click();",isntapage);

        // Once you have added instagram then the add social media function will repeat

        //Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        Thread.sleep(2000);
        //Click on profile because when we call again then the 'stale element error display
        WebElement profile2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-avatar profile-view']")));
        profile2.click();
        // Click on Product Setting
        WebElement product2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item v-list-item--link theme--light'])[5]")));
        executor.executeScript("arguments[0].click();",product2);
        // Click on Social media
        WebElement SocialMedia2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-tab']")));
        SocialMedia2.click();


        // LinkedIn connect button
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));

        WebElement LinkedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkedinConnectBtn")));
        LinkedIn.click();
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        link.sendKeys("postredi123@gmail.com");
        WebElement link2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        link2.sendKeys("a1234567890#");
        WebElement SignIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn__primary--large from__button--floating']")));
        SignIn.click();
        Thread.sleep(3000);

        // Once you have added LinkedIn then the add social media function will repeat
        //Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        Thread.sleep(2000);
        //Click on profile because when we call again then the 'stale element error display
        WebElement profile3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-avatar profile-view']")));
        executor.executeScript("arguments[0].click();",profile3);

        // Click on Product Setting
        WebElement product3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item v-list-item--link theme--light'])[5]")));
        executor.executeScript("arguments[0].click();",product3);
        // Click on Social media
        WebElement SocialMedia3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-tab']")));
        SocialMedia3.click();


        // Connect Twitter
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));

        WebElement Twitter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twitterConnectBtn")));
        executor.executeScript("arguments[0].click();",Twitter);
        WebElement twitter1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username_or_email")));
        twitter1.sendKeys("flutterdesk@gmail.com");
        WebElement twitter2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        twitter2.sendKeys("L!%4&PsRRY");
        // Click on Authorized App
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("allow")));
        submit.click();


    }

    @Test(priority = 17)
    //Tc No: 23
    void Reviews() throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        Thread.sleep(2500);

        // Click on Reviews from Left menu bar
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        try {
            WebElement review = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.v-application.v-application--is-ltr.theme--light div.v-application--wrap nav.app-navigation-menu.v-navigation-drawer.v-navigation-drawer--fixed.v-navigation-drawer--open.theme--light.bg div.v-navigation-drawer__content div.v-list.pr-5.v-sheet.v-sheet--shaped.theme--light a.vertical-nav-menu-link.v-list-item.v-list-item--link.theme--light:nth-child(2) div.v-list-item__title > div.d-flex.justify-space-between")));
            review.click();
        }
        catch (Exception e){
            WebElement review2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='d-flex justify-space-between'])[2]")));
            review2.click();
        }

        // Click on Request a review
        WebElement request = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='v-btn__content' and text()='Request a review']")));
        request.click();
        // Wait for invisibility of other elemenet
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("<button type=button class=v-btn v-btn--has-bg theme--dark elevation-0 v-size--default style=background-color: rgb(66, 144, 143); border-color: rgb(66, 144, 143);>...</button>")));
        Thread.sleep(1000);
        // CLick on Add&invite
        WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-btn v-btn--has-bg theme--dark elevation-0 v-size--default']")));
        executor.executeScript("arguments[0].click();",Add);
        Thread.sleep(1000);
        // Add details in text field
        WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        firstname.sendKeys("Mortees");
        //
        WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
        lastname.sendKeys("Alvaro");
        //
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("tyreluxo@mailo.icu");
        //
       WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='country-selector input-country-selector has-value lg']")));
        country.click();
       driver.findElement(By.xpath("//div[@class='dots-text' and text()=' United Kingdom ']")).click();
       //
        WebElement phone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Phone number']")));
        phone.sendKeys("7933449279");
        //
        WebElement company=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyName")));
        company.sendKeys("Business Intel Online.");
        //
        WebElement position=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("position")));
        position.sendKeys("ASO");
        //Click on Add&invite
        WebElement invite=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--dark elevation-0 v-size--default'])[2]")));
        executor.executeScript("arguments[0].click();",invite);

        Thread.sleep(1500);
        // Click on Ok button when email is re-use
        WebElement OK=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary'])[2]")));
        OK.click();

        Thread.sleep(1500);
        // Close the popup
        WebElement crossbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light'])[2]")));
        executor.executeScript("arguments[0].click();",crossbutton);
        // Close the second popup
        WebElement crossbutton2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light']")));
        executor.executeScript("arguments[0].click();",crossbutton2);

    }
    @Test(priority=18)
    void enhancedrequest() throws InterruptedException {
        //TC 25 and 26
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        // Click on Enhanced Request button
        WebElement enhancedrequest=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--outlined theme--light v-size--small primary--text mr-3 mb-3']")));
        executor.executeScript("arguments[0].click();",enhancedrequest);

        // Click on 'Create' button
        WebElement create=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary'])[3]")));
        executor.executeScript("arguments[0].click();",create);


        // Click on 'Ok' button on error dialog box
        WebElement Okbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary'])[4]")));
        Okbutton.click();
        // Then scroll to cross button and click
        WebElement crossbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light'])[3]")));
        executor.executeScript("arguments[0].scrollIntoView(true);arguments[0].click();", crossbutton);
        Thread.sleep(1500);

       }


    @Test(priority = 19)
    void profilepage() throws InterruptedException {
        // Tc No: 26
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        // Profile button click
       WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-avatar profile-view' and @elevation='5' and @role='button']")));
        executor.executeScript("arguments[0].click();",profile);
        // CLick on Personal button
        WebElement personal=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personalSettingItem")));
        executor.executeScript("arguments[0].click();",personal);
        // Update firstname
        WebElement firstname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        firstname.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        firstname.sendKeys("Sparko");
        // Update last name
        WebElement lastname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
        lastname.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        lastname.sendKeys("Sol");
        //Update Email
       /* WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-202"));
        email.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        email.sendKeys("genyfer@inc.com");
        //comment

        // Update Country and phone num
        WebElement country=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Country code']")));
        country.click();
        driver.findElement(By.xpath("//div[@class='dots-text' and text()=' United States ']")).click();
        WebElement phone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Phone number']")));
        phone.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        phone.sendKeys("844608089");
        // Click on save and changes
        WebElement savechanges=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
        savechanges.click();
    }
    @Test(priority = 20)
    void profileupdate() throws InterruptedException {
        // Tc No: 27
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        //Click on Security button
        WebElement security=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-tab'])[2]")));
        security.click();

    }
    @Test(priority = 21)
    void security () throws InterruptedException {
        // Tc No: 28
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        Thread.sleep(2000);

        // Click on update password without enter details
        WebElement updatepass=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary']")));
        executor.executeScript("arguments[0].click();",updatepass);

        // Enter wrong password in Old password text field
        WebElement password1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityCurrent")));
        password1.sendKeys("111ggd1");

        // Enter new and confirm password
        WebElement password2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityNew")));
        password2.sendKeys("Sparkosol1234");
        WebElement password3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityConfirm")));
        password3.sendKeys("Sparkosol1234");
        updatepass.click();
        // Error dilaog box Ok button
        WebElement Ok=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary'])[2]")));
        executor.executeScript("arguments[0].click();",Ok);

    }
    @Test(priority = 22)
    void Security() throws InterruptedException {
        // Tc No: 29
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        Thread.sleep(2000);

        // Enter valid password in Old password text field
        WebElement password1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityCurrent")));
        password1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        password1. sendKeys("Sparkosol123");

        // Enter new and confirm password
        WebElement password2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityNew")));
        password2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        password2.sendKeys("Sparkosol12222");
        WebElement password3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityConfirm")));
        password3.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        password3.sendKeys("Sparkosol1234");

        // Click on updatepass
        WebElement updatepass=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary']")));
        updatepass.click();
        // Error dilaog box Ok button
        WebElement Ok=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary'])[2]")));
        executor.executeScript("arguments[0].click();",Ok);

    }
    @Test(priority =23)
    void SecurityY() throws InterruptedException {
        // Tc No: 30
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
       Thread.sleep(2000);
        // Enter valid password in Old password text field
        WebElement password1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityNew")));
        password1.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        password1. sendKeys("Sparkosol123");

        // Enter new and confirm password
        WebElement password2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityNew")));
        password2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        password2.sendKeys("Sparkosol1234");
        WebElement password3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityConfirm")));
        password3.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        password3.sendKeys("Sparkosol1234");

        // Click on updatepass
        WebElement updatepass=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary']")));
        executor.executeScript("arguments[0].click();",updatepass);
    }
    @Test(priority = 24)
    void Email1() throws InterruptedException {
        //Tc 31
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        // Profile button click
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-avatar profile-view' and @elevation='5' and @role='button']")));
        executor.executeScript("arguments[0].click();",profile);
        // Click Account& Billing
        WebElement Account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountSettingItem")));
        executor.executeScript("arguments[0].click();",Account);
        wait.until(ExpectedConditions.urlContains("https://app-staging.reputationrooster.com/settings/account"));
        // Click on Invite without adding email
        WebElement Invite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[2]")));
        Invite.click();


    }

    @Test(priority = 25)
    void Email2() {
        // Tc No: 32
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Click on Profile
        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-avatar profile-view' and @elevation='5' and @role='button']\n")));
        profile.click();
        // Click Account& Billing
        WebElement Account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item v-list-item--link theme--light'])[3]")));
        Account.click();
        //Add invalid email in email text box
        WebElement invalidemail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        invalidemail.sendKeys("aksrdsafasf.com");
        // Click on Invite without adding email
        WebElement Invite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[2]")));
        Invite.click();

    }

    @Test(priority = 26)
    void Email3() {
        // Tc No : 33
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        //Add invalid email in email text box
        WebElement invalidemail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        invalidemail.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        invalidemail.sendKeys("ahytux@css.com");
        // Click on Invite without adding email
        WebElement Invite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[2]")));
        Invite.click();
        driver.navigate().back();

    }

    @Test(priority = 27)
    void paymentupdate() throws InterruptedException {
        // Tc No: 34
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));

        // Click on billing
        WebElement bilingbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-tab']")));
        bilingbtn.click();
        // Click on Update payment method button
        WebElement updatemethod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blue--text']")));
        updatemethod.click();
        Thread.sleep(1000);
        // Click on check box
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-input--selection-controls__ripple']")));
        checkbox.click();
        //Click on submit button
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[5]")));
        submit.click();
        Thread.sleep(1000);
        // Click on cancel
        WebElement cancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[4]")));
        cancel.click();

    }

    @Test(priority = 28)
    void couponcode() throws InterruptedException {
        //TC 35
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Click on Apply button
        WebElement apply = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ml-3 mb-6 v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary']")));
        apply.click();
        Thread.sleep(1000);

    }

    @Test(priority = 29)
    void Couponcode() throws InterruptedException {
        //TC 36
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Enter invalid Promo code
        WebElement coupon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("promoCode")));
        coupon.sendKeys("AbcD123");
        // Click on Apply button
        WebElement apply = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ml-3 mb-6 v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary']")));
        apply.click();
        Thread.sleep(1000);

    }

    @Test(priority = 30)
    void plan() throws InterruptedException {
        //Tc No: 37
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));

        // Click on Plan
        WebElement plan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-tab'])[2]")));
        plan.click();
        // Click on Change plan button
        try {
            WebElement change = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='blue--text pointer ma-0 mr-2' and text()='Change Plan']")));
            change.click();
        } catch (Exception e) {
            driver.findElement(By.xpath("//*[@class='blue--text pointer ma-0 mr-2']")).click();
        }

        Thread.sleep(2000);
        // Switch plan yearly to monthly
        WebElement Switch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-input ma-0 v-input--hide-details v-input--is-label-active v-input--is-dirty v-input--dense theme--light v-input--selection-controls v-input--switch v-input--switch--inset primary--text']")));
        Switch.click();
        Thread.sleep(1000);
        // Select new plan
        WebElement newplan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-input--selection-controls__ripple'])[2]")));
        newplan.click();
        //2nd
        Thread.sleep(500);
        WebElement newplan2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-input--selection-controls__ripple'])[3]")));
        newplan2.click();
        Thread.sleep(2000);
        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        // Click on Submit
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Submit']")));
        submit.click();
        //Alert appear
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        Thread.sleep(1000);
        alert.dismiss();
        // Click on cross button to close the popup
        WebElement cross=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light']")));
        cross.click();

    }
    @Test(priority = 31)
    void Plan() throws InterruptedException {
        //Tc No: 38
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));

        // Click on Cancel button
        WebElement cancel=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Cancel Plan']\n")));
        cancel.click();
        // click on cancel my subscription

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light']")));
        Thread.sleep(2000);
        WebElement cancle2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mb-2 v-btn v-btn--text theme--light v-size--small primary--text']")));
        executor.executeScript("arguments[0].click();",cancle2);
        // Alert appear
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        Thread.sleep(1000);
        alert.dismiss();
        // Click on i will decide later
        WebElement decide=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"I'll decide later\"]\n")));
        decide.click();
        Thread.sleep(1500);


    }
    @Test(priority = 32)
    void location() throws InterruptedException {
        // Tc No: 39
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("v-overlay__scrim")));

        // Click on Profile
        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-avatar profile-view' and @elevation='5' and @role='button']\n")));
        profile.click();
        // Click on Location button
        // wait for ivisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("v-overlay__scrim")));
        //
        WebElement locaction=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companySettingItem")));
        locaction.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-v-7c4455d4]/div[@role='progressbar']")));

        // Make location name field  empty
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        WebElement name =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyName")));
        js1.executeScript("arguments[0].value='solsparko';", name );

        // Make email filed empty
        WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyEmail")));
        email.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        email.sendKeys("tyreluxo@mailo.com");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        // Click on Country changer phone
        WebElement changer=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Country code']")));
        changer.click();
        // Change the country phone
        WebElement country=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dots-text' and text()=' United Kingdom ']")));
        country.click();
        // Change the phone number
        WebElement ph=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Phone number']")));
        ph.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
              ph.sendKeys(" 07400 123456");
        // Change Address
        WebElement address=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyAddress")));
        address.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                address.sendKeys(" 83 Hull Road");
        // Change Unit
        WebElement unit=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyAddressUnit")));
        unit.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
               unit.sendKeys("Street ");

        // Change Country
        WebElement country1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyAddressCountry")));
        country1.click();
        // Select Country
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item v-list-item--link theme--light'])[10]")));
        executor.executeScript("arguments[0].click();",element);


        // Change State
        WebElement state=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyAddressState")));
        state.click();
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item v-list-item--link theme--light'])[30]")));
        executor.executeScript("arguments[0].click();",element2);

        //Change City
        WebElement city=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyAddressCity")));
        city.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        city.sendKeys("Ordino");

        //Change timezone
        WebElement timezone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyTimeZone")));
        timezone.click();
        timezone.sendKeys("Europe/Luxembourg");
        // ChangePostal Code
        WebElement postalcode=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyAddressZipCode")));
        postalcode.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        postalcode.sendKeys("4532");

    // Click on save changes
        WebElement savechanges=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary']")));
        savechanges.click();


    }*/

    @Test(priority = 33)
    void errorcheck() throws InterruptedException {
        //TC No 40
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, logincredientials.class);

        //wait for page load properly
        Thread.sleep(3000);
        // Click on Reviews from Left menu bar
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        try {
            WebElement review2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-list-item__title'])[2]")));
            review2.click();

        } catch (Exception e) {
            WebElement review = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.v-application.v-application--is-ltr.theme--light div.v-application--wrap nav.app-navigation-menu.v-navigation-drawer.v-navigation-drawer--fixed.v-navigation-drawer--open.theme--light.bg div.v-navigation-drawer__content div.v-list.pr-5.v-sheet.v-sheet--shaped.theme--light a.vertical-nav-menu-link.v-list-item.v-list-item--link.theme--light:nth-child(2) div.v-list-item__title > div.d-flex.justify-space-between")));
            review.click();
        }
        // Click on request a review
        WebElement request = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='v-btn__content' and text()='Request a review']")));
        request.click();
        // Wait for invisibility of other elemenet
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("<button type=button class=v-btn v-btn--has-bg theme--dark elevation-0 v-size--default style=background-color: rgb(66, 144, 143); border-color: rgb(66, 144, 143);>...</button>")));
        Thread.sleep(1000);
        // CLick on Add&invite
        WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-btn v-btn--has-bg theme--dark elevation-0 v-size--default']")));
        executor.executeScript("arguments[0].click();", Add);
        Thread.sleep(1500);
        // Click on Add& invite button on popup
        WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--dark elevation-0 v-size--default'])[2]")));
        executor.executeScript("arguments[0].click();", add);
    }

    @Test(priority = 34)
        //TC No 41
    void invitecheck() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        // Add details in text field
        WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        firstname.sendKeys("Mortees");

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("gotonos607@introace.com");
        //
        WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='country-selector input-country-selector has-value lg']")));
        country.click();
        driver.findElement(By.xpath("//div[@class='dots-text' and text()=' United Kingdom ']")).click();
        //
        WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Phone number']")));
        phone.sendKeys("7933549379");

        // Click on Add& invite button on popup
        WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--dark elevation-0 v-size--default'])[2]")));
        executor.executeScript("arguments[0].click();", add);
        //Click on cross button
        WebElement cross = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light']")));
        executor.executeScript("arguments[0].click();", cross);

    }

    @Test(priority = 35)
    void newentery() {
        //TC No 42 and 43
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        // wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        // Click on Relationship
        try {
            WebElement review = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.v-application.v-application--is-ltr.theme--light div.v-application--wrap nav.app-navigation-menu.v-navigation-drawer.v-navigation-drawer--fixed.v-navigation-drawer--open.theme--light.bg div.v-navigation-drawer__content div.v-list.pr-5.v-sheet.v-sheet--shaped.theme--light a.vertical-nav-menu-link.v-list-item.v-list-item--link.theme--light:nth-child(2) div.v-list-item__title > div.d-flex.justify-space-between")));
            review.click();
        }
        catch (Exception e){
            WebElement review2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='d-flex justify-space-between'])[2]")));
            review2.click();
        }

        // Verify that list contain new entry manually

        // Test refresh button
        WebElement refresh=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reload']")));
        refresh.click();

    }
    @Test(priority = 36)
    // TC No: 44
    void statuscheck() throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Wait for finishing refresh
        Thread.sleep(1500);
       // Click on Requests button
        try {
            WebElement relationship = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-list-item__title'])[4]")));
            relationship.click();

        } catch (Exception e) {
            WebElement relationship2= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='d-flex justify-space-between'])[4]")));
            relationship2.click();
        }

    }

    }





