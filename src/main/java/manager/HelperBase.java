package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) { //konstructor
        this.wd = wd;
    }
    public void type(By locator, String text)
    {
        if(text != null && !text.isEmpty())
        {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void click(By locator)
    {
        wd.findElement(locator).click();
    }
    public void pause(int mills)
    {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElementPresent(By locator)
    {
        return wd.findElements(locator).size()>0;
    }

    public void takescreenshot(String link)
    {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(link);
        try {
            Files.copy(tmp, screenshot);
        }
        catch (IOException exeption)
        {
            exeption.printStackTrace();
        }

    }
}
