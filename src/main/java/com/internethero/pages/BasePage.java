package com.internethero.pages;

import com.internethero.config.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Config.timeoutSec()));
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickWithJS(WebElement element) {
        scrollToElement(element);
        click(element);
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void typeWithJs(WebElement element, String text) {
        scrollToElement(element);
        type(element, text);
    }

    protected void type(WebElement element, String text) {
        if (text != null) {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean shouldHaveText(WebElement element, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void hideAd() {
        js.executeScript("document.getElementById('fixedban').style.display = 'none';");
    }

    public void hideFooter() {
        js.executeScript("document.querySelector('footer').style.display = 'none';");
    }

    public void hideIframes() {
        hideAd();
        hideFooter();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;

        } catch (NoSuchElementException e) {
            e.getMessage();
            return false;
        }
    }


    public boolean isAlertPresent() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.alertIsPresent())
                    .accept();
            return true;

        } catch (TimeoutException e) {
            return false;
        }
    }
}
