import com.codeborne.selenide.WebDriverRunner;
import dataGenerator.DefaultUserData;
import dataGenerator.LoginFlow;
import deleteData.DeleteUser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageDescription.HomePage;
import pageDescription.LoginPage;
import pageDescription.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LoginFromHomePageTest {

    protected final String homePageUrl = "https://stellarburgers.nomoreparties.site/";
    protected final String registrationPageUrl = "https://stellarburgers.nomoreparties.site/register";
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;

    LoginFlow loginFlow;

    public LoginFromHomePageTest(LoginFlow loginFlow) {
        this.loginFlow = loginFlow;
    }

    @Before
    public void createUser() {
        open(registrationPageUrl);
        registrationPage = new RegistrationPage();
        loginPage = registrationPage.setRegistrationFields(DefaultUserData.DEFAULT_USER_NAME,DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage = loginPage.clickLogo();
    }

    @After
    public void deleteUser() {
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }

    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][] {
                {LoginFlow.TOP},
                {LoginFlow.BOTTOM},
        };
    }

    //Авторизация через кнопки "Войти в аккаунт" и «Личный кабинет» на домашней странице
    @Test
    @DisplayName("Authorization through the buttons \"Login to account\" and \"Personal account\" on the home page and check URL and create order button")
    public void LoginFromHomePage() {
        homePage.clickLoginButton(loginFlow);
        loginPage.setLoginFields(DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage.checkButtonCreateOrder(); //кнопка видна только для авторизованного пользователя
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
    }
}
