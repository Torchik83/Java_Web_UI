package Views;


import Base.BasePage;
import Base.SubMenu;
import Enums.NavigationBarTabs;
import Enums.ProjectSubMenuButtons;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationBar extends BasePage {

    public NavigationBar(WebDriver driver){
        super (driver);
    }

    public SubMenu moveCursorTooNavigationTab(NavigationBarTabs tab){
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(tab.getBy()))
                .build()
                .perform();
        switch (tab){
            case PROJECTS:
                return new ProjectSubMenu(driver);
            case COUNTER:
                return new ProjectSubMenu(driver);
            default:
                throw  new IllegalArgumentException("Anther tabs currently not implemented");
        }
    }

    public NavigationBar checkTabVisibility (NavigationBarTabs tab){
        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
        return this;
    }

}
