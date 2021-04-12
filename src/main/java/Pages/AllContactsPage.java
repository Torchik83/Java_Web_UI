package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllContactsPage  extends BasePage {

    @FindBy(css = "div[class='pull-left btn-group icons-holder']")
    private WebElement createContactButton;

    public AllContactsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажата кнопка Создать контактное лицо")
    public NewContactPage clickNewContact(){
        createContactButton.click();
        return new NewContactPage(driver);
    }

    @Step("Контактное лицо сохранено")
    public AllContactsPage checkNewContact(){
        String message = wait10seconds.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='message']"))).getText();
        assertTrue(message.contains("Контактное лицо сохранено"));
        return this;
    }
}