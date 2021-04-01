package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test_3 {
    private static final String LOGIN_PAGE_URL = "https://www.diary.ru";
    private static final String STUDENT_LOGIN = "TestDZ";
    private static final String STUDENT_PASSWORD = "qwerty123456";
    private static final WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public static void main(String[] args)  {

        login();

        // Клик на кнопку "Новая запись"
        driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/ul[2]/li[2]/a/span[2]")).click();

        // Ввод в поле "Заголовок"
        driver.findElement(By.xpath("//*[@id=\"postTitle\"]")).sendKeys("Тестовая запись");

        // Ввод в поле "Сообщение"
        driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("Тестовое сообщение");

        // Клик на кнопку "Организация"
        driver.findElement(By.xpath("//*[@id=\"rewrite\"]")).click();

       }

    private static void login()  {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.xpath("//*[@id=\"navbar_user-collapse\"]/ul[1]/li[1]/a")).click();
        WebElement loginTextInput = driver.findElement(By.xpath("///*[@id=\"loginform-username\"]"));
        loginTextInput.sendKeys(STUDENT_LOGIN);
        WebElement passwordTextInput = driver.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/button"));
        loginButton.click();
    }
}

