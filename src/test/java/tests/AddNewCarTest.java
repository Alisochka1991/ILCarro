package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends TestBase {
    @BeforeMethod
    public void precondition()
    {
        if(app.getUserHelper().isLoginPresent())
        {
            app.getUserHelper().login(new User()
                    .setEmail("alisiaagranov@gmail.com")
                    .setPassword("212229Alisa$"));
        }
    }
    @Test
    public void addNewCarTest()
    {
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        Car car = Car.builder()
                .address("Tel Aviv")
                .manufacture("BMW")
                .model("X5")
                .year("2023")
                .fuel("Hybrid")
                .seats("4")
                .carClass("A")
                .registerNumber("212229"+i)
                .price("550$")
                .about("Hui bolshoi")
                .build(); //tak stroitsa obekt s lombok
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachPhoto("C:\\QA_30_Phonebook\\ILCarro\\1675959631284.jpg");
        app.getCar().submitFormCar();
        Assert.assertTrue(app.getCar().isCarAdded());

    }
//    @AfterMethod
//    public void postCondition()
//    {
//        app.getCar().submitAddedCar();
//        app.getUserHelper().logout();
//    }

}
