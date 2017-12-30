package com.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.testng.Assert;


/**
 * Created by ahmetbaltaci on 23.12.2017.
 */
public class ChargerTestFunction extends BasePage {

    private By hardwareButton = By.id("com.testm.app:id/hardware_pb");
    private By startButton = By.id("com.testm.app:id/startTestTv");
    /**
     * Charger Test
     */
    private By chargerButton = By.id("com.testm.app:id/charger_bt");
    private By chargerTestResult = By.id("com.testm.app:id/test_details");
    /**
     * Hardware Button Control
     */
    private By hardwareButtonControlResult = By.id("com.testm.app:id/test_details");
    private By hardwareButtonControl = By.id("com.testm.app:id/hardwareButtons_bt");
    public ChargerTestFunction(AppiumDriver driver) {
        super(driver);
    }

    public void chargerTest() throws InterruptedException {
        click(hardwareButton);
        click(chargerButton);
        click(startButton);
        String chargerTestSuccsessMsg = "The Charger check passed the test";
        Assert.assertEquals(getText(chargerTestResult), chargerTestSuccsessMsg);
        click(closeButton);
    }

    public void hardwareButtonControlTest() throws InterruptedException {
        click(hardwareButton);
        click(hardwareButtonControl);
        click(startButton);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
        String hardwareButtonControlSuccessMsg = "The Hardware Buttons check passed the test";
        Assert.assertEquals(getText(hardwareButtonControlResult), hardwareButtonControlSuccessMsg);
        click(closeButton);
    }


}
