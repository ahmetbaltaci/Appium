package com.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DeviceSetup extends BaseTest {


   static AppiumDriver prepareDevice() throws MalformedURLException {
        File appDir = new File("/application");
        File app = new File(appDir, "foreksmobile.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "MAC");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"ahmet");
        capabilities.setCapability("udid","82e1c906c4d00c16b24198035f0c2035d3d78ddf");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability("appium-version", "1.7.2");
        capabilities.setCapability("autoAcceptAlerts",false);
        capabilities.setCapability("noReset","true");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
   }
}
