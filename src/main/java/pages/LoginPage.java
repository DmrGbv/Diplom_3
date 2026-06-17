package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.PagesData.LOGIN_PAGE;
import static data.PagesData.MAIN_PAGE;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    String currentUrl;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Открытие страницы авторизации")
    public void openLoginPage() {
        driver.get(LOGIN_PAGE);
    }

//   Локатор поля Email
    private By fieldEmail = By.xpath("//label[contains(text(),'Email')]/..//input");

//   Локатор поля Пароль
    private By fieldPassword = By.xpath("//input[@name='Пароль']");

    @Step("Заполнение поля Email")
    public void setEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Заполнение поля Пароль")
    public void setPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

//  Локатор кнопки Войти на странице входа
    private By loginButton = By.xpath("//button[text()='Войти']");

    @Step("Клик по кнопке Войти на странице авторизации")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

//  Локатор кнопки Восстановить пароль на странице входа
    private By forgotPasswordButton = By.xpath("//a[contains(text(),'Восстановить пароль')]");

    @Step("Клик по кнопке Восстановить пароль")
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

//  Локатор кнопки Войти на странице восстановления пароль
    private By resetPasswordLoginButton = By.xpath("//a[contains(text(),'Войти')]");

    @Step("Клик по кнопке Войти на странице восстановления пароля")
    public void clickResetPasswordLoginButton() {
        driver.findElement(resetPasswordLoginButton).click();
    }

    @Step("Проверка перехода на главную страницу")
    public boolean isChangeURLToMain() {
        wait.until(ExpectedConditions.urlToBe(MAIN_PAGE));
        currentUrl = driver.getCurrentUrl();
        return currentUrl.equals(MAIN_PAGE);
    }
}
