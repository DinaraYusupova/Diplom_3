package pageDescription;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ResetPasswordPage {
    //Локатор для кнопки "Войти"
    private final By buttonLogin = byLinkText("Войти");

    //Локатор для кнопки "Войти"
    private final By headerResetPassword = byXpath(".//h2[text()='Восстановление пароля']");

    //Нажать на кнопку "Войти"
    public void clickLoginButton() {
        $(buttonLogin).click();
    }

    public void waitForLoadResetPasswordPage() {
        $(headerResetPassword).shouldBe(visible);
    }
}
