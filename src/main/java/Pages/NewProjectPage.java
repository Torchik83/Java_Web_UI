package Pages;


import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class NewProjectPage  extends BasePage {

    @FindBy(name = "crm_project[name]")
    private WebElement projectName;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButton;

    @FindBy(className= "select2-arrow")
    private WebElement companyContainer;

    @FindBy(xpath = "/html/body/div[6]/ul[2]/li[4]/div")
    private WebElement hardCodeCompanySelect;

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnit;

    @FindBy(name = "crm_project[curator]")
    private WebElement curator;

    @FindBy(name = "crm_project[rp]")
    private WebElement projectRP;

    @FindBy(name = "crm_project[manager]")
    private WebElement manager;

    @FindBy(name = "crm_project[contactMain]")
    private WebElement contactMain;

    @Step("Клик поля Организация")
    public NewProjectPage clickCompanyList(){
        companyContainer.click();
        return this;
    }
    @Step("Выбрана организация")
    public NewProjectPage clickSeceltedCompany(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(hardCodeCompanySelect));
        hardCodeCompanySelect.click();
        return this;
    }

    @Step("Выбрано подразделение")
    public  NewProjectPage selectBusinessUnit(int value){
        Select businessUnitDrop = new Select(businessUnit);
        businessUnitDrop.selectByValue(String.valueOf(value));
        return this;
    }

    @Step("Выбран куратор")
    public  NewProjectPage selectCurator(int value){
        Select curatorDrop = new Select(curator);
        curatorDrop.selectByValue(String.valueOf(value));
        return this;
    }
    @Step("Выбран руководитель")
    public  NewProjectPage selectRP(int value){
        Select rpDrop = new Select(projectRP);
        rpDrop.selectByValue(String.valueOf(value));
        return this;
    }
    @Step("Выбран менеджер")
    public  NewProjectPage selectManager(int value){
        Select managerDrop = new Select(manager);
        managerDrop.selectByValue(String.valueOf(value));
        return this;
    }

    @Step("Выбрано контактное лицо")
    public  NewProjectPage selectContsctMain(int value){
        Select contactDrop = new Select(contactMain);
        contactDrop.selectByValue(String.valueOf(value));
        return this;
    }



    @Step("Введено имя проекта")
    public  NewProjectPage enterProjectName(String name){
        projectName.sendKeys(name);
        return this;
    }
    @Step("Клик кнопки Сохранить проект")
    public AllProjectsPage clickSubmit(){
        submitButton.click();
        return new AllProjectsPage(driver);
    }


    public NewProjectPage(WebDriver driver) {
        super(driver);
    }
}