package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;
    String currentUrl;
    final String MAIN_PAGE = "https://stellarburgers.education-services.ru/";
    final String LOGIN_PAGE = "https://stellarburgers.education-services.ru/login";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openMainPage() {
        driver.get(MAIN_PAGE);
    }

    public void openLoginPage() {
        driver.get(LOGIN_PAGE);
    }

//  Локатор кнопки Войти в аккаунт на главной странице
    private By mainLogiInButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");

    public void clickMainLoginButton() {
        driver.findElement(mainLogiInButton).click();
    }

//   Локатор поля Email
    private By fieldEmail = By.xpath("//label[contains(text(),'Email')]/..//input");

//   Локатор поля Пароль
    private By fieldPassword = By.xpath("//input[@name='Пароль']");

    public void setEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

//  Локатор кнопки Войти на странице входа
    private By loginButton = By.xpath("//button[text()='Войти']");

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

//  Локатор кнопки Личный кабинет на главной странице
    private By accountButton = By.xpath("//p[contains(text(),'Личный Кабинет')]");

    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

//  Локатор кнопки Войти на странице регистрации
    private By registrationLoginButton = By.xpath("//a[contains(text(),'Войти')]");

    public void clickRegistrationLoginButton() {
        driver.findElement(registrationLoginButton).click();
    }

//  Локатор кнопки Восстановить пароль на странице входа
    private By forgotPasswordButton = By.xpath("//a[contains(text(),'Восстановить пароль')]");

    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

//  Локатор кнопки Войти на странице восстановления пароль
    private By resetPasswordLoginButton = By.xpath("//a[contains(text(),'Войти')]");

    public void clickResetPasswordLoginButton() {
        driver.findElement(resetPasswordLoginButton).click();
    }

//  Локатор кнопки Оформить заказ на главной странице
    private By orderButton = By.xpath("//button[contains(text(),'Оформить заказ')]");

    public boolean isChangeURLMain() {
        wait.until(ExpectedConditions.urlToBe(MAIN_PAGE));
        currentUrl = driver.getCurrentUrl();
        return currentUrl.equals(MAIN_PAGE);
    }

    public boolean isVisibleOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        return driver.findElement(orderButton).isDisplayed();
    }

}
