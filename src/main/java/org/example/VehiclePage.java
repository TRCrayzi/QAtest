package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class VehiclePage extends ClonedVehiclePage {
    private final By CClone = By.xpath("//*[@id=\"cloneVehicle\"]");

    public VehiclePage(WebDriver driver) {
        super(driver);
        //вибір області
        pageElement = driver.findElement(By.id("model1"));
        //елементи)
        TName = pageElement.findElement(By.className("js-name"));
        TModel = new Select(pageElement.findElement(By.className("js-model")));
        TYear = pageElement.findElement(By.className("js-year"));
        TColor = new Select(driver.findElement(By.id("vehColor")));
    }

    public void EnterCName(String Name) {  TName.sendKeys(Name, Keys.ENTER);  }

    public void ChooseCModel(String Model) {
        TModel.selectByVisibleText(Model);
    }

    public void EnterCYear(String Year) { TYear.sendKeys(Year, Keys.ENTER);  }

    public void ChooseCColor(String Color) {
        TColor.selectByVisibleText(Color);
    }

    public void ClickCClone() {
        driver.findElement(CClone).click();
    }

    public void TestInput(String Name, String Model, String Color, String Year) {
        EnterCName(Name);
        ChooseCModel(Model);
        EnterCYear(Year);
        ChooseCColor(Color);
        ClickCClone();
    }

    public void TestModification(String Name, String Model1, String Model2, String Color, String Year) {
        EnterCName(Name);
        ChooseCModel(Model1);
        EnterCYear(Year);
        ChooseCModel(Model2);
        ChooseCColor(Color);
        ClickCClone();
    }
}
