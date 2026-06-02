import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseUITest{

    @Test
    @DisplayName("Проверка работы перехода к разделу «Соусы»")
    @Description("Тест для проверки возможности перехода к разделу «Соусы» в конструкторе на главной странице")
    public void testChangeSectionToSaucesSuccess() {

        mainPage.openMainPage();

        mainPage.clickSaucesButton();

        assertTrue("Переход в раздел 'Соусы' не произошел", mainPage.isActiveSaucesButton());
    }

    @Test
    @DisplayName("Проверка работы перехода к разделу «Начинки»")
    @Description("Тест для проверки возможности перехода к разделу «Начинки» в конструкторе на главной странице")
    public void testChangeSectionToFillingSuccess() {

        mainPage.openMainPage();

        mainPage.clickFillingButton();

        assertTrue("Переход в раздел 'Начинки' не произошел", mainPage.isActiveFillingButton());
    }

    @Test
    @DisplayName("Проверка работы перехода к разделу «Булки»")
    @Description("Тест для проверки возможности перехода к разделу «Булки» в конструкторе на главной странице")
    public void testChangeSectionToBunsSuccess() {

        mainPage.openMainPage();

        mainPage.clickSaucesButton();

        mainPage.clickBunsButton();

        assertTrue("Переход в раздел 'Булки' не произошел", mainPage.isActiveBunsButton());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
