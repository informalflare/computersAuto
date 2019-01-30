//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.herokuapp.computer_database.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Browsers.Browser;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;

public class Hooks {

    public Hooks() {
    }

    @Before
    public void beforeHook(Scenario scenario) {
        System.out.println(scenario.getName() + " STARTS");

        Browser.openBrowser();
    }

    @After
    public void afterHook(Scenario scenario) {
        System.out.println(scenario.getName() + " ENDS");
        takeScreenshot();
        Browser.teardown();
    }

    @Attachment(value = "ScreenShot")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) Browser.getInstance()).getScreenshotAs(OutputType.BYTES);
    }
}
