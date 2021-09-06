package ru.geekbrains.lesson6.HM6;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class ObjectTestCrmProject extends BaseTest {


    @Test
    void loginInCrmWithPageObjTest() {
           WebDriver driver;

        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Проекты");

        new ProjectSubMenu(driver).goToProjectRequestsPage();

        new CreateProjectPage(driver)






    }
}
