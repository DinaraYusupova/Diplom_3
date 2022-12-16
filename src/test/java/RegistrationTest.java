import com.codeborne.selenide.WebDriverRunner;
import dataGenerator.DefaultUserData;
import deleteData.DeleteUser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageDescription.RegistrationPage;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    protected final String loginUrl = "https://stellarburgers.nomoreparties.site/login";
    protected final String registrationPageUrl = "https://stellarburgers.nomoreparties.site/register";
    protected RegistrationPage registrationPage;


    @Before
    public void setUp() {
        open(registrationPageUrl);
        registrationPage = new RegistrationPage();
    }
    @Test
    @DisplayName("Registration new user and check URL and login button")
    public void RegistrationUserTest() {
        registrationPage.setRegistrationFields(DefaultUserData.DEFAULT_USER_NAME,DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL страницы входа",loginUrl, currentUrl);
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }

    @Test
    @DisplayName("Registration new user with wrong password and check error message")
    public void passwordErrorTest() {
        registrationPage.setPassword(DefaultUserData.ERROR_USER_PASSWORD);
        registrationPage.clickRegistration();
        registrationPage.checkVisibleErrorPasswordMessage();
    }
}
