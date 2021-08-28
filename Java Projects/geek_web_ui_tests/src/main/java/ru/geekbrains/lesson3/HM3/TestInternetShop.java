package ru.geekbrains.lesson3.HM3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestInternetShop {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginToInternetShop();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);

        driver.findElement(By.xpath("//a[@href='/personal/orders/']")).click();

        driver.findElement(By.xpath("//a[@href='/personal/delivery/']")).click();

        driver.findElement(By.xpath("//a[@href='/personal/data/']")).click();

        driver.findElement(By.xpath("//a[@href='/personal/delay/']")).click();

        Thread.sleep(4000);
        driver.quit();
    }

    public static void loginToInternetShop() {
        driver.get("https://www.med-konfitur.ru/personal/auth/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("e5urs10kg24u@mail.ru");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("q4JGy1");
        driver.findElement(By.name("Login")).click();
    }
}
