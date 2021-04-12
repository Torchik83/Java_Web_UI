package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class NewContactPage extends BasePage {

    @FindBy(name = "crm_contact[lastName]")
    private WebElement contactLastName;

    @FindBy(name = "crm_contact[firstName]")
    private WebElement contactFirstName;

    @FindBy(className= "select2-arrow")
    private WebElement companyContainer;

    @FindBy(xpath = "/html/body/div[7]/ul[2]/li[7]/div")
    private WebElement hardCodeCompanySelect;

    @FindBy(name= "crm_contact[jobTitle]")
    private WebElement jobTitle;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButton;

    @Step("Введена фамилия")
    public  NewContactPage enterLastName(String lName){
        contactLastName.sendKeys(lName);
        return this;
    }
    @Step("Введено имя")
    public  NewContactPage enterFirstName(String fName){
        contactFirstName.sendKeys(fName);
        return this;
    }

    @Step("Клик поля Организация")
    public NewContactPage clickCompanyList(){
        companyContainer.click();
        return this;
    }
    @Step("Выбрана организация")
    public NewContactPage clickSeceltedCompany(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(hardCodeCompanySelect));
        hardCodeCompanySelect.click();
        return this;
    }

    @Step("Введена должность")
    public  NewContactPage enterJobTitle(String title){
        jobTitle.sendKeys(title);
        return this;
    }
    @Step("Клик кнопки Сохранить и закрыть")
    public AllContactsPage clickSubmit(){
        submitButton.click();
        return new AllContactsPage(driver);
    }


    public NewContactPage(WebDriver driver) {
        super(driver);
    }
}