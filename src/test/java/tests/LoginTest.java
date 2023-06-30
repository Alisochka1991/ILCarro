package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod
    public void precondition()
    {
        if(!app.getUserHelper().isLoginPresent())//esli NET knopki login to sdelat logout
        {
            app.getUserHelper().logout();
        }
    }
    @Test
    public void loginTest()
    {
        String email ="alisiaagranov@gmail.com";
        String password ="212229Alisa$";

        app.getUserHelper().click(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
        app.getUserHelper().fillLoginForm(email, password);
        app.getUserHelper().click(By.xpath("//button[contains(text(),'alla!')]"));
       //app.getUserHelper().click(By.cssSelector("button[type='submit']")); /variant css selectora
    }
    @Test
    public void loginSuccess()
    {
        User user = new User().setEmail("alisiaagranov@gmail.com").setPassword("212229Alisa$");//вызываем нужные методы о СЕТТЕРАм
        app.getUserHelper().openLoginForm();
       // app.getUserHelper().filolLoginForm("Alisiaagranov@gmail.com","212229Alisa$");
        app.getUserHelper().filolLoginForm(user);
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isLoggedSucceess());
    }
    @AfterMethod
    public void postCondition()
    {
        app.getUserHelper().clickOkButton();
    }
}