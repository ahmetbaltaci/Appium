package com.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


class BasePage {

    public AppiumDriver driver;
    private WebDriverWait wait;
    By closeButton = By.id("com.testm.app:id/back_cancel_button");

    //Constructor
    BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    void click(By element) throws InterruptedException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    String getText(By element) throws InterruptedException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    boolean isEnableElement(By element) throws InterruptedException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertTrue(driver.findElement(element).isEnabled());
        return true;
    }

    void assertText(By element, String text) throws InterruptedException {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertEquals(driver.findElement(element).getText(),text);
    }
}
