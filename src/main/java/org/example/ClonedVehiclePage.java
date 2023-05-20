package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ClonedVehiclePage {
    protected WebDriver driver;


    protected WebElement pageElement;
    protected WebElement TName;
    protected Select TModel;
    protected WebElement TYear;
    protected Select  TColor;

    public ClonedVehiclePage(WebDriver driver) {
        this.driver = driver;
        //вибір області
        pageElement =  driver.findElement(By.id("model2"));
        //елементи
        TName = pageElement.findElement(By.className("js-name"));
        TModel = new Select(pageElement.findElement(By.className("js-model")));
        TYear = pageElement.findElement(By.className("js-year"));
        TColor = new Select(driver.findElement(By.id("vehColor")));
    }

    public WebElement getTName() {
        return TName;
    }

    public Select getTModel() {
        return TModel;
    }

    public WebElement getTYear() {
        return TYear;
    }

    public Select getTColor() {
        return TColor;
    }
}
