package pageDescription;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ResetPasswordPage {
    //Локатор для кнопки "Войти"
    private final By buttonLogin = byLinkText("Войти");

    //Локатор для кнопки "Войти"
    private final By headerResetPassword = byXpath(".//h2[text()='Восстановление пароля']");

    //Нажать на кнопку "Войти"
    @Step("Click on the \"Login\" button and wait for the login page loading")
    public LoginPage clickLoginButton() {
        $(buttonLogin).click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    public void waitForLoadResetPasswordPage() {
        $(headerResetPassword).shouldBe(visible);
    }
}
