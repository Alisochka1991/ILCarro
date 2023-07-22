package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
   // WebDriver wd;
    EventFiringWebDriver wd;//vebdraiver dlya listenera

    UserHelper userHelper;
    CarHelper car;

    public void init()
    {
        wd = new EventFiringWebDriver(new ChromeDriver());
        logger.info("Testts starts on Chrome Driver");
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        car = new CarHelper(wd);
        wd.register(new MyListener());
    }

    public void stop()
    {
        wd.quit();
    }

    public UserHelper getUserHelper() { //getter
        return userHelper;
    }

    public CarHelper getCar() { //getter dlya carhelpera
        return car;
    }
}
