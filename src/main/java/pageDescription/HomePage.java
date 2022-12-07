package pageDescription;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    private final By buttonSignInAccount = byXpath(".//button[text()='Войти в аккаунт']");

    private final By buttonPersonalAccount = byXpath(".//*[text()='Личный Кабинет']");

    private final By buttonCreateOrder = byXpath(".//button[text()='Оформить заказ']");

    private final By spanBread = byXpath(".//span[text()='Булки']");

    //Нажать на кнопку "Войти в аккаунт"
    public void clickSignInAccount() {
        $(buttonSignInAccount).click();
    }
    //Нажать на кнопку "Личный Кабинет"
    public void clickPersonalAccount() {
        $(buttonPersonalAccount).click();
    }
    //Проверить отображение кнопки "Оформить заказ"
    public void checkButtonCreateOrder() {
        $(buttonCreateOrder).shouldBe(visible);
    }

    public void waitForLoadHomePage(){
        $(spanBread).shouldBe(visible);
    }
}
