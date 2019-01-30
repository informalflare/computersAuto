package Browsers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

    private static Properties props = new Properties();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getInstance() {
        return driver.get();
    }

    public static WebDriver openBrowser() {
        try {
            props.load(new FileInputStream("src/main/resources/project.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ChromeOptions options = new ChromeOptions();
        if (props.getProperty("HEADLESS").equals("YES")) {
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
        }
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver(options));
        return driver.get();
    }

    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public static void teardown() {
        driver.get().quit();
        driver.set(null);
    }
}
