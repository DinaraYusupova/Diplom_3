import dataGenerator.DefaultUserData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageDescription.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationErrorTest {
    protected final String registrationPageUrl = "https://stellarburgers.nomoreparties.site/register";
    protected RegistrationPage registrationPage;

    @Before
    public void setUp() {
        open(registrationPageUrl);
        registrationPage = new RegistrationPage();
    }

    @Test
    @DisplayName("Registration new user with wrong password and check error message")
    public void passwordErrorTest() {
        registrationPage.setPassword(DefaultUserData.ERROR_USER_PASSWORD);
        registrationPage.clickRegistration();
        registrationPage.checkVisibleErrorPasswordMessage();
    }
}
