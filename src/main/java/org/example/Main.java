package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.TestNG;

import java.time.Duration;

public class Main {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseUrl = System.getProperty("user.dir") + "\\src\\main\\resources\\AQA_Test_Task.html";

        driver.get(baseUrl);

        TestNG testing = new TestNG();
        testing.setTestClasses(new Class[]{Tests.class});
        testing.run();

        Thread.sleep(10000);
        driver.quit();

    }
}