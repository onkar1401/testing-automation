import java.time.Duration;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.wait;
import org.bouncycastle.jcajce.provider.asymmetric.EC;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

    @Test(priority=3)
    void test_registraction_form() throws InterruptedException{

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Onkar");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Mali");
        
        
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("onkar@test.com");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9876543210");
        driver.findElement(By.xpath("//label[normalize-space()='Male']")).click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@type = 'checkbox']"));
        System.err.println(checkboxes.size());
        for(int i =0;i < checkboxes.size(); i++){
            if (!checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }
            
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement countryContainer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='select2-selection select2-selection--single']")));
        countryContainer.click();

        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys("India");
        driver.findElement(By.xpath("//*[@class='select2-results__option select2-results__option--highlighted']")).click();

       Thread.sleep(2000);
    }

    @Test
    void test_automcomplete() throws InterruptedException{

        try {

            driver.get("https://demo.automationtesting.in/AutoComplete.html");
            driver.findElement(By.xpath("//*[@class='ui-autocomplete-multiselect ui-state-default ui-widget']")).sendKeys("India");
            Thread.sleep(500);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
