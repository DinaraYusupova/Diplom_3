import org.junit.Test;
import pageDescription.HomePage;
import pageDescription.LoginPage;
import pageDescription.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class test {
    protected final String homeUrl = "https://stellarburgers.nomoreparties.site/";
    protected final String loginUrl = "https://stellarburgers.nomoreparties.site/login";

    @Test
    public void HomePage() {
        open(homeUrl);
        HomePage home = new HomePage();
        home.waitForLoadHomePage();
    }

    @Test
    public void LogoPage() {
        open(loginUrl);
LoginPage logoPage = new LoginPage();
        logoPage.clickLogo();
    }
    @Test
    public void LoginPage() {
        open(loginUrl);
        LoginPage logoPage = new LoginPage();
        logoPage.clickRegistration();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickLoginButton();
    }


}
