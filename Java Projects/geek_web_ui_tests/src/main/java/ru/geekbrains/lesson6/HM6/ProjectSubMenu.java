package ru.geekbrains.lesson6.HM6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectSubMenu extends BaseView {
    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement projectRequestsMenuItem;

    public void goToProjectRequestsPage() {
    projectRequestsMenuItem.click();
        webDriverWait.until(
        ExpectedConditions.presenceOfElementLocated(By.xpath(ProjectRequestPage.createProjectXpathLocator)));
    }
}