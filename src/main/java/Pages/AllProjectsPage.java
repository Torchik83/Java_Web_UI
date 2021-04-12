package Pages;


import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Step;

public class AllProjectsPage extends BasePage {

    @FindBy(css = "div[class='pull-left btn-group icons-holder']")
    private WebElement createProjectButton;

    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажата кнопка Создать проект")
    public NewProjectPage clickNewProject() {
        createProjectButton.click();
        return new NewProjectPage(driver);
    }

    @Step("Проект сохранен")
    public AllProjectsPage checkNewProject() {
        String message = wait10seconds.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='message']"))).getText();
        assertTrue(message.contains("Проект сохранен"));
        return this;
    }
}