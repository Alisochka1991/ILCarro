package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SerchTest extends TestBase{
    @Test
    public void serchTest()
    {
        app.getSearch().fillSearchForm("Haifa","07/30/2023","07/31/2023");
        app.getUserHelper().submitForm();

       // Assert.assertTrue(app.getSearch().isListofCarAppeared());
    }
}
