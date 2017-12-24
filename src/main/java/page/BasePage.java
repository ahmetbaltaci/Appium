package page;

import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


class BasePage {

    public AppiumDriver driver;
    public By closeButton = By.id("com.testm.app:id/back_cancel_button");

    //Constructor
    BasePage(AppiumDriver driver) {
        this.driver = driver;
    }


    void click(By element) throws InterruptedException {
        boolean clickStatus = false;
        for (int i = 0; i < 10; i++) {
            try {
                WebElement clickElement = driver.findElement(element);
                Assert.assertTrue(clickElement.isEnabled());
                clickElement.click();
                clickStatus = true;
                break;
            } catch (Exception | AssertionError e) {
                Thread.sleep(500);
            }
        }

        try {
            Assert.assertTrue(clickStatus);
        } catch (AssertionError e) {
            throw new AssertionError(element + " is not click");
        }
    }

    String getText(By element) throws InterruptedException {
        boolean status = false;
        String msg = "";
        for (int i = 0; i < 10; i++) {
            try {
                WebElement clickElement = driver.findElement(element);
                Assert.assertTrue(clickElement.isEnabled());
                msg = clickElement.getText();
                status = true;
                break;
            } catch (Exception | AssertionError e) {
                Thread.sleep(500);
            }
        }
        try {
            Assert.assertTrue(status);
        } catch (AssertionError e) {
            throw new AssertionError(element + " is not found");
        }
        return msg;
    }

    boolean isEnableElement(By element) throws InterruptedException {
        boolean enableElement = false;
        for (int i = 0; i < 5; i++) {
            try {
                Assert.assertTrue(driver.findElement(element).isEnabled());
                enableElement = true;
                break;
            } catch (Exception | AssertionError e) {
                Thread.sleep(500);
            }
        }

        try {
            Assert.assertTrue(enableElement);
        } catch (
                AssertionError e) {
            throw new AssertionError(element + " is not enable");
        }
        return true;
    }

    void assertText(By element, String text) throws InterruptedException {
        for (int i=0; i<10; i++) {
            boolean status=false;
            String exceptionMsg = "";
            try {
                org.testng.Assert.assertEquals(getText(element),text);
                status=true;
            }catch (Exception | AssertionError e){
                exceptionMsg=e.getMessage();
                Thread.sleep(1000);
            }
            try {
                org.testng.Assert.assertTrue(status);
            }catch (AssertionError e){
                throw new AssertionError(exceptionMsg);
            }
        }
    }

}
