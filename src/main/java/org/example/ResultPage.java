package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
    protected WebDriver driver;



    protected final By TName = By.xpath("//*[@id=\"model2\"]/p[1]/input");
    protected final By TModel = By.xpath("//*[@id=\"model2\"]/p[2]/select");
    protected final By TYear = By.xpath("//*[@id=\"model2\"]/p[4]/input");
    protected final By TColor = By.xpath("//*[@id=\"model2\"]/p[3]/input");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String[] findObjects(By Object){
        WebElement selectObject = driver.findElement(Object);
        return selectObject.findElements(By.tagName("option"))
                .stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
    }


    public WebElement getTName() {
        return driver.findElement(TName);
    }

    public WebElement getTModel() {
        return driver.findElement(TModel);
    }

    public WebElement getTYear() {
        return driver.findElement(TYear);
    }

    public WebElement getTColor() {
        return driver.findElement(TColor);
    }
}
