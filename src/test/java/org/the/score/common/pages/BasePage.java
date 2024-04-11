package org.the.score.common.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10); // You can adjust the wait time as needed
    }

    // Click method with page transition
    public void clickAndTransition(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        waitForPageLoad(); // Wait for the new page to load
    }

    // Method to wait for page load
    private void waitForPageLoad() {
        try {
            // Wait for any element on the new page to become visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
        } catch (NoSuchElementException e) {
            // Handle case where no element is found on the new page
            System.out.println("No element found on the new page.");
        }
    }
}
