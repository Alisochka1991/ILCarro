package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
    @Test
    public void reistrationPositive()
    {
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        User user = new User().setName("Alisa").setLastName("Sosisa")
                .setEmail("kakashki"+i+"@gmail.com")
                .setPassword("212229Alisa$");
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().checkPolicy();
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isRegistered());
    }

    @AfterMethod
    public void postCondition()
    {
        app.getUserHelper().clickOkButton();
    }
}


