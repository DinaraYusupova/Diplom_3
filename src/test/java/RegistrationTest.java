import com.codeborne.selenide.WebDriverRunner;
import deleteData.DeleteUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageDescription.LoginPage;
import pageDescription.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    protected final String loginUrl = "https://stellarburgers.nomoreparties.site/login";
    protected DefaultUserData defaultUserData;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;


    @Before
    public void setUp() {
        defaultUserData = new DefaultUserData();
        open(loginUrl);
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
    }


    @Test
    public void RegistrationUserTest() {
       // DefaultUserData defaultUserData = new DefaultUserData();
       // open(loginUrl);
        // создаем объект класса главной страницы приложения
       // LoginPage loginPage = new LoginPage();
        loginPage.clickRegistration();

       // RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.setRegistrationFields(defaultUserData.getDEFAULT_USER_NAME(),defaultUserData.getDEFAULT_USER_EMAIL(),defaultUserData.getDEFAULT_USER_PASSWORD());
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL страницы входа",loginUrl, currentUrl);
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }

    @Test
    public void passwordErrorTest() {
       // DefaultUserData defaultUserData = new DefaultUserData();
      //  open(loginUrl);
        // создаем объект класса главной страницы приложения
       // LoginPage loginPage = new LoginPage();
        loginPage.clickRegistration();
      //  RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.setPassword(defaultUserData.getERROR_USER_PASSWORD());
        registrationPage.clickRegistration();
        registrationPage.checkVisibleErrorPasswordMessage();

    }
}
