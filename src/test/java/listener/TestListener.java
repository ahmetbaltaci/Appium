package listener;

import com.setup.BaseTest;
import com.setup.GetDeviceCapability;
import com.setup.GetEnvironment;
import com.setup.GetIp;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.testng.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by ahmetbaltaci on 23.12.2017.
 */
public class TestListener extends BaseTest implements ITestListener,ISuiteListener {

    private Logger log = LogManager.getLogger(getClass().getName());
    private long testStartTime;
    private GetDeviceCapability capability = new GetDeviceCapability();
    private GetEnvironment environment = new GetEnvironment();


    @Override
    public void onTestStart(ITestResult result) {
        MDC.put("deviceName", capability.getCapability("deviceName"));
        MDC.put("platformVersion", capability.getCapability("platformVersion"));
        MDC.put("appVersion", environment.getEnvironment("appVersion"));
        System.out.println(environment.getEnvironment("appVersion"));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("succsess test");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("fail test");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("skip test");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("percentage test");
    }

    @Override
    public void onStart(ITestContext context) {
        setTestCaseName(context.getName());
        MDC.put("testCaseName", getTestCaseName());
        GetIp ip = new GetIp();
        MDC.put("ip", ip.getIP());
        testStartTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    @Override
    public void onFinish(ITestContext context) {
        long testFinishTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        long testDuration = testFinishTime - testStartTime;
        MDC.put("testDuration", testDuration);
    }

    @Override
    public void onStart(ISuite suite) {
        suite.getXmlSuite().getName();
    }

    @Override
    public void onFinish(ISuite suite) {

    }
}
