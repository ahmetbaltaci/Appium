package com.setup;

import static com.setup.BaseTest.driver;

/**
 * Created by ahmetbaltaci on 30.12.2017.
 */
public class GetDeviceCapability  {
    public String getCapability(String capability){
        return (String) driver.getCapabilities().getCapability(capability);
    }
}
