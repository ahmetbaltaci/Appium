package com.testCase.navigationMenu;

import Listener.TestListener;
import com.setup.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.NavigationMenuTestFunction;

/**
 * Created by ahmetbaltaci on 24.12.2017.
 */

@Listeners(TestListener.class)
public class SendFeedBackTest extends BaseTest {

    @Test
    public void sendFeedBackTest() throws InterruptedException {
        NavigationMenuTestFunction navigation = new NavigationMenuTestFunction(driver);
        navigation.openNavigationMenu();
        navigation.sendFeedBackFrom();
    }

}

