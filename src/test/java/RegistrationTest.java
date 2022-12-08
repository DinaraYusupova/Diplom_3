import com.codeborne.selenide.WebDriverRunner;
import dataGenerator.DefaultUserData;
import deleteData.DeleteUser;
import org.junit.Before;
import org.junit.Test;
import pageDescription.LoginPage;
import pageDescription.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {

    protected final String loginUrl = "https://stellarburgers.nomoreparties.site/login";
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;


    @Before
    public void setUp() {
        open(loginUrl);
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
    }


    @Test
    public void RegistrationUserTest() throws InterruptedException {
       // dataGenerator.DefaultUserData defaultUserData = new dataGenerator.DefaultUserData();
       // open(loginUrl);
        // создаем объект класса главной страницы приложения
       // LoginPage loginPage = new LoginPage();
        loginPage.clickRegistration();
        registrationPage.setRegistrationFields(DefaultUserData.DEFAULT_USER_NAME,DefaultUserData.DEFAULT_USER_EMAIL,DefaultUserData.DEFAULT_USER_PASSWORD);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL страницы входа",loginUrl, currentUrl);
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }

    @Test
    public void passwordErrorTest() {
       // dataGenerator.DefaultUserData defaultUserData = new dataGenerator.DefaultUserData();
      //  open(loginUrl);
        // создаем объект класса главной страницы приложения
       // LoginPage loginPage = new LoginPage();
        loginPage.clickRegistration();
        registrationPage.setPassword(DefaultUserData.ERROR_USER_PASSWORD);
        registrationPage.clickRegistration();
        registrationPage.checkVisibleErrorPasswordMessage();

    }
}
