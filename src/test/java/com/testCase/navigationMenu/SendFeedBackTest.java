package com.testCase.navigationMenu;

import io.qameta.allure.*;
import listener.TestListener;
import com.setup.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.page.NavigationMenuTestFunction;

/**
 * Created by ahmetbaltaci on 24.12.2017.
 */

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Navigation Menu Bar")
public class SendFeedBackTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Send Feed Back Form is tested. Is it submited ?")
    @Story("Send Feed Back Form Control")
    public void sendFeedBackTest() throws InterruptedException {
        NavigationMenuTestFunction navigation = new NavigationMenuTestFunction(driver);
        navigation.openNavigationMenu();
        navigation.sendFeedBackFrom();
    }

}

