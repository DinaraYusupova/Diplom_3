import com.codeborne.selenide.WebDriverRunner;
import dataGenerator.DefaultUserData;
import deleteData.DeleteUser;
import io.qameta.allure.junit4.DisplayName;
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
    protected final String registrationPageUrl = "https://stellarburgers.nomoreparties.site/register";
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;

    @Before
    public void createUser() {
        open(registrationPageUrl);
        registrationPage = new RegistrationPage();
        loginPage = registrationPage.setRegistrationFields(DefaultUserData.DEFAULT_USER_NAME,DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
    }

    @After
    public void deleteUser() {
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }

    //Авторизация через кнопку в форме регистрации
    @Test
    @DisplayName("Authorization through the button in the registration form and check URL and create order button")
    public void LoginFromRegistrationForm() {
        loginPage.clickRegistration();
        registrationPage.clickLoginButton();
        homePage = loginPage.setLoginFields(DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage.checkButtonCreateOrder();//кнопка видна только для авторизованного пользователя
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
    }
    //Авторизация  через кнопку в форме восстановления пароля
    @Test
    @DisplayName("Authorization through the button in the reset password form and check URL and create order button")
    public void LoginFromResetPasswordForm() {
        ResetPasswordPage resetPasswordPage = loginPage.clickResetPassword();
        resetPasswordPage.clickLoginButton();
        homePage = loginPage.setLoginFields(DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage.checkButtonCreateOrder();//кнопка видна только для авторизованного пользователя
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
    }
}
