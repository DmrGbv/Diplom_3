import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import static data.EndpointsAndURIData.BASE_URI;

public class BaseUITest {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    RegistrationPage registrationPage;

    @Before
    public void startBrowser() {
        String browser = System.getProperty("browser", "chrome");

        if ("yandex".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "D:/AQA_Practicum_Projects/Diplom/yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Program Files/Yandex/YandexBrowser/Application/browser.exe");
            driver = new ChromeDriver(options);

        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        mainPage = new MainPage(driver);

        RestAssured.baseURI = BASE_URI;
    }
}
