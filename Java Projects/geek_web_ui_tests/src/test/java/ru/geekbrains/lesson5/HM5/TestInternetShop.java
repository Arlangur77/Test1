package ru.geekbrains.lesson5.HM5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestInternetShop {
    public static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://www.med-konfitur.ru/";

        @BeforeAll
        static void registerDriver() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setupBrowser() {
            driver = new ChromeDriver();
            WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
            driver.manage().window().maximize();
            loginToInternetShop();
        }
        @Test
        void chekPersonalAccount() throws InterruptedException {

            driver.findElement(By.xpath("//a[@href='/personal/orders/']")).click();

            driver.findElement(By.xpath("//a[@href='/personal/delivery/']")).click();

            driver.findElement(By.xpath("//a[@href='/personal/data/']")).click();

            driver.findElement(By.xpath("//a[@href='/personal/delay/']")).click();

            Thread.sleep(3000);
        }
        @AfterEach
        void tearDown() {
        driver.quit();
        }

    public static void loginToInternetShop() {
        driver.get("https://www.med-konfitur.ru/personal/auth/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("e5urs10kg24u@mail.ru");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("q4JGy1");
        driver.findElement(By.name("Login")).click();
    }
}
