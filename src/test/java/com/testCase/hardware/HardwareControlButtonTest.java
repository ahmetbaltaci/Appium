package com.testCase.hardware;

import com.setup.BaseTest;
import io.qameta.allure.*;
import listener.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.page.ChargerTestFunction;


@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Hardware")
public class HardwareControlButtonTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description:Hardware button control test. Volume_Up,Volume_Down,Power buttons are Controled")
    @Story("Hardware Button Control Test")
    public void hardwareControlButtonTest() throws InterruptedException {
        ChargerTestFunction chargerTestFunction = new ChargerTestFunction(driver);
        chargerTestFunction.hardwareButtonControlTest();
    }
}
