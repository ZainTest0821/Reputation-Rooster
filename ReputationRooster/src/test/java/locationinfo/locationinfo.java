package locationinfo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class locationinfo {
   public WebDriver driver;
   public locationinfo(WebDriver driver) throws InterruptedException, IOException {
       this.driver=driver;
       Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
               .withTimeout(Duration.ofSeconds(40))
               .pollingEvery(Duration.ofSeconds(2))
               .ignoring(NoSuchElementException.class);
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-overlay__scrim']")));


       // Upload the file from

            WebElement locationinfo2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn v-btn--has-bg theme--light elevation-0 v-size--small primary']")));
           locationinfo2.click();

       String autoItScriptPath = "C:\\Scripts\\SocialSelects1_3.exe";
       Runtime.getRuntime().exec(autoItScriptPath);

       Thread.sleep(4000);
       //Add address
       WebElement locationinfo3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[5]")));
       locationinfo3.sendKeys("Canada Kanthaswamy Temple Society (Scarborough), Birchmount Road, Toronto, Scarborough, ON, Canada");

       //Add Unit
       WebElement locationinfo4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[6]")));
       locationinfo4.sendKeys("2789 Joseph Street");

       // Select Country
       WebElement locationinfo5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Select a country']")));
       locationinfo5.click();
       WebElement locationinfo6= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item__content'])[18]")));
       locationinfo6.click();

       //Select state
       WebElement locationinfo7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='---']")));
       locationinfo7.click();
       WebElement locationinfo8=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-list-item__title' and text()='Badakhshan']")));
       locationinfo8.click();

       //Select City
       WebElement locationinfo9=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@placeholder='---'])[2]")));
       locationinfo9.click();
       WebElement locationinfo10=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-list-item__title' and text()='Jurm']")));
       locationinfo10.click();

       // Postal code
       WebElement location11=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[11]")));
       location11.sendKeys("3457");

       //Add website
       WebElement location12=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[12]")));
       location12.sendKeys("www.sparkosol.com");

       // Click on Next
       WebElement location13=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-application.v-application--is-ltr.theme--light div.v-application--wrap:nth-child(1) main.v-main div.v-main__wrap div.pa-5 div.v-stepper.v-stepper--is-booted.v-sheet.theme--light div.v-stepper__items div.v-stepper__content:nth-child(2) div.v-stepper__wrapper div.px-sm-7 div.span-2.d-flex.justify-end:nth-child(4) button.v-btn.v-btn--has-bg.theme--dark.elevation-0.v-size--default.primary > span.v-btn__content")));
       location13.click();
   }
}
