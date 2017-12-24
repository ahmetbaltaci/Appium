package com.testCase.hardware;

import com.setup.BaseTest;
import org.testng.annotations.Test;
import page.ChargerTestFunction;

/**
 * Created by ahmetbaltaci on 23.12.2017.
 */
public class HardwareControlButtonTest extends BaseTest {

    @Test
    public void hardwareControlButtonTest() throws InterruptedException {
        ChargerTestFunction chargerTestFunction = new ChargerTestFunction(driver);
        chargerTestFunction.hardwareButtonControlTest();
    }
}
