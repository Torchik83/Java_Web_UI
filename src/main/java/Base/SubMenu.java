package Base;

import org.openqa.selenium.WebDriver;

public abstract class SubMenu extends BasePage{
    abstract public BasePage clickSubMenuButton(SubMenuButtons buttons);
    public SubMenu(WebDriver driver) {
        super(driver);
    }
}
