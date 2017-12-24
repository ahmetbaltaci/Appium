package Listener;

import com.setup.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by ahmetbaltaci on 23.12.2017.
 */
public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("start test");
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
        System.out.println("on start test");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("finish test");
    }

}
