package org.the.score.common.actions;

//import com.TheScore_Tests.common.utils.EnvironmentVariables;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class CommonActions {
    private WebDriver driver;
    private DropdownActions dropdownActions;
    private MouseActions mouseActions;
    private InputActions inputActions;
    private ScrollActions scrollActions;
    private WaitActions waitActions;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
        /*this.waitActions = new WaitActions(driver,
            EnvironmentVariables.getWaitTimeout(),
                EnvironmentVariables.getPollingTime());*/
        this.scrollActions = new ScrollActions(driver);
        this.inputActions = new InputActions(waitActions, driver);
        this.mouseActions = new MouseActions(waitActions, driver);
        this.dropdownActions = new DropdownActions(waitActions, mouseActions);
    }
}
