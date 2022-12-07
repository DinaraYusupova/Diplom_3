package pageDescription;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class ResetPasswordPage {
    private final By buttonLogin = byLinkText("Войти");

    //Нажать на кнопку "Войти"
    public void clickLoginButton() {
        $(buttonLogin).click();
    }

}
