package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPage extends ResultPage{
    //private WebDriver driver;

    private final By CName = By.xpath("//input[@class=\"js-name\"]");
    private final By CModel = By.xpath("//*[@id='model1']/p[2]/select");
    private final By CYear = By.xpath("//input[@class=\"js-year\"]");
    private final By CColor = By.xpath("//*[@id=\"vehColor\"]");
    private final By CClone = By.xpath("//*[@id=\"cloneVehicle\"]");

    public TestPage(WebDriver driver) {
        //this.driver = driver;
        super(driver);
    }

    public void EnterCName(String Name) {
        driver.findElement(CName).sendKeys(Name, Keys.ENTER);
}

    public void ChooseCModel(String Model) {
        driver.findElement(CModel).click();
        driver.findElement(By.xpath("//*[@value=\"" + Model + "\"]")).click();
    }

    public void EnterCYear(String Year) {
        driver.findElement(CYear).sendKeys(Year, Keys.ENTER);
    }

    public void ChooseCColor(String Color) {
        driver.findElement(CColor).click();
        driver.findElement(By.xpath("//*[@value=\"" + Color + "\"]")).click();
    }

    public void ClickCClone() {
        driver.findElement(CClone).click();
    }


    @Test
    public void TestInput(String Name, String Model, String Color, String Year) {
        EnterCName(Name);
        ChooseCModel(Model);
        EnterCYear(Year);
        ChooseCColor(Color);
        ClickCClone();
        Asserts( Name, Model, Color, Year);
    }

    @Test
    public void TestModification(String Name, String[] Models, String Color, String Year) {
        EnterCName(Name);
        ChooseCModel(Models[1]);
        EnterCYear(Year);
        //ClickCClone();
        //Thread.sleep(2000);
        ChooseCModel(Models[2]);
        ChooseCColor(Color);
        ClickCClone();
        Asserts( Name, Models[2], Color, Year );
    }

    public void Asserts(String Name, String Model, String Color, String Year) {
        Assert.assertEquals(getTName().getAttribute("value"), Name );
        Assert.assertEquals(getTModel().getAttribute("value"),Model );
        Assert.assertEquals(getTColor().getAttribute("value"),Color );
        Assert.assertEquals(getTYear().getAttribute("value"),Year );
    }
}
