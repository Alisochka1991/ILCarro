package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase{
    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.xpath("//a[@id='1']"));
        pause(3000);
    }

    public void fillCarForm(Car car) {
        if(isCarCreationFormPresent())
        {
            typeAddress(car.getAddress()); //autoComplited
            type(By.id("make"),car.getManufacture());
            type(By.xpath("//input[@id='model']"),car.getModel());
            type(By.id("year"),car.getYear());

            select(By.id("fuel"),car.getFuel()); //dlya vipadauseo spiska
            type(By.id("seats"),car.getSeats());
            type(By.id("class"),car.getCarClass());
            type(By.id("serialNumber"),car.getRegisterNumber());
            type(By.id("price"),car.getPrice());
            type(By.id("about"),car.getAbout());

        }
    }


    public void select (By locator, String option)
    {
       // new Select(wd.findElement(locator)).selectByIndex(1); //poryadkovi nomer v spiske
     // new Select(wd.findElement(locator)).selectByValue("Diesel");// po value
      new Select(wd.findElement(locator)).selectByValue(option);// po value universalny

      //  new Select(wd.findElement(locator)).selectByVisibleText(" Diesel "); //po text
    }

    private void typeAddress(String location) {

        type(By.id("pickUpPlace"),location);
        click(By.cssSelector("div.pac-item")); //metod dlya autoComplit
        pause(1000);
    }

    private boolean isCarCreationFormPresent() {
        Boolean isForm = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("h2")),"Write some details about your car to rent it out"));

                return isForm;
    }

    public void attachPhoto() { //predvaritelno polozit kartinky v propekt
        wd.findElement(By.id("photos")).sendKeys("C:\\QA_30_Phonebook\\ILCarro\\1675959631284.jpg"); //kopy path iz proekta
    }

    public void submitFormCar() {
        WebElement submit = wd.findElement(By.cssSelector("[type='submit']"));
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.elementToBeClickable(submit));
        submit.submit(); //zdem poka foto gruzitsa i knopka stanet clickable
       // click(By.xpath("//button[normalize-space()='Submit']"));
    }
}
