package pageDescription;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PersonalAccountPage {
    //Локатор для логотипа
    private final By logo = byXpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");

    //Локатор для кнопки "Выход"
    private final By buttonExit = byXpath(".//button[text()='Выход']");


    //Проверить отображение кнопки "Выход"
    public void checkVisibleExitButton() {
        $(buttonExit).shouldBe(visible);
    }

    //Нажать кнопку "Выход" и дождаться загрузки страницы авторизации
    @Step("Click on the \"Exit\" button and wait for the login page loading")
    public LoginPage clickExit() {
        $(buttonExit).click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    //Нажать на логотип и дождаться загрузки домашней страницы
    @Step("Click on the \"Logo\" and wait for the home page loading")
    public HomePage clickLogo() {
        $(logo).click();
        HomePage homePage = page(HomePage.class);
        homePage.waitForLoadHomePage();
        return homePage;
    }
}
