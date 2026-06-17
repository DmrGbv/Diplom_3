import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static steps.UserStepsAPI.*;

public class RegistrationTest extends BaseUITest {
    String name;
    String email;
    String password;
    String smallPassword;

    @Before
    public void generateData() {
        Faker faker = new Faker();
        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        password = faker.regexify("[0-9]{6}");
        smallPassword = faker.regexify("[0-9]{4}");
    }

    @Test
    @DisplayName("Проверка успешной регистрации пользователя")
    @Description("Тест для проверки успешной регистрации нового пользователя при заполнении обязательных полей валидными данными")
    public void testRegistrationSuccess() {

        registrationPage.openRegistrationPage();

        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);

        registrationPage.clickRegistrationButton();

        assertTrue("Редирект на страницу входа не произошёл", registrationPage.isChangeURLLogin());

        assertTrue("Кнопка 'Войти' не отображается на странице входа", registrationPage.isVisibleLoginButton());
    }

    @Test
    @DisplayName("Проверка возникновения ошибки для некорректного пароля")
    @Description("Тест для проверки возникновения ошибки при попытке регистрации с использованием пароля длиной менее 6 символов")
    public void testSmallPasswordFail() {

        registrationPage.openRegistrationPage();

        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(smallPassword);

        registrationPage.clickRegistrationButton();

        assertTrue("Ошибка о некорректном пароле не отображается", registrationPage.isVisibleIncorrectPasswordError());
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

