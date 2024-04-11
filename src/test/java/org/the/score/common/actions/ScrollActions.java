package org.the.score.common.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollActions {
    private WebDriver driver;

    public ScrollActions(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToBottomOfPage() {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollToTopOfPage() {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        jse.executeScript("window.scrollTo(0, 0)");
    }

    private void doScroll(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void scrollToLocator(By locator){
        doScroll(driver.findElement(locator));
    }

    public void scrollToElement(WebElement element){
        doScroll(element);
    }
}
