package com.internethero.config;

import com.internethero.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver startTest() {

        driver = DriverFactory.create();
        driver = new EventFiringDecorator(new MyListener()).decorate(driver);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get(Config.baseUrl());

        return driver;
    }

    public void stopTest() {
        driver.quit();
    }
}
