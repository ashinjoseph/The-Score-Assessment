package org.the.score.common.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    private WaitActions waitActions;
    private Actions builder;
    private WebDriver driver;

    public MouseActions(WaitActions waitActions, WebDriver driver) {
        this.driver = driver;
        this.waitActions = waitActions;
        this.builder = new Actions(driver);
    }

    public void clickOnElement(WebElement element) {
        waitActions.waitForElementIsDisplayed(element);
        waitActions.waitForElementIsClickable(element);
        waitActions.getWait().until(webDriver -> {
            element.click();
            return true;
        });
    }



    public void performMouseHover(WebElement to, Integer xOffset, Integer yOffset){
        Action hover= builder.moveToElement(to, xOffset, yOffset).build();
        hover.perform();
    }

    public void performMouseHover(WebElement to){
        Action hover = builder.moveToElement(to).build();
        hover.perform();
    }

    public void mouseMouseTo(Integer xPos, Integer yPos){
        Action move = builder.moveByOffset(xPos, yPos).build();
        move.perform();
    }

    public void dragAndDrop(WebElement from, WebElement to){
        performDragAndDrop(from, to);
    }

    public void dragAndDrop(WebElement from, By to){
        performDragAndDrop(from, driver.findElement(to));
    }

    public void dragAndDrop(By from, WebElement to){
        performDragAndDrop(driver.findElement(from), to);
    }

    public void dragAndDrop(By from, By to){
        performDragAndDrop(driver.findElement(from), driver.findElement(to));
    }

    public void dragAndDrop(WebElement from, int to_x, int to_y){
        performDragAndDrop(from, to_x, to_y);
    }

    public void dragAndDrop(By from, int to_x, int to_y){
        performDragAndDrop(driver.findElement(from), to_x, to_y);
    }

    private void performDragAndDrop(WebElement from, WebElement to){
        Action dragAndDrop = builder.moveToElement(from)
            .clickAndHold(from)
            .moveToElement(to)
            .release(to)
            .build();
        dragAndDrop.perform();
    }

    private void performDragAndDrop(WebElement from, int to_x, int to_y){
        Action dragAndDrop = builder.moveToElement(from)
                .clickAndHold(from)
                .moveByOffset(to_x, to_y)
                .release()
                .build();
        dragAndDrop.perform();
    }
}
