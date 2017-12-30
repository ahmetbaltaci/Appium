package com.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by ahmetbaltaci on 24.12.2017.
 */
public class NavigationMenuTestFunction extends BasePage {

    private By navigationMenu = By.xpath("//*[@content-desc='Navigate up']");
    private By sendFeedBackButton = By.xpath("//*[@text='Send Feedback']");
    private By closeDialogButton = By.id("com.testm.app:id/closeDialogIv");
    /**Send Feed Back Form*/
    private By name = By.id("com.testm.app:id/fb_name");
    private By email = By.id("com.testm.app:id/fb_email");
    private By body = By.id("com.testm.app:id/fb_body");
    private By sendFormBtn = By.id("com.testm.app:id/add_review_bt_txt");
    /*Response Dialog Window*/
    private By responseMessage = By.id("android:id/message");
    private By closeResponseDialogBtn = By.xpath("//*[@text='Close']");

    public NavigationMenuTestFunction(AppiumDriver driver) {
        super(driver);
    }

    public void openNavigationMenu() throws InterruptedException {
        boolean status = false;
        do {
            click(navigationMenu);
            click(closeDialogButton);
            status = isEnableElement(sendFeedBackButton);
        } while (!status);
    }

    public void sendFeedBackFrom() throws InterruptedException {
        click(sendFeedBackButton);
        driver.findElement(name).sendKeys("test");
        driver.findElement(email).sendKeys("test@test.com");
        driver.findElement(body).sendKeys("example");
        click(sendFormBtn);
        String responseMessageValue = "Thank You!";
        assertText(responseMessage,responseMessageValue);
        click(closeResponseDialogBtn);
    }
}
