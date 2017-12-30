package listener;

import com.relevantcodes.extentreports.LogStatus;
import com.setup.BaseTest;
import com.setup.GetDeviceCapability;
import com.setup.GetEnvironment;
import com.setup.GetIp;
import io.qameta.allure.Attachment;
import listener.extendManager.ExtendManager;
import listener.extendManager.ExtendTestManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class TestListener extends BaseTest implements ITestListener {

    private Logger log = LogManager.getLogger(getClass().getName());
    private GetDeviceCapability capability = new GetDeviceCapability();
    private GetEnvironment environment = new GetEnvironment();

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtendTestManager.startTest(result.getMethod().getMethodName(), "");
        MDC.put("deviceName", capability.getCapability("deviceName"));
        MDC.put("platformVersion", capability.getCapability("platformVersion"));
        MDC.put("appVersion", environment.getEnvironment("appVersion"));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtendTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        //Allure ScreenShotRobot and SaveTestLog
        if (driver != null) {
            saveScreenshotPNG(driver);
        }
        //Save a log on allure.

        saveTextLog(getTestCaseName() + " failed and screenshot taken!");
        //Take base64Screenshot screenshot for extent reports
        assert ((TakesScreenshot) driver) != null;
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.BASE64);
        //Extentreports log and screenshot operations for failed tests.
        ExtendTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
                ExtendTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtendTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext context) {
        setTestCaseName(context.getName());
        setTestStartTime(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        GetIp ip = new GetIp();
        MDC.put("ip", ip.getIP());
        MDC.put("testCaseName", getTestCaseName());
    }

    @Override
    public void onFinish(ITestContext context) {
        setTestFinishTime(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        setTestDurationTime(getTestFinishTime() - getTestStartTime());
        MDC.put("testDuration", getTestDurationTime());
        ExtendTestManager.endTest();
        ExtendManager.getReporter().flush();
    }

}
