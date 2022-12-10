import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageDescription.HomePage;
import pageDescription.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class PageSwitchingWithoutAuthorization {
    protected final String loginUrl = "https://stellarburgers.nomoreparties.site/login";
    protected final String homePageUrl = "https://stellarburgers.nomoreparties.site/";

    //Переход из страницы авторизации в конструктор
    @Test
    @DisplayName("Switch from login page to the home page and check URL")
    public void SwitchToHomePageWithoutAuthorization() {
        open(loginUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.clickLogo();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
    }

    //Переход без авторизации по клику на кнопку «Личный кабинет» на страницу авторизации
    @Test
    @DisplayName("Switch from home page to personal account without authorization and check URL")
    public void SwitchToPersonalAccountWithoutAuthorization() {
        open(homePageUrl);
        HomePage homePage = new HomePage();
        homePage.clickPersonalAccount();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",loginUrl, currentUrl);
    }
}
