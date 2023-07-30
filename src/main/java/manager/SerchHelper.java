package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class SerchHelper extends HelperBase{
    public SerchHelper(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(String city, String from, String to) {
        fillInputCity(city);
        selectPeriod(from, to);
    }

    private void selectPeriod(String from, String to) {
        String[] dataFrom = from.split("/");
        String[] dataTo = to.split("/");
        click(By.id("dates"));

        int diffStart = 0;
        if(LocalDate.now().getMonthValue()!=Integer.parseInt(dataFrom[0]))
        {
            diffStart = Integer.parseInt(dataFrom[0])-LocalDate.now().getMonthValue();//click na treygolnik v kalendare

        }
        int diffEnd=0;
       if (Integer.parseInt(dataFrom[0])!=Integer.parseInt(dataTo[0]))
        {
            diffEnd = Integer.parseInt(dataTo[0])-Integer.parseInt(dataFrom[0]);
        }

        for (int i = 0; i < diffStart; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locator3 = String.format("//div[.=' %s ']",dataFrom[1]);//ispolzovat odny iz eti zapisey
        click(By.xpath(locator3));

        for (int i = 0; i < diffEnd; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locator4 = String.format("//div[.=' %s ']",dataTo[1]);//ispolzovat odny iz eti zapisey
        click(By.xpath(locator4));

        String locator = "//div[.=' 30 ']";//vydelit vsegda 30
        String locator2 = "//div[.=' "+dataFrom[1]+" ']";//vychitayet iz strina 30 i s konkatinaciei podstavit

    }

    private void fillInputCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector("div.pac-item"));
        pause(500);

    }
}
