package com.page;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/**
 * Created by ahmetbaltaci on 12.05.2018.
 */
public class NewsMenu extends BasePage {
    public NewsMenu(AppiumDriver driver) {
        super(driver);
    }

    private By newsBtn = By.id("Haberler");
    private By title = By.id("HABERLER");

    @Step("Haberler Sekmesinin Açılması")
    public void openNewsTab() throws InterruptedException {
        click(newsBtn);
        assertText(title, "HABERLER");
    }
}
