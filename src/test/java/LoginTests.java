import com.codeborne.selenide.WebDriverRunner;
import dataGenerator.DefaultUserData;
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
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;

    @Before
    public void createUser() {
        open(loginPageUrl);
        loginPage = new LoginPage();
        registrationPage = loginPage.clickRegistration();
        registrationPage.setRegistrationFields(DefaultUserData.DEFAULT_USER_NAME,DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);

    }

    @After
    public void deleteUser() throws InterruptedException {
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }


    @Test
    public void LoginWithButtonSignIn() {
        homePage = loginPage.clickLogo();
        homePage.clickSignInAccount();
        loginPage.setLoginFields(DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage.checkButtonCreateOrder();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
    }

    @Test
    public void LoginWithPersonalAccount() {
        homePage = loginPage.clickLogo();
        homePage.clickPersonalAccount();
        loginPage.checkVisibleLoginButton();
        loginPage.setLoginFields(DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage.checkButtonCreateOrder();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
    }

    @Test
    public void LoginFromRegistrationForm() {
        loginPage.clickRegistration();
        registrationPage.clickLoginButton();
        homePage = loginPage.setLoginFields(DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage.checkButtonCreateOrder();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
      //    homePage.checkButtonCreateOrder();

    }
    @Test
    public void LoginFromResetPassswordForm() {
        ResetPasswordPage resetPasswordPage = loginPage.clickResetPassword();
      //  ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.clickLoginButton();
        homePage = loginPage.setLoginFields(DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage.checkButtonCreateOrder();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
    }
}
