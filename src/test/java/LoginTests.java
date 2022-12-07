import com.codeborne.selenide.WebDriverRunner;
import deleteData.DeleteUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageDescription.HomePage;
import pageDescription.LoginPage;
import pageDescription.RegistrationPage;
import pageDescription.ResetPasswordPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;


public class LoginTests {
    protected final String homePageUrl = "https://stellarburgers.nomoreparties.site/";
    protected final String loginPageUrl = "https://stellarburgers.nomoreparties.site/login";
    protected DefaultUserData defaultUserData;
    protected HomePage homePage;
    protected LoginPage loginPage;

    RegistrationPage registrationPage;

    @Before
    public void createUser() {
        defaultUserData = new DefaultUserData();
        open(loginPageUrl);
        loginPage = new LoginPage();
        loginPage.clickRegistration();
        registrationPage = new RegistrationPage();
        registrationPage.setRegistrationFields(defaultUserData.getDEFAULT_USER_NAME(),defaultUserData.getDEFAULT_USER_EMAIL(),defaultUserData.getDEFAULT_USER_PASSWORD());

    }

    @After
    public void deleteUser() {
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }


    @Test
    public void LoginWithButtonSignIn() {
        loginPage.clickLogo();
        homePage = new HomePage();
        homePage.clickSignInAccount();
        loginPage.checkVisibleLoginButton();
        loginPage.setLoginFields(defaultUserData.getDEFAULT_USER_EMAIL(),defaultUserData.getDEFAULT_USER_PASSWORD());
        homePage.checkButtonCreateOrder();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
    }

    @Test
    public void LoginWithPersonalAccount() {
        loginPage.clickLogo();
        homePage = new HomePage();
        homePage.clickPersonalAccount();
        loginPage.checkVisibleLoginButton();
        loginPage.setLoginFields(defaultUserData.getDEFAULT_USER_EMAIL(),defaultUserData.getDEFAULT_USER_PASSWORD());
        homePage.checkButtonCreateOrder();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
    }

    @Test
    public void LoginFromRegistrationForm() {
        loginPage.clickRegistration();
        registrationPage.clickLoginButton();
        homePage = loginPage.setLoginFields(defaultUserData.getDEFAULT_USER_EMAIL(),defaultUserData.getDEFAULT_USER_PASSWORD());
        homePage.checkButtonCreateOrder();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
      //    homePage.checkButtonCreateOrder();

    }
    @Test
    public void LoginFromResetPassswordForm() {
        loginPage.clickResetPassword();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.clickLoginButton();
        homePage = loginPage.setLoginFields(defaultUserData.getDEFAULT_USER_EMAIL(),defaultUserData.getDEFAULT_USER_PASSWORD());
        homePage.checkButtonCreateOrder();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
        //    homePage.checkButtonCreateOrder();
//
//        homePage = loginPage.setLoginFields(defaultUserData.getDEFAULT_USER_EMAIL(),defaultUserData.getDEFAULT_USER_PASSWORD());
//        homePage.checkButtonCreateOrder();
//        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
//        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
        //    homePage.checkButtonCreateOrder();

    }
}
