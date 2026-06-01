import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseUITest {

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    @Description("Тест для проверки возможности авторизации через кнопку «Войти в аккаунт» на главной странице")
    public void testLoginMainPageLoginButtonSuccess() {

        mainPage.openMainPage();

        mainPage.clickMainLoginButton();

        loginPage.setEmail("GabovDmit@yandex.ru");
        loginPage.setPassword("12345ee");

        loginPage.clickLoginButton();

        assertTrue("Редирект на главную страницу не произошёл", loginPage.isChangeURLToMain());

        assertTrue("Кнопка 'Оформить заказ' не отображается на главной странице", mainPage.isVisibleOrderButton());
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    @Description("Тест для проверки возможности авторизации через кнопку «Личный кабинет» на главной странице")
    public void testLoginMainPageAccountButtonSuccess() {

        mainPage.openMainPage();

        mainPage.clickAccountButton();

        loginPage.setEmail("GabovDmit@yandex.ru");
        loginPage.setPassword("12345ee");

        loginPage.clickLoginButton();

        assertTrue("Редирект на главную страницу не произошёл", loginPage.isChangeURLToMain());

        assertTrue("Кнопка 'Оформить заказ' не отображается на главной странице", mainPage.isVisibleOrderButton());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    @Description("Тест для проверки возможности авторизации через кнопку «Войти» на странице регистрации")
    public void testLoginRegistrationLoginButtonSuccess() {

        registrationPage.openRegistrationPage();

        registrationPage.clickRegistrationLoginButton();

        loginPage.setEmail("GabovDmit@yandex.ru");
        loginPage.setPassword("12345ee");

        loginPage.clickLoginButton();

        assertTrue("Редирект на главную страницу не произошёл", loginPage.isChangeURLToMain());

        assertTrue("Кнопка 'Оформить заказ' не отображается на главной странице", mainPage.isVisibleOrderButton());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    @Description("Тест для проверки возможности авторизации через кнопку «Войти» на странице восстановления пароля")
    public void testLoginResetPasswordLoginButtonSuccess() {

        loginPage.openLoginPage();

        loginPage.clickForgotPasswordButton();

        loginPage.clickResetPasswordLoginButton();

        loginPage.setEmail("GabovDmit@yandex.ru");
        loginPage.setPassword("12345ee");

        loginPage.clickLoginButton();

        assertTrue("Редирект на главную страницу не произошёл", loginPage.isChangeURLToMain());

        assertTrue("Кнопка 'Оформить заказ' не отображается на главной странице", mainPage.isVisibleOrderButton());
    }
}
