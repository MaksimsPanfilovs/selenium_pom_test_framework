package com.internethero.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {

    Logger logg = LoggerFactory.getLogger(MyListener.class);

    private void takeScreenShot(WebDriver driver) {

        try {

            File folder = new File("screenshots");
            if (!folder.exists()) folder.mkdir();

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "screenshots/screen-" + System.currentTimeMillis() + ".png";
            Files.copy(src, new File(path));

            logg.info("Screenshot saved: " + path);

        } catch (IOException e) {

            logg.error("Screenshot error", e);

        }
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {

        logg.error("Test error in method: {}" + method.getName());
        logg.error("Exception: {}" + e.getTargetException());

        if (target instanceof WebDriver driver) {
            takeScreenShot(driver);
            AllureUtils.takeScreenshot(driver);
        }
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        logg.info("The locator will find " + locator);
        logg.info("**********************************");

    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        logg.info("The locator is " + locator);
        logg.info("**********************************");

    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
        logg.info("Before Find Elements " + locator);
        logg.info("**********************************");
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        logg.info("List size is " + result.size());
        logg.info("**********************************");
    }

}
