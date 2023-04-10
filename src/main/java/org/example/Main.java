package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseUrl = System.getProperty("user.dir") + "\\src\\main\\resources\\AQA_Test_Task.html";

        driver.get(baseUrl);
        WebElement selectModel = driver.findElement(By.xpath("//*[@id='model1']/p[2]/select"));
        String[] Models = selectModel.findElements(By.tagName("option"))
                .stream()
                .map(WebElement::getText)
                .toArray(String[]::new);

        WebElement selectColor = driver.findElement(By.xpath("//*[@id=\"vehColor\"]"));
        String[] Colors = selectColor.findElements(By.tagName("option"))
                .stream()
                .map(WebElement::getText)
                .toArray(String[]::new);

        TestPage testpage =new TestPage(driver);

        //Task 1
        //test
        Thread.sleep(500);
        testpage.TestInput("Vehicle 1", Models[1], Colors[1], "2020");

        Thread.sleep(5000);
        driver.navigate().refresh();

        //Task 2
        //test
        Thread.sleep(500);
        testpage.TestModification("Vehicle 1", Models, Colors[1], "2020");

        Thread.sleep(10000);
        driver.quit();

    }
}