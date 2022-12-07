
package pageDescription;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {


    //Локатор для кнопки "Зарегистрироваться"
    private final By buttonRegistration = byLinkText("Зарегистрироваться");
    //Локатор для кнопки "Восстановить пароль"
    private final By buttonResetPassword = byLinkText("Восстановить пароль");
    //Локатор для кнопки "Войти"
    private final By buttonLogin = byXpath(".//button[text()='Войти']");
    //Локатор для поля "Email"
    private final By buttonEmail = byXpath(".//fieldset[1]//input");
    //Локатор для поля "Пароль"
    private final By buttonPassword = byXpath(".//fieldset[2]//input");

    private final By logo = byXpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");


    //Нажать на кнопку "Восстановить пароль"
    public void clickRegistration() {
        $(buttonRegistration).click();
    }

    //Нажать на кнопку "Восстановить пароль"
    public void clickResetPassword() {
        $(buttonResetPassword).click();
    }

    //Проверить отображение кнопки "Войти"
    public void checkVisibleLoginButton() {
        $(buttonLogin).shouldBe(visible);
    }
    //Нажать на кнопку "Войти"
    public void clickLogin() {
        $(buttonLogin).click();
    }

    //Заполнить поле "email"
    public void setEmail(String email) {
        $(buttonEmail).setValue(email);
    }
    //Заполнить поле "password"
    public void setPassword(String password) {
        $(buttonPassword).setValue(password);
    }

    public void waitForLoadLoginPage(){
        $(buttonLogin).shouldBe(visible);
    }

    public HomePage setLoginFields(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLogin();
        HomePage homePage = page(HomePage.class);
        homePage.waitForLoadHomePage();
        return homePage;
    }
  //  Нажать на кнопку логотип
    public HomePage clickLogo() {
        $(logo).click();
        HomePage homePage = page(HomePage.class);
        homePage.waitForLoadHomePage();
        return homePage;
    }
}
