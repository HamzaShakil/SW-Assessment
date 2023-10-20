package Util;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DriverManager {
    public static WebDriver webDriver;

    @Before
    public static void setup(){
        System.out.println("setup");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        String customResultsDirectory = "src/main/resources/allure-results";
        System.setProperty("allure.results.directory", customResultsDirectory);
    }
    @AfterStep
    public void afterMethod(Scenario result) {
        if (result.getStatus() == Status.FAILED) {
            // Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot) webDriver;
            byte[] screenshotData = screenshot.getScreenshotAs(OutputType.BYTES);

            // Attach screenshot to Allure report
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotData));
            webDriver.quit();
        }
    }
    @After
    public static void tearDown() throws IOException {
        System.out.println("tearDown");
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
