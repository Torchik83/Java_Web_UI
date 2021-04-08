package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CRMTest5 {

    public static WebDriver driver;
    public static final String LINK = "https://crm.geekbrains.space/user/login";
    public static final String LOGIN = "Applanatest";
    public static final String PASSWORD = "Student2020!";

    @BeforeAll
    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }


    @Test
    @DisplayName("Создание проекта")
    public void createProjectTest() {
        getDriver();
        Logger logger = Logger.getLogger(AppTest.class);
        driver.get(LINK);
        WebElement userlog = driver.findElement(By.id("prependedInput"));
        userlog.click();
        userlog.sendKeys(LOGIN);
        WebElement userpass = driver.findElement(By.id("prependedInput2"));
        userpass.click();
        userpass.sendKeys(PASSWORD);
        WebElement submit = driver.findElement(By.id("_submit"));
        submit.click();
        Assertions.assertTrue(isElementPresent(By.id("progressbar")), "Не удалось выполнить вход");
        logger.info("Вход выполнен успешно");
        By locator = By.xpath("/html/body/div[2]/div/header/div[2]/ul/li[3]/a/span");
        Actions actions = new Actions(driver);
        WebElement menuBtn = driver.findElement(locator);
        WebElement subMenu = driver.findElement(By.xpath("/html/body/div[2]/div/header/div[2]/ul/li[3]/ul/li[4]/a/span"));
        actions
                .moveToElement(menuBtn)
                .moveToElement(subMenu)
                .click()
                .build()
                .perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertTrue(isElementPresent(By.partialLinkText("Создать проект")), "Не удалось выполнить переход на вкладку Проекты");
        logger.info("Переход на вкладку Проекты выполнен успешно");
        WebElement createProj = driver.findElement(By.partialLinkText("Создать проект"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createProj);
        WebElement orgName = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[1]/div[1]/div[2]/input"));
        orgName.click();
        orgName.sendKeys("Чистые дворы");
        WebElement org = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[1]/div[2]/div[2]/div/div[1]/a/span[1]"));
        org.click();
        WebElement selectOrg = driver.findElement(By.xpath("/html/body/div[6]/ul[2]/li[3]/div"));
        selectOrg.click();
        WebElement bussinesUnit = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[5]/div[2]/div/select"));
        bussinesUnit.click();
        Select selectUnit = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[5]/div[2]/div/select")));
        selectUnit.selectByVisibleText("Research & Development");
        WebElement curator = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[6]/div[2]/div/select"));
        curator.click();
        Select selectCurator = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[6]/div[2]/div/select")));
        selectCurator.selectByVisibleText("Юзеров Юзер");
        WebElement rp = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[7]/div[2]/div/select"));
        rp.click();
        Select selectRp = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[7]/div[2]/div/select")));
        selectRp.selectByVisibleText("Ким Юрий");
        WebElement admin = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[8]/div[2]/div/select"));
        admin.click();
        Select selectAdmin = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[8]/div[2]/div/select")));
        selectAdmin.selectByVisibleText("Козлов Илья");
        WebElement manager = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[9]/div[2]/div/select"));
        manager.click();
        Select selectManager = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[9]/div[2]/div/select")));
        selectManager.selectByVisibleText("Студентов Студент");
        WebElement contact = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[4]/div[1]/div[2]/div/a"));
        contact.click();
        WebElement selectContact = driver.findElement(By.xpath("/html/body/div[7]/ul[2]/li[5]/div"));
        selectContact.click();
        WebElement save = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[1]/div/div/div[2]/div[1]/div[4]/button"));
        save.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assertions.assertTrue(isElementPresent(By.xpath("//*[text()='Проект сохранен']")), "Не удалось сохранить проект");
        logger.info("Проект успешно создан");
        WebElement user = driver.findElement(By.xpath("/html/body/div[2]/div/header/div[1]/div/ul/li[1]/a"));
        user.click();
        WebElement logOut = driver.findElement(By.xpath("/html/body/div[2]/div/header/div[1]/div/ul/li[1]/ul/li[6]/a"));
        logOut.click();
        Assertions.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div/div/form/div/h2")), "Не удалось выйти");
        logger.info("Выход выполнен успешно");
        driver.close();
    }

    @Test
    @DisplayName("Создание контактного лица")
    public void createContactTest() {
        getDriver();
        Logger logger = Logger.getLogger(AppTest.class);
        driver.get(LINK);
        WebElement userlog = driver.findElement(By.id("prependedInput"));
        userlog.click();
        userlog.sendKeys(LOGIN);
        WebElement userpass = driver.findElement(By.id("prependedInput2"));
        userpass.click();
        userpass.sendKeys(PASSWORD);
        WebElement submit = driver.findElement(By.id("_submit"));
        submit.click();
        Assertions.assertTrue(isElementPresent(By.id("progressbar")), "Не удалось выполнить вход");
        logger.info("Вход выполнен успешно");
        WebElement menuBtn = driver.findElement(By.xpath("/html/body/div[2]/div/header/div[2]/ul/li[1]/a/span"));
        WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/ul/li[5]/a/span"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(menuBtn)
                .moveToElement(subMenu)
                .click()
                .build()
                .perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertTrue(isElementPresent(By.partialLinkText("Создать контактное лицо")), "Не удалось выполнить переход на вкладку Контактные лица");
        logger.info("Переход на вкладку Контактные лица выполнен успешно");
        WebElement createContact = driver.findElement(By.partialLinkText("Создать контактное лицо"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createContact);
        WebElement lastName = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[1]/div[1]/div[2]/input"));
        lastName.click();
        lastName.sendKeys("Иванов");
        WebElement firstName = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[1]/div[2]/div[2]/input"));
        firstName.click();
        firstName.sendKeys("Фёдор");
        WebElement org = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[1]/div[2]/div/div[1]/a/span[1]"));
        org.click();
        WebElement selectOrg = driver.findElement(By.xpath("/html/body/div[7]/ul[2]/li[6]/div"));
        selectOrg.click();
        WebElement position = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[3]/div/div[1]/div[2]/fieldset/div[2]/div[2]/div[2]/input"));
        position.click();
        position.sendKeys("Дворник");
        WebElement save = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[1]/div/div/div[2]/div[1]/div[4]/button"));
        save.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assertions.assertTrue(isElementPresent(By.xpath("//*[text()='Контактное лицо сохранено']")), "Не удалось сохранить контактное лицо");
        logger.info("Контактное лицо  успешно создано");
        WebElement user = driver.findElement(By.xpath("/html/body/div[2]/div/header/div[1]/div/ul/li[1]/a"));
        user.click();
        WebElement logOut = driver.findElement(By.xpath("/html/body/div[2]/div/header/div[1]/div/ul/li[1]/ul/li[6]/a"));
        logOut.click();
        Assertions.assertTrue(isElementPresent(By.xpath("/html/body/div[1]/div/div/form/div/h2")), "Не удалось выйти");
        logger.info("Выход выполнен успешно");
        driver.close();
    }

    @AfterAll
    public static void driverQuit() {
        driver.quit();
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
