package org.the.score.common.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InputActions {
    private WaitActions waitActions;
    private WebDriver driver;

    public InputActions(WaitActions waitActions, WebDriver driver) {
        this.waitActions = waitActions;
        this.driver = driver;
    }

    public void type(WebElement element, String value) {
        waitActions.waitForElementIsDisplayed(element);
        waitActions.waitForElementIsClickable(element);

        element.sendKeys(value);
        ExpectedConditions.textToBePresentInElement(element, value);
    }

    public void typeAndEnter(WebElement element, String value) {
        typeAndThen(element, value, Keys.ENTER);
    }

    public void typeAndThen(WebElement element, String value, Keys keyToPressAfter) {
        waitActions.waitForElementIsDisplayed(element);
        waitActions.waitForElementIsClickable(element);
        element.sendKeys(value, keyToPressAfter);
        ExpectedConditions.textToBePresentInElement(element, value);
    }

    public void slowType(WebElement element, String value){
        waitActions.waitForElementIsDisplayed(element);
        waitActions.waitForElementIsClickable(element);
        value.codePoints().mapToObj(c -> (char) c).forEach(c -> element.sendKeys(c.toString()));
        ExpectedConditions.textToBePresentInElement(element, value);
    }


}
