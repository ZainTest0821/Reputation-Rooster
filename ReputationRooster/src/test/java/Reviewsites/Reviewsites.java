package Reviewsites;

import credentials.logincredientials;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class Reviewsites {
    public WebDriver driver;
    public Reviewsites(WebDriver driver) throws InterruptedException {
        this.driver=driver;
        //Reviewsites
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        JavascriptExecutor executor = (JavascriptExecutor) driver;


        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
            // Chrome button click and add details
            WebElement chromebutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-application.v-application--is-ltr.theme--light div.v-application--wrap:nth-child(1) main.v-main div.v-main__wrap div.pa-5 div.v-stepper.v-stepper--is-booted.v-sheet.theme--light div.v-stepper__items div.v-stepper__content:nth-child(3) div.v-stepper__wrapper div.v-list.v-sheet.theme--light:nth-child(3) div:nth-child(4) div.v-list-item.theme--light:nth-child(1) div.v-list-item__action button.v-btn.v-btn--outlined.v-btn--rounded.theme--light.v-size--default.primary--text > span.v-btn__content")));
            chromebutton.click();
            WebElement chromebutton2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='whsOnd zHQkBf']")));
            chromebutton2.sendKeys("postredi123@gmail.com");
            //Click on Next button
            WebElement chromebutton3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[2]")));
            chromebutton3.click();
            Thread.sleep(1500);
            driver.navigate().back();
            Thread.sleep(1500);
            driver.navigate().back();

            //Facebook login
            WebElement facebook1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-application.v-application--is-ltr.theme--light div.v-application--wrap:nth-child(1) main.v-main div.v-main__wrap div.pa-5 div.v-stepper.v-stepper--is-booted.v-sheet.theme--light div.v-stepper__items div.v-stepper__content:nth-child(3) div.v-stepper__wrapper div.v-list.v-sheet.theme--light:nth-child(3) div:nth-child(6) div.v-list-item.theme--light:nth-child(1) div.v-list-item__action button.v-btn.v-btn--outlined.v-btn--rounded.theme--light.v-size--default.primary--text > span.v-btn__content")));
            facebook1.click();
            //Email and password type
            WebElement facebook2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='inputtext _55r1 inputtext _1kbt inputtext _1kbt']")));
            facebook2.sendKeys("sparkosol123@gmail.com");
            WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='inputtext _55r1 inputtext _1kbt inputtext _1kbt'])[2]")));
            password.sendKeys("Sparkosol123");
            WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='_42ft _4jy0 _52e0 _4jy6 _4jy1 selected _51sy']")));
            login.click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(1500);
            driver.navigate().back();


            //Better Business Bureau
        Thread.sleep(1500);
        // Click on connect
            WebElement bbb1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn v-btn--outlined v-btn--rounded theme--light v-size--default primary--text'])[3]")));
        executor.executeScript("arguments[0].click();", bbb1);

        // Add URL
            WebElement bbb2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[13]")));
            bbb2.sendKeys("https:www.betterbusinessburea/sparkosol.com");
            //Click on connect button
            WebElement bbb3=wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default']"))));
            bbb3.click();
            Thread.sleep(1500);
            // CLick on Ok
            WebElement bbb4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary'])[6]")));
            bbb4.click();
            //Click on Cancel button on dialog box
            WebElement bbb5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='mr-3 v-btn v-btn--text theme--light v-size--default'])[3]")));
            bbb5.click();


            //Connect-Yelp
        Thread.sleep(1500);
            WebElement yelp1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--outlined v-btn--rounded theme--light v-size--default primary--text'])[4]")));
        executor.executeScript("arguments[0].click();", yelp1);
            //Add url
            WebElement yelp2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[14]")));
            yelp2.sendKeys("https:www.yelp.com/Sparkosol");
            // Connect:
            WebElement yelp3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default'])[2]")));
            yelp3.click();
          //Click on Ok
         WebElement yelp4 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary'])[7]")));
           yelp4.click();
            // Click on cancel button
            WebElement yelp5 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='mr-3 v-btn v-btn--text theme--light v-size--default'])[4]")));
            yelp5.click();



            //Connect button-Angi
        Thread.sleep(1500);
            WebElement angi1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--outlined v-btn--rounded theme--light v-size--default primary--text'])[5]")));
        executor.executeScript("arguments[0].click();", angi1);
            // Add URL
            WebElement angi2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[15]")));
            angi2.sendKeys("www.angi.com/Sparkosol");
            // Connect button on dialog box
            WebElement angi3 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default'])[3]")));
            angi3.click();
            // Ok button on dialog box
            WebElement angi4 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary'])[8]")));
            angi4.click();
            // Cancel button
            WebElement angi5 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='mr-3 v-btn v-btn--text theme--light v-size--default'])[5]")));
            angi5.click();


            //Connect button-Yellow Pages
        Thread.sleep(1500);
            WebElement yellow1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--outlined v-btn--rounded theme--light v-size--default primary--text'])[6]")));
        executor.executeScript("arguments[0].click();", yellow1);

        //Add URL
            WebElement yellow2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[16]")));
            yellow2.sendKeys("www.yellowpages.com/Sparkosol");
            //Connect button on Dialog box
            WebElement yellow3 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default'])[4]")));
            yellow3.click();
            //Ok button on dialog box
            WebElement yellow4 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--default primary'])[9]")));
            yellow4.click();
            // Cancel button
            WebElement yellow5 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='mr-3 v-btn v-btn--text theme--light v-size--default'])[6]")));
            yellow5.click();
        }



    }

