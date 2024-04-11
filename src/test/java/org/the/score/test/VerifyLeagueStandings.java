package org.the.score.test;




import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.the.score.common.test.BaseTest;
import org.the.score.common.utils.CommonUtility;
import org.the.score.pages.GetStarted;

public class VerifyLeagueStandings extends BaseTest {

    @AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
    private WebElement axtnBtn;


    @Test(alwaysRun = true)
   // @Description("Verify League Standings")
    public void openLeagueStandings(ITestContext context) {
        GetStarted getStarted = new GetStarted(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.fivemobile.thescore:id/action_button_text")));
        getStarted.getAppStarted();
        /*CommonUtility.waitUntilElementExists(driver,axtnBtn);

        driver.findElement(MobileBy.id("com.fivemobile.thescore:id/action_button_text")).click(); //get started
        driver.findElement(MobileBy.id("com.fivemobile.thescore:id/btn_primary")).click();//continue
        driver.findElement(MobileBy.id("com.fivemobile.thescore:id/btn_allow")).click();//allow
        driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();//allow

        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Canada']")).click();
      *//*  String selector = "new UiSelector().text('Canada')";
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(selector)); //canada
        element.click();*//*
        driver.findElement(MobileBy.id("com.fivemobile.thescore:id/btn_primary")).click();//Continue
        driver.findElement(MobileBy.id("com.fivemobile.thescore:id/btn_primary")).click();//done
        driver.findElement(MobileBy.id("com.fivemobile.thescore:id/btn_secondary")).click();//maybelater
        driver.findElement(MobileBy.id("com.fivemobile.thescore:id/dismiss_modal")).click();//close banner
    */System.out.println("Pass");
    }








  /*  @Test(groups = TestGroups.STORM)
    @Description("Create Portfolio With US Stocks")
    public void verifyPortfolioUSStocks2(ITestContext context) {

        CreatePortfolioPage cp;
        cp = new CreatePortfolioPage(webdriver.get());
        cp.selectUniverse("U.S. Stock");
        cp.searchInvestment("Alphabet Inc Class A(USD,GOOGL,ST)");

    }*/




}
