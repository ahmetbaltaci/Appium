package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;


public class SkipAppFunction extends BasePage {

    private By nextButton = By.xpath("//*[@text='next']");
    private By NextButton = By.xpath("//*[@text='Next']");
    private By gotItButton = By.id("com.testm.app:id/gotItBtn");

    public SkipAppFunction(AppiumDriver driver) {
        super(driver);
    }


    @Step("Skip Presentation")
    public void clickNextButton() throws InterruptedException {
        try {
            do {
                click(nextButton);
            } while (isEnableElement(nextButton));
        } catch (AssertionError e) {
            Thread.sleep(10);
        }
        try {
            Assert.assertTrue(isEnableElement(NextButton));
            try {
                driver.tap(1, 400, 600, 2000);
            } catch (Exception e) {
                Thread.sleep(10);
            }
            click(gotItButton);
        } catch (Exception | AssertionError e) {
            Thread.sleep(10);
        }
    }
}
