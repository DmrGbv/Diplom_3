package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.LoginModelAPI;
import model.UserModelAPI;

import static data.EndpointsAndURIData.CREATE_USER_POST;
import static data.EndpointsAndURIData.LOGIN_USER_POST;
import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class UserStepsAPI {

    @Step("Создание пользователя")
    public static Response createUserAPI(UserModelAPI user){
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(CREATE_USER_POST)
                .then()
                .extract().response();
    }

    @Step("Авторизация пользователя")
    public static Response loginUserAPI(LoginModelAPI loginModel){
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(loginModel)
                .when()
                .post(LOGIN_USER_POST)
                .then()
                .extract().response();
    }

    @Step("Получение токена пользователя при авторизации")
    public static String getUserAccessTokenAPI(String email, String password) {
        LoginModelAPI loginModel = new LoginModelAPI(email, password);
        Response response = loginUserAPI(loginModel);

        if (response.statusCode() == HTTP_OK) {
            return response.path("accessToken");
        }
        return null;
    }

    @Step("Удаление пользователя")
    public static Response deleteUserAPI(String token) {
        return given()
                .log().all()
                .when()
                .header("Authorization", token)
                .delete("api/auth/user")
                .then()
                .extract().response();
    }
}
