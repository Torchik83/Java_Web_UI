package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;


public class Test_1 {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static final WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    public static void main(String[] args)  {

        login();

        // Клик на кнопку "Проекты"
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/a/span")).click();

        // Клик на выпадашку "Мои проекты"
        driver.findElement(By.xpath("//ul/li[3]/ul/li[4]/a/span")).click();

        // Кликаем на кнопку "Создать проект"
        driver.findElement(By.xpath("//*[@id='container']/div[1]/div/div/div[2]/div/div/a")).click();

        // Ввод в поле "Наименование"
        driver.findElement(By.xpath("//div[1]/div[1]/div[2]/input[@type='text']")).sendKeys("QWERTY");

        // Кликаем на менюшку "Организация"
        driver.findElement(By.xpath(
                "//div[2]/div/div[@class='select2-container select2 input-widget']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[10]/div")).click();

        // Кликаем на менюшку "Подразделение" и выбираем "Research & Development"
        Select businessUnitDropDown = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitDropDown.selectByValue("1");

        // Кликаем на менюшку "Куратор проекта" и выбираем "Ким Юрий"
        Select curatorDropDown = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorDropDown.selectByValue("40");

        // Кликаем на менюшку "Администратор" и выбираем "Исаева Анастасия"
        Select administratorDropDown = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorDropDown.selectByValue("11");

        // Кликаем на менюшку "Менеджер" и выбираем "Амелина Светлана"
        Select managerDropDown = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerDropDown.selectByValue("6");

        // Кликаем на менюшку "Руководитель проекта" и выбираем "Андреев Сергей"
        Select bossDropDown = new Select(driver.findElement(By.name("crm_project[rp]")));
        bossDropDown.selectByValue("57");

        // Нажимаем "Сохранить и закрыть"
        driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();

    }

    private static void login()  {
        driver.get(LOGIN_PAGE_URL);
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);
        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);
        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
    }
}