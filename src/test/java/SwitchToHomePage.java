import com.codeborne.selenide.WebDriverRunner;
import dataGenerator.DefaultUserData;
import deleteData.DeleteUser;
import org.junit.Test;
import pageDescription.HomePage;
import pageDescription.LoginPage;
import pageDescription.PersonalAccountPage;
import pageDescription.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class SwitchToHomePage {
    protected final String loginUrl = "https://stellarburgers.nomoreparties.site/login";
    protected final String homePageUrl = "https://stellarburgers.nomoreparties.site/";

    protected final String registerPageUrl = "https://stellarburgers.nomoreparties.site/register";

    @Test
    public void SwitchToHomePageWithoutAutorization() {
        open(loginUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.clickLogo();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
    }
    @Test
    public void SwitchToHomePageWithAutorization() throws InterruptedException {
        open(registerPageUrl);
        RegistrationPage registrationPage = new RegistrationPage();
        LoginPage loginPage = registrationPage.setRegistrationFields(DefaultUserData.DEFAULT_USER_NAME, DefaultUserData.DEFAULT_USER_EMAIL, DefaultUserData.DEFAULT_USER_PASSWORD);
        HomePage homePage = loginPage.setLoginFields(DefaultUserData.DEFAULT_USER_EMAIL, DefaultUserData.DEFAULT_USER_PASSWORD);
        homePage.clickPersonalAccount();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        personalAccountPage.clickLogo();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("Текущий URL не совпадает с URL домашней страницы",homePageUrl, currentUrl);
        DeleteUser deleteUser = new DeleteUser();
        deleteUser.deleteUser();
    }
}
