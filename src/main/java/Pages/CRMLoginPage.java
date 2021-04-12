package Pages;


import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRMLoginPage extends BasePage {

    @FindBy(id = "prependedInput")
    private WebElement usrlog;

    @FindBy (id = "prependedInput2")
    private WebElement usrpass;

    @FindBy (id= "_submit")
    private WebElement logButton;

    public CRMLoginPage crmEnterLogin (String login){
        usrlog.sendKeys(login);
        return this;
    }

    public CRMLoginPage crmEnterPass (String password){
        usrpass.sendKeys(password);
        return this;
    }

    public CRMHomePage crmClickLoginButton (){
        logButton.click();
        return new CRMHomePage(driver);
    }

    public CRMLoginPage(WebDriver driver) {
        super(driver);
    }
}

