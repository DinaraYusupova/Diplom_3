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

public class PersonalAccountTest {
    protected final String registerPageUrl = "https://stellarburgers.nomoreparties.site/register";
    protected final String loginPageUrl = "https://stellarburgers.nomoreparties.site/login";
    protected LoginPage loginPage;
    protected HomePage homePage;


    @Before
    public void createUser() {
        open(registerPageUrl);
        RegistrationPage registrationPage = new RegistrationPage();
        loginPage = registrationPage.setRegistrationFields(DefaultUserData.DEFAULT_USER_NAME, DefaultUserData.DEFAULT_USER_EMAIL, DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage = loginPage.setLoginFields(DefaultUserData.DEFAULT_USER_EMAIL, DefaultUserData.DEFAULT_USER_PASSWORD);
    }
    @After
    public void deleteUser() throws InterruptedException {
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }
    //Выход по кнопке «Выйти» в личном кабинете
    @Test
    @DisplayName("Exit from personal account and check URL and loin button")
    public void ExitPersonalAccountWithAutorization() throws InterruptedException {
        homePage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        personalAccountPage.clickExit();
        loginPage.waitForLoadLoginPage();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",loginPageUrl, currentUrl);
    }
}
