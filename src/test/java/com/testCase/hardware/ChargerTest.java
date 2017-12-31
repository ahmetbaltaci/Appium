package com.testCase.hardware;

import io.qameta.allure.*;
import io.qameta.allure.SeverityLevel;
import listener.TestListener;
import com.setup.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.page.ChargerTestFunction;


@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Hardware")
public class ChargerTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Is charger plugin check of your mobile device")
    @Story("Charger Plugin Test")
    public void chargerTest() throws InterruptedException {
        ChargerTestFunction chargerTestFunction = new ChargerTestFunction(driver);
        chargerTestFunction.chargerTest();
    }
}
