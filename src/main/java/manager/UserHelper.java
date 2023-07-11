package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver wd) {
        super(wd);
    }
    public void fillLoginForm(String email, String password)
    {
        type(By.xpath("//input[@id='email']"), email);
        pause(2000);
        type(By.xpath("//input[@id='password']"), password);
        pause(2000);
    }

    public boolean isLoginPresent() {
        return isElementPresent(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
    }

    public void logout() {
      click(By.xpath("//a[normalize-space()='Logout']"));
    }

    public void openLoginForm() {
        pause(2000);
        click(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
    }

    public void filolLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"),user.getPassword());
    }

    public void submitForm() {
        click(By.xpath("//button[contains(text(),'alla!')]"));
    }

    public boolean isLoggedSucceess() {
        WebDriverWait wait = new WebDriverWait(wd, 10); //это явное ожиданмие. ждем этой командой когда появится эелемент на странице (10 сек)
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));// ждем когда элемент по локатору станет видимым
        return wd.findElement(By.cssSelector(".dialog-container h2")).getText().contains("success");
    }

    public void clickOkButton() {
        WebElement okButton = wd.findElement(By.xpath("//button[text()='Ok']"));
        if(isElementPresent(By.xpath("//button[text()='Ok']")))
        {
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitForm();
        clickOkButton();
        pause(2000);
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));//poisk locatora po teksty
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public boolean isRegistered() {

        WebDriverWait wait = new WebDriverWait(wd, 10); //это явное ожиданмие. ждем этой командой когда появится эелемент на странице (10 сек)
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));// ждем когда элемент по локатору станет видимым
        return wd.findElement(By.cssSelector(".dialog-container h1")).getText().contains("Registered");
    }

    public void checkPolicy() {
        // click(By.cssSelector(".checkbox-container input"));
        //click(By.cssSelector(".checkbox-container"));

//        JavascriptExecutor js = (JavascriptExecutor) wd;//vipolnit komandy na Java Script
//
//        js.executeScript("document.querySelector('#terms-of-use').checked=true;");
        Actions actions = new Actions(wd);//dlya vipolnenya x i y
        WebElement container = wd.findElement(By.cssSelector(".checkbox-container"));

        Rectangle rect = container.getRect();
      //  int x = rect.getX() +rect.getWidth()/10;
        int x = rect.getX() +5;
     //   int x = rect.getX() +2% *rect.getWidth();
        int y = rect.getY()+(1/4* rect.getHeight());
        //int y = rect.getY()+(rect.getHeight()/4); ili tak (eto vse variatsii rabocie)
        actions.moveByOffset(x,y).click().perform();
    }
}
