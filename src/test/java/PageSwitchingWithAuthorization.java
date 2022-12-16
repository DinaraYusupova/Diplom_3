import com.codeborne.selenide.WebDriverRunner;
import dataGenerator.DefaultUserData;
import deleteData.DeleteUser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageDescription.HomePage;
import pageDescription.LoginPage;
import pageDescription.PersonalAccountPage;
import pageDescription.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class PageSwitchingWithAuthorization {
    protected final String loginUrl = "https://stellarburgers.nomoreparties.site/login";
    protected final String homePageUrl = "https://stellarburgers.nomoreparties.site/";
    protected final String registrationPageUrl = "https://stellarburgers.nomoreparties.site/register";
    protected final String personalAccountUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    RegistrationPage registrationPage;
    LoginPage loginPage;
    HomePage homePage;

    @Before
    public void createUser() {
        open(registrationPageUrl);
        registrationPage = new RegistrationPage();
        loginPage = registrationPage.setRegistrationFields(DefaultUserData.DEFAULT_USER_NAME,DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage = loginPage.setLoginFields(DefaultUserData.DEFAULT_USER_EMAIL, DefaultUserData.DEFAULT_USER_PASSWORD);
    }
    @After
    public void deleteUser() {
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }

    //Переход из личного кабинета в конструктор
    @Test
    @DisplayName("Switch from personal account to the home page and check URL and create order button")
    public void SwitchToHomePageWithAuthorization() {
        //Заходим на страницу "Личный кабинет"
        homePage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        //Нажимаем на логотип и проверяем загрузку домашней страницы
        personalAccountPage.clickLogo();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
        homePage.checkButtonCreateOrder();
    }
    //Переход по клику на «Личный кабинет»
    @Test
    @DisplayName("Switch from home page to personal account and check URL and exit button")
    public void SwitchToPersonalAccountWithAuthorization() {
        homePage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        personalAccountPage.checkVisibleExitButton();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",personalAccountUrl, currentUrl);
    }
}
