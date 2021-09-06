package ru.geekbrains.lesson5.HM5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateCrmProjectExample {
    public static WebDriver driver;
    WebDriverWait webDriverWait;

        @BeforeAll
        static void registerDriver() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setupBrowser() {
            driver = new ChromeDriver();
            WebDriverWait webDriverWait = new WebDriverWait(driver, 4);
            loginToCrm();
        }

       @Test
       void checkButtonCreateNewProject() throws InterruptedException {
           driver.get("https://crm.geekbrains.space/project/");
           Actions actions = new Actions(driver);
           WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
           actions.moveToElement(projectMenuElement).perform();

           webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
           driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
           Thread.sleep(5000);

           webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
           driver.findElement(By.name("crm_project[name]")).sendKeys("crm_project[name]");

           driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
           driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("test");

           webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
           List<WebElement> organizationVars = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
           organizationVars.get(0).click();

           webDriverWait.until(ExpectedConditions.elementToBeClickable(
                   By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")));
           webDriverWait.until(ExpectedConditions.textToBePresentInElement(
                   driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_company')]/a")), "123test"));
           Thread.sleep(1000);
           webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-container select2']")));
           driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();
           webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select2-drop']//input")));
           driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1111");
           driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

           Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
           businessUnitSelect.selectByVisibleText("Research & Development");

           Select Curator = new Select(driver.findElement(By.name("crm_project[curator]")));
           Curator.selectByVisibleText("Applanatest2 Applanatest2 Applanatest2");

           Select Head = new Select(driver.findElement(By.name("crm_project[rp]")));
           Head.selectByVisibleText("Гатов Фёдор");

           Select Manager = new Select(driver.findElement(By.name("crm_project[manager]")));
           Manager.selectByVisibleText("Воденеева Алла");

           Thread.sleep(5000);


           driver.get("https://crm.geekbrains.space/project/create/");
           driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
               Thread.sleep(5000);

       }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}
