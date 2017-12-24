package page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by ahmetbaltaci on 22.12.2017.
 */
public class SkipAppFunction extends BasePage {

    private By nextButton = By.xpath("//*[@text='next']");
    private By gotItButton = By.id("com.testm.app:id/gotItBtn");
    public SkipAppFunction(AppiumDriver driver) {
        super(driver);
    }

    public void clickNextButton() throws InterruptedException {
        try {
            do {
                click(nextButton);
            } while (isEnableElement(nextButton));
        } catch (AssertionError e) {
            Thread.sleep(10);
        }
     /*   try {
            driver.tap(1, 400, 600, 2000);
        } catch (Exception e) {
            Thread.sleep(10);
        }
        click(gotItButton);*/
    }
}
