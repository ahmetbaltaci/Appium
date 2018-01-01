package com.setup;

import com.page.SkipAppFunction;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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
    private long testStartTime;
    private long testFinishTime;
    private long testDurationTime;
    private String suiteName;
    private String testFailedMsg;

    public WebDriver getDriver() {
        return driver;
    }

    protected String getSuiteName() {
        return suiteName;
    }

    protected void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    protected long getTestStartTime() {
        return testStartTime;
    }

    protected void setTestStartTime(long testStartTime) {
        this.testStartTime = testStartTime;
    }

    protected long getTestFinishTime() {
        return testFinishTime;
    }

    protected void setTestFinishTime(long testFinishTime) {
        this.testFinishTime = testFinishTime;
    }

    protected long getTestDurationTime() {
        return testDurationTime;
    }

    protected void setTestDurationTime(long testDurationTime) {
        this.testDurationTime = testDurationTime;
    }

    protected String getTestCaseName() {
        return testCaseName;
    }

    protected void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestFailedMsg() {
        return testFailedMsg;
    }

    public void setTestFailedMsg(String testFailedMsg) {
        this.testFailedMsg = testFailedMsg;
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


    @BeforeSuite()
    public void setUp() throws MalformedURLException, InterruptedException, FileNotFoundException {
        GetEnvironment environment = new GetEnvironment();
        setDevice(environment.getEnvironment("device"));
        setVersion(environment.getEnvironment("version"));
        setUrl(environment.getEnvironment("url"));
        DeviceSetup.prepareDevice(getDevice(), getVersion(), getUrl());
        SkipAppFunction skipAppFunction = new SkipAppFunction(driver);
        skipAppFunction.clickNextButton();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
