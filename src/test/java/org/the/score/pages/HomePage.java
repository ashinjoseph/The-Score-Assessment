package org.the.score.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.the.score.common.pages.BasePage;

public class HomePage extends BasePage {
    private final AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private final String lbl_FavTeam_Xpath = "//android.widget.TextView[@text='%s']";
    private final String lbl_SearchPanel_Id = "com.fivemobile.thescore:id/search_bar_text_view";
    private final String lbl_SearchResult_Xpath = "//android.widget.TextView[@text='%s']";
    private final String txt_Search_Id = "com.fivemobile.thescore:id/search_src_text";


    public void verifyFavouriteScreenIsDisplayed(String favourite) {
        String favouriteTeam = favourite.substring(0, 3).toUpperCase();
        WebElement lbl_CanadaFavTeam = driver.findElement(MobileBy.xpath(String.format(lbl_FavTeam_Xpath, favouriteTeam)));
        isElementWithTextDisplayed(lbl_CanadaFavTeam, favouriteTeam);
        //todo log
    }

    public void searchPlayerTeamLeague(String playerTeamLeague) {
        driver.findElement(MobileBy.id(lbl_SearchPanel_Id)).click();
        driver.findElement(MobileBy.id(txt_Search_Id)).sendKeys(playerTeamLeague);
        WebElement lbl_FavTeam = driver.findElement(MobileBy.xpath(String.format(lbl_SearchResult_Xpath, playerTeamLeague)));
        if(isElementWithTextDisplayed(lbl_FavTeam, playerTeamLeague)){
            lbl_FavTeam.click();
        }
    }
    public void navigateBackToSearchScreen() {
        driver.navigate().back();
        driver.findElement(MobileBy.id(txt_Search_Id)).isDisplayed();
        //todo logger
    }
    public void navigateBackToHomeScreen(String favourite) {
        driver.navigate().back();
        verifyFavouriteScreenIsDisplayed(favourite);
    }
}