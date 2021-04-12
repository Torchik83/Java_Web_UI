package Pages;


import Base.BasePage;
import Views.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class CRMHomePage extends BasePage {

    private NavigationBar navigationBar;

    @FindBy(className = "dropdown-toggle")
    private WebElement userMenu;

    @FindBy(className = "no-hash")
    private WebElement userLogout;

    @Step("Клик меню пользователя")
    public CRMHomePage clickUserMenu() {
        userMenu.click();
        return this;
    }

    @Step("Клик Выход")
    public CRMLoginPage clickUserLogout() {
        userLogout.click();
        return new CRMLoginPage(driver);
    }

    public CRMHomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    public NavigationBar getNavigation() {
        return navigationBar;
    }
}