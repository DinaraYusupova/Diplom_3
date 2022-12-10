package pageDescription;

import dataGenerator.LoginFlow;
import io.qameta.allure.Step;
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
    private final By fieldEmail = byXpath(".//fieldset[1]//input");

    //Локатор для поля "Пароль"
    private final By fieldPassword = byXpath(".//fieldset[2]//input");

    //Локатор для логотипа
    private final By logo = byXpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");



    //Нажать на кнопку "Зарегистрироваться" и дождаться загрузки страницы регистрации
    @Step("Click on the \"Registration\" button and wait for the page loading")
    public RegistrationPage clickRegistration() {
        $(buttonRegistration).click();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.waitForLoadRegistrationPage();
        return registrationPage;
    }

    //Нажать на кнопку "Восстановить пароль"  и дождаться загрузки страницы восстановления пароля
    @Step("Click on the \"Reset password\" button and wait for the page loading")
    public ResetPasswordPage clickResetPassword() {
        $(buttonResetPassword).click();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.waitForLoadResetPasswordPage();
        return resetPasswordPage;
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
        $(fieldEmail).setValue(email);
    }
    //Заполнить поле "password"
    public void setPassword(String password) {
        $(fieldPassword).setValue(password);
    }
    //Дождаться загрузки страницы авторизации (проверяем видимость кнопки "Войти")
    public void waitForLoadLoginPage(){
        $(buttonLogin).shouldBe(visible);
    }
    //Заолнить все поля, нажать "Войти" и дождаться загрузки домашней страницы
    @Step("Login and  wait for the home page loading")
    public HomePage setLoginFields(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLogin();
        HomePage homePage = page(HomePage.class);
        homePage.waitForLoadHomePage();
        return homePage;
    }
  //  Нажать на логотип и дождаться загрузки домашней страницы
  @Step("Click on the \"Logo\" and wait for the home page loading")
    public HomePage clickLogo() {
        $(logo).click();
        HomePage homePage = page(HomePage.class);
        homePage.waitForLoadHomePage();
        return homePage;
    }
}
