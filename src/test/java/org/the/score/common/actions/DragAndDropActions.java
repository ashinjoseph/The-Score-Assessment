package org.the.score.common.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {
    private WebDriver driver;
    private Actions builder;

    public DragAndDropActions(WebDriver driver) {
        this.driver = driver;
        this.builder = new Actions(driver);
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

    private void performDragAndDrop(WebElement from, WebElement to){
        Action dragAndDrop = builder.clickAndHold(from)
            .moveToElement(to)
            .release(to)
            .build();
        dragAndDrop.perform();
    }
}
