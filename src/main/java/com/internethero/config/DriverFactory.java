package com.internethero.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver create() {
        String browser = Config.browser().toLowerCase();

        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if (Config.headless()) {
                    options.addArguments("--headless=new");
                }
                return new ChromeDriver(options);

            case "firefox":
                return new FirefoxDriver();

            case "edge":
                return new EdgeDriver();

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

}
