package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;
    String currentUrl;
    String actualEmail;
    static final String REGISTRATION_PAGE = "https://stellarburgers.education-services.ru/register";

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.currentUrl = currentUrl;
        this.actualEmail = actualEmail;
    }

    public void openRegistrationPage() {
        driver.get(REGISTRATION_PAGE);
    }

//   Локатор поля Имя
    private By fieldName = By.xpath("//label[contains(text(),'Имя')]/..//input");

//   Локатор поля Email
    private By fieldEmail = By.xpath("//label[contains(text(),'Email')]/..//input");

//   Локатор поля Пароль
    private By fieldPassword = By.xpath("//input[@name='Пароль']");


    public void setName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

//  Локатор кнопки Зарегистрироваться на странице входа
    private By registrationButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

//  Локатор кнопки Войти на странице входа
    private By loginButton = By.xpath("//button[contains(text(),'Войти')]");

    public boolean isChangeURLLogin() {
        wait.until(ExpectedConditions.urlContains("/login"));
        currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("/login");
    }

    public boolean isVisibleLoginButton() {
        return driver.findElement(loginButton).isDisplayed();
    }

//  Локатор текста ошибки пароля на странице регистрации
    private By incorrectPasswordError = By.xpath("//p[@class='input__error text_type_main-default']");

    public boolean isVisibleIncorrectPasswordError() {
        return driver.findElement(incorrectPasswordError).isDisplayed();
    }

//  Локатор кнопки Войти на странице регистрации
    private By registrationLoginButton = By.xpath("//a[contains(text(),'Войти')]");

    public void clickRegistrationLoginButton() {
        driver.findElement(registrationLoginButton).click();
    }
}
