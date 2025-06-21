import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;


class ScreenshotTest{

    public static void take_screenshot() throws Exception{

        File screenshot = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        String screenshot_name = "screenshot.png";
        File FileDist = new File(screenshot_name);

        FileUtils.copyFile(screenshot, FileDist);

        System.out.println("screenshot is saved.....");
    }
}