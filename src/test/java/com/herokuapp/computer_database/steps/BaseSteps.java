package com.herokuapp.computer_database.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

public class BaseSteps {

    static Properties props = new Properties();

    BaseSteps() {
        try {
            props.load(new FileInputStream("src/main/resources/project.properties"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public void clearAndWriteInto(WebElement el, String info){
        el.clear();
        el.sendKeys(info);
    }


}
