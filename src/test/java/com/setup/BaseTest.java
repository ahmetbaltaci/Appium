package com.setup;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import page.SkipAppFunction;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * Created by ahmetbaltaci on 22.12.2017.
 */
public class BaseTest {

    protected static AppiumDriver driver;
    private String env = System.getProperty("env");


    private String device;
    private String version;
    private String url;

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
        if (env != null) {
            setDevice(environment.env().getAsJsonObject(env).getAsJsonPrimitive("device").getAsString());
            setVersion(environment.env().getAsJsonObject(env).getAsJsonPrimitive("version").getAsString());
            setUrl(environment.env().getAsJsonObject(env).getAsJsonPrimitive("url").getAsString());
        } else {
            setDevice("192.168.56.101:5555");
            setVersion("6.0");
            setUrl("http://127.0.0.1:4723/wd/hub");
        }
        DeviceSetup.prepareDevice(getDevice(), getVersion(), getUrl());
        SkipAppFunction skipAppFunction = new SkipAppFunction(driver);
        skipAppFunction.clickNextButton();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
