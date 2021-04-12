package Base;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait10seconds;
    protected WebDriverWait wait30seconds;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait10seconds = new WebDriverWait(driver, 10);
        this.wait10seconds = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
    public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
