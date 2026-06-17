import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.UserModelAPI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static steps.UserStepsAPI.*;

public class LoginTest extends BaseUITest {
    String name;
    String email;
    String password;
    private UserModelAPI user;

    @Before
    public void generateData() {
        Faker faker = new Faker();
        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        password = faker.regexify("[0-9]{6}");
        user = new UserModelAPI(name, email, password);
        createUserAPI(user);
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    @Description("Тест для проверки возможности авторизации через кнопку «Войти в аккаунт» на главной странице")
    public void testLoginMainPageLoginButtonSuccess() {

        mainPage.openMainPage();

        mainPage.clickMainLoginButton();

        loginPage.setEmail(email);
        loginPage.setPassword(password);

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

        loginPage.setEmail(email);
        loginPage.setPassword(password);

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

        loginPage.setEmail(email);
        loginPage.setPassword(password);

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

        loginPage.setEmail(email);
        loginPage.setPassword(password);

        loginPage.clickLoginButton();

        assertTrue("Редирект на главную страницу не произошёл", loginPage.isChangeURLToMain());

        assertTrue("Кнопка 'Оформить заказ' не отображается на главной странице", mainPage.isVisibleOrderButton());
    }

    @After
    public void tearDown() {
        String accessToken = getUserAccessTokenAPI(email, password);
        if (accessToken != null) {
            deleteUserAPI(accessToken);
        }
        driver.quit();
    }
}
