package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.MainPage.MAIN_PAGE;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    String currentUrl;
    static final String LOGIN_PAGE = "https://stellarburgers.education-services.ru/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openLoginPage() {
        driver.get(LOGIN_PAGE);
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

    public boolean isChangeURLToMain() {
        wait.until(ExpectedConditions.urlToBe(MAIN_PAGE));
        currentUrl = driver.getCurrentUrl();
        return currentUrl.equals(MAIN_PAGE);
    }
}
