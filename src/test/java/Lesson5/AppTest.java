package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class AppTest {
    private static Logger logger;
    public static WebDriver driver;
    public static final String LINK = "https://www.diary.ru/";
    public static final String LOGIN = "TestDZ";
    public static final String PASSWORD = "qwerty123456";
    public static final String POST_TITLE = "Test message";
    public static final String POST_MESSAGE = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,\n\n";

    @BeforeAll
    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }


    @Test
    @DisplayName("Добавление записи в дневник")
    public void addMessageTest() {
        getDriver();
        Logger logger = Logger.getLogger(AppTest.class);
        driver.get(LINK);
        WebElement login = driver.findElement(By.xpath("//*[@id=\"navbar_user-collapse\"]/ul[1]/li[1]/a"));
        login.click();
        WebElement userlog = driver.findElement(By.id("loginform-username"));
        userlog.click();
        userlog.sendKeys(LOGIN);
        WebElement userpass = driver.findElement(By.id("loginform-password"));
        userpass.click();
        userpass.sendKeys(PASSWORD);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"login_btn\"]"));
        submit.click();
        logger.info("Вход выполнен успешно.");
        WebElement newpost = driver.findElement(By.className("i-menu-newpost"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(newpost));
        newpost.click();
        WebElement posttitle = driver.findElement(By.id("postTitle"));
        posttitle.click();
        posttitle.sendKeys(POST_TITLE);
        WebElement message = driver.findElement(By.id("message"));
        message.click();
        message.sendKeys(POST_MESSAGE);
        WebElement rewrite = driver.findElement(By.id("rewrite"));
        rewrite.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertTrue(isElementPresent(By.linkText("Комментировать")), "Запись не добавлена");
        logger.info("Запись успешно добавлена");
        WebElement drop2 = driver.findElement(By.id("drop"));
        drop2.click();
        WebElement logout = driver.findElement(By.linkText("Выход"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(logout));
        logout.click();
        logger.info("Выполнен выход");
        driver.close();
    }

    @Test
    @DisplayName("Добавление записи в цитатник")
    public void addQuoteTest() {
        getDriver();
        Logger logger = Logger.getLogger(AppTest.class);
        driver.get(LINK);
        WebElement login = driver.findElement(By.xpath("//*[@id=\"navbar_user-collapse\"]/ul[1]/li[1]/a"));
        login.click();
        WebElement userlog = driver.findElement(By.id("loginform-username"));
        userlog.click();
        userlog.sendKeys(LOGIN);
        WebElement userpass = driver.findElement(By.id("loginform-password"));
        userpass.click();
        userpass.sendKeys(PASSWORD);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"login_btn\"]"));
        submit.click();
        logger.info("Вход выполнен успешно");
        WebElement drop = driver.findElement(By.id("drop-common"));
        drop.click();
        WebElement random = driver.findElement(By.linkText("Случайный дневник"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(random));
        random.click();
        WebElement addQuote = driver.findElement(By.linkText("В цитатник"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(addQuote));
        addQuote.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertTrue(isElementPresent(By.linkText("Удалить из цитатника")), "Запись не процитирована");
        logger.info("Запись успешно процитирована");
        driver.get(LINK);
        WebElement drop2 = driver.findElement(By.id("drop"));
        drop2.click();
        WebElement logout = driver.findElement(By.linkText("Выход"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(logout));
        logout.click();
        logger.info("Выполнен выход");
        driver.close();
    }

    @Test
    @DisplayName("Вступление в сообщество")
    public void addGroupTest() {
        getDriver();
        Logger logger = Logger.getLogger(AppTest.class);
        driver.get(LINK);
        WebElement login = driver.findElement(By.xpath("//*[@id=\"navbar_user-collapse\"]/ul[1]/li[1]/a"));
        login.click();
        WebElement userlog = driver.findElement(By.id("loginform-username"));
        userlog.click();
        userlog.sendKeys(LOGIN);
        WebElement userpass = driver.findElement(By.id("loginform-password"));
        userpass.click();
        userpass.sendKeys(PASSWORD);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"login_btn\"]"));
        submit.click();
        logger.info("Вход выполнен успешно");
        WebElement drop = driver.findElement(By.id("drop-common"));
        drop.click();
        WebElement random = driver.findElement(By.linkText("Все сообщества"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(random));
        random.click();
        WebElement group = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/div[2]/div[2]/div[1]/a[2]"));
        group.click();
        WebElement addGroup = driver.findElement(By.linkText("Вступить в сообщество"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(addGroup));
        addGroup.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertTrue(isElementPresent(By.linkText("Написать в сообщество")), "Не удалось вступить в сообщество");
        logger.info("Вступление в сообщество успешно");
        driver.get(LINK);
        WebElement drop2 = driver.findElement(By.id("drop"));
        drop2.click();
        WebElement logout = driver.findElement(By.linkText("Выход"));
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(logout));
        logout.click();
        logger.info("Выполнен выход");
        driver.close();
    }
    public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterAll
    public static void driverQuit() {
        driver.quit();
    }
}
