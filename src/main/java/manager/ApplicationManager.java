package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    UserHelper userHelper;

    public void init()
    {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
    }

    public void stop()
    {
        wd.quit();
    }

    public UserHelper getUserHelper() { //getter
        return userHelper;
    }
}
