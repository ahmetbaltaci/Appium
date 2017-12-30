package com.setup;

import com.page.SkipAppFunction;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * Created by ahmetbaltaci on 22.12.2017.
 */
public class BaseTest {

    protected static AppiumDriver driver;
    private String env = System.getProperty("getEnvironment");
    private String device;
    private String version;
    private String url;

    private String testCaseName;

    protected String getTestCaseName() {
        return testCaseName;
    }
    protected void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    private String getDevice() {
        return device;
    }
    private void setDevice(String device) {
        this.device = device;
    }
    private String getVersion() {
        return version;
    }
    private void setVersion(String version) {
        this.version = version;
    }
    private String getUrl() {
        return url;
    }
    private void setUrl(String url) {
        this.url = url;
    }



    @BeforeClass()
    public void setUp() throws MalformedURLException, InterruptedException, FileNotFoundException {
        GetEnvironment environment = new GetEnvironment();
            setDevice(environment.getEnvironment("device"));
            setVersion(environment.getEnvironment("version"));
            setUrl(environment.getEnvironment("url"));
        DeviceSetup.prepareDevice(getDevice(), getVersion(), getUrl());
        SkipAppFunction skipAppFunction = new SkipAppFunction(driver);
        skipAppFunction.clickNextButton();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
