package pageDescription;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    //Локатор для поля "Имя"
     private final By fieldName = byXpath(".//fieldset[1]//input");

    //Локатор для поля "Email"
    private final By fieldEmail = byXpath(".//fieldset[2]//input");

    //Локатор для поля "Пароль"
    private final By fieldPassword = byXpath(".//fieldset[3]//input");

    //Локатор для кнопки "Зарегистрироваться"
    private final By buttonRegistration = byXpath(".//button[text()='Зарегистрироваться']");

    //Локатор для ошибки "Некорректный пароль"
    private final By errorPasswordMessage = byXpath(".//*[text()='Некорректный пароль']");

    //Локатор для кнопки "Войти"
    private final By buttonLogin = byLinkText("Войти");

    //Заполнить поле "Имя"
    public void setName(String name) {
        $(fieldName).setValue(name);
    }
    //Заполнить поле "email"
    public void setEmail(String email) {
        $(fieldEmail).setValue(email);
    }
    //Заполнить поле "password"
    public void setPassword(String password) {
        $(fieldPassword).setValue(password);
    }

    //Нажать на кнопку "Зарегистрироваться"
    public void clickRegistration() {
        $(buttonRegistration).click();
    }
    //Заполнить все поля, нажать "Зарегистрироваться" и дождаться загрузки страницы авторизации
    @Step("Registration and  wait for the login page loading")
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
    @Step("check password error message")
    public void checkVisibleErrorPasswordMessage() {
        $(errorPasswordMessage).shouldBe(visible);
    }
    //Нажать кнопку "Войти" и дождаться загрузки страницы авторизации
    @Step("Click on the \"Login\" button and wait for the login page loading")
    public LoginPage clickLoginButton() {
        $(buttonLogin).click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }
    //Дождаться загрузки страницы авторизации (проверяем видимость кнопки "Войти")
    public void waitForLoadRegistrationPage() {
        $(fieldName).shouldBe(visible);
    }
}
