package org.the.score.common.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.Optional;

public class DropdownActions {
    private WaitActions waitActions;
    private MouseActions mouseActions;

    public DropdownActions(WaitActions waitActions, MouseActions mouseActions) {
        this.waitActions = waitActions;
        this.mouseActions = mouseActions;
    }


}
