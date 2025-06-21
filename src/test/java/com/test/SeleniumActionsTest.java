import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumActionsTest extends BaseTest {

    @Test(priority=1)
    public void openPage() {
        System.out.println("Page opened");
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @Test(priority=2)
    void getTitle(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h1[normalize-space()='Automation Demo Site']")));

            WebElement Title = driver.findElement(By.xpath("//h1[normalize-space()='Automation Demo Site']"));
            System.err.println("Page title is = "+Title);
            ScreenshotTest.take_screenshot();
        }catch(Exception e){
            System.out.println("Exception message = "+e);

        }
      
    }
}
