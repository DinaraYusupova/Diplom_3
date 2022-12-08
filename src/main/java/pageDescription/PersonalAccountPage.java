package pageDescription;

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
    //Нажать кнопку "Выход"
    public void clickExit() {
        $(buttonExit).click();
    }

    //  Нажать на логотип и дождаться загрузки домашней страницы
    public HomePage clickLogo() {
        $(logo).click();
        HomePage homePage = page(HomePage.class);
        homePage.waitForLoadHomePage();
        return homePage;
    }


}
