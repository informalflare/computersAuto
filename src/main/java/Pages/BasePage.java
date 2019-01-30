package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browsers.Browser;
import Utils.Log;

public class BasePage {

    public static Properties getProps() {
        return props;
    }

    protected static Properties props = new Properties();

    public BasePage() {
        PageFactory.initElements(Browser.getInstance(), this);
        try {
            props.load(new FileInputStream("src/main/resources/project.properties"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    protected WebDriverWait initWait(int time) {
        return new WebDriverWait(Browser.getInstance(), (long) time);
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Browser.getInstance())
                .executeScript("arguments[0].scrollIntoView(false);", new Object[] { element });
    }

    public void enterText(WebElement element, String input) throws Exception {
        try {
            if (!input.equals("")) {
                this.initWait(20).until(ExpectedConditions.elementToBeClickable(element));
                element.clear();
                element.sendKeys(new CharSequence[] { input });
            }

        } catch (Exception var4) {
            Log.error("Unable to enter text " + element);
            throw new Exception(var4);
        }
    }

    public String getText(WebElement element) throws Exception {
        try {
            return element.getText();
        } catch (Exception var3) {
            Log.error("Unable to get text " + element);
            throw new Exception(var3);
        }
    }

    public void clickButton(WebElement element) {
        try {
            this.waitForElementToBeClickable(element);
            element.click();
        } catch (Exception var3) {
            Log.error("Click failed for element " + element);
            var3.printStackTrace();
        }
    }

    public void waitForElementToLoad(WebElement element) throws Exception {
        try {
            this.initWait(60).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception var3) {
            Log.error("Wait for element failed. Exception  :" + var3);
            throw new Exception(var3);
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        this.initWait(60).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForJQuery() {
        this.initWait(60).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js
                        .executeScript("return (typeof jQuery == 'undefined') || jQuery.active == 0", new Object[0]);
            }
        });
    }

    public void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(
                        ((JavascriptExecutor) driver).executeScript("return document.readyState", new Object[0])
                                .equals("complete"));
            }
        };
        this.initWait(60).until(pageLoadCondition);
    }


    public WebElement highlightAndMoveToElement(WebElement elem) {
        if (Browser.getInstance() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) Browser.getInstance())
                    .executeScript("arguments[0].style.border='3px solid red'", new Object[] { elem });
            ((JavascriptExecutor) Browser.getInstance())
                    .executeScript("arguments[0].scrollIntoView(true);", new Object[] { elem });
        }

        return elem;
    }
    public void simpleClickElementJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Browser.getInstance();
        executor.executeScript("arguments[0].click();", new Object[] { element });
    }
    public void clickWithJS(WebElement el) {
        JavascriptExecutor executor = (JavascriptExecutor) Browser.getInstance();
        executor.executeScript("arguments[0].click();", new Object[] { el });
    }
}
