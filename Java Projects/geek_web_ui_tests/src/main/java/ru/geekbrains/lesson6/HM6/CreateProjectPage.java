package ru.geekbrains.lesson6.HM6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateProjectPage extends BaseView {
    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement projectRequestName;

    @FindBy(name = "//span[text()='Укажите организацию']")
    public WebElement chooseOrganization;

    @FindBy(name = "//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")
    public WebElement contactUser;

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    @FindBy(name = "crm_project[curator]")
    public WebElement selectCurator;

    @FindBy(name = "crm_project[rp]")
    public WebElement head;

    @FindBy(name = "crm_project[manager]")
    public WebElement manager;

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(),'Сохранить и закрыть')]";


}
