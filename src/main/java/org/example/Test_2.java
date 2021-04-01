package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Test_2 {
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

        // Клик на кнопку "Контрагенты"
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span")).click();

        // Клик на выпадашку "Контактные лица"
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/ul/li[5]/a/span")).click();

        // Кликаем на кнопку "Создать контактное лицо"
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div/a")).click();

        // Ввод в поле "Фамилия"
        driver.findElement(By.xpath("//div[1]/div[1]/div[2]/input[@name='crm_contact[lastName]']")).sendKeys("Иванов");

        // Ввод в поле "Имя"
        driver.findElement(By.xpath("//div[1]/div[2]/div[2]/input[@name='crm_contact[firstName]']")).sendKeys("Фёдор");

        // Кликаем на менюшку "Организация"
        driver.findElement(By.xpath(
                "//div[2]/div/div[@class='select2-container select2 input-widget']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[10]/div")).click();

        // Ввод в поле "Должность"
        driver.findElement(By.xpath("//div[2]/div[2]/input[@name='crm_contact[jobTitle]']")).sendKeys("Менеджер");

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
