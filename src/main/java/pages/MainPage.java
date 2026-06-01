package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;
    static final String MAIN_PAGE = "https://stellarburgers.education-services.ru/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openMainPage() {
        driver.get(MAIN_PAGE);
    }

//  Локатор кнопки Войти в аккаунт на главной странице
    private By mainLogiInButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");

    public void clickMainLoginButton() {
        driver.findElement(mainLogiInButton).click();
    }

//  Локатор кнопки Личный кабинет на главной странице
    private By accountButton = By.xpath("//p[contains(text(),'Личный Кабинет')]");

    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

//  Локатор кнопки Оформить заказ на главной странице
    private By orderButton = By.xpath("//button[contains(text(),'Оформить заказ')]");

    public boolean isVisibleOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        return driver.findElement(orderButton).isDisplayed();
    }

//  Локатор кнопки Булки конструктора на главной странице
    private By bunsButton = By.xpath("//span[contains(text(),'Булки')]/..");

    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

//  Локатор кнопки Соусы конструктора на главной странице
    private By saucesButton = By.xpath("//span[contains(text(),'Соусы')]/..");

    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }

//  Локатор кнопки Начинки конструктора на главной странице
    private By fillingButton = By.xpath("//span[contains(text(),'Начинки')]/..");

    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    public boolean isActiveBunsButton() {
        String classValue = driver.findElement(bunsButton).getAttribute("class");
        return classValue.contains("pt-4 pr-10 pb-4 pl-10");
    }

    public boolean isActiveSaucesButton() {
        String classValue = driver.findElement(saucesButton).getAttribute("class");
        return classValue.contains("pt-4 pr-10 pb-4 pl-10");
    }

    public boolean isActiveFillingButton() {
        String classValue = driver.findElement(fillingButton).getAttribute("class");
        return classValue.contains("pt-4 pr-10 pb-4 pl-10");
    }
}
