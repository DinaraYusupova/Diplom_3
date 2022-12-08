package pageDescription;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    //Локатор для поля "Имя"
     private final By buttonName = byXpath(".//fieldset[1]//input");


    //Локатор для поля "Email"
    private final By buttonEmail = byXpath(".//fieldset[2]//input");
    //Локатор для поля "Пароль"
    private final By buttonPassword = byXpath(".//fieldset[3]//input");
    //Локатор для кнопки "Зарегистрироваться"
    private final By buttonRegistration = byXpath(".//button[text()='Зарегистрироваться']");
    private final By errorPasswordMessage = byXpath(".//*[text()='Некорректный пароль']");

    private final By buttonLogin = byLinkText("Войти");

    //Заполнить поле "Имя"
    public void setName(String name) {
        $(buttonName).setValue(name);
    }
    //Заполнить поле "email"
    public void setEmail(String email) {
        $(buttonEmail).setValue(email);
    }
    //Заполнить поле "password"
    public void setPassword(String password) {
        $(buttonPassword).setValue(password);
    }

    //Нажать на кнопку "Заказать" в шапке страницы
    public void clickRegistration() {
        $(buttonRegistration).click();
    }

    public LoginPage setRegistrationFields(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistration();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    //Проверить отображение ошибки "Некорректный пароль"
    public void checkVisibleErrorPasswordMessage() {
        $(errorPasswordMessage).shouldBe(visible);
    }

    //Нажать на кнопку "Войти"
    public void clickLoginButton() {
        $(buttonLogin).click();
    }

    public void waitForLoadRegistrationPage() {
        $(buttonName).shouldBe(visible);
    }
}
