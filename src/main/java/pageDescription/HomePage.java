package pageDescription;

import dataGenerator.LoginFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;

public class HomePage {
    //Локатор для кнопки "Войти в аккаунт"
    private final By buttonSignInAccount = byXpath(".//button[text()='Войти в аккаунт']");

    //Локатор для кнопки "Личный Кабинет"
    private final By buttonPersonalAccount = byXpath(".//*[text()='Личный Кабинет']");

    //Локатор для кнопки "Оформить заказ"
    private final By buttonCreateOrder = byXpath(".//button[text()='Оформить заказ']");

    //Локатор для перехода  на таб "Булки"
    private final By spanBread = byXpath(".//span[text()='Булки']");


    //Локатор для перехода  на таб "Соусы"
    private final By spanSauce = byXpath(".//span[text()='Соусы']");

    //Локатор для перехода  на таб "Начинки"
    private final By spanFilling = byXpath(".//span[text()='Начинки']");

    //Локатор таба "Соусы"
    private final By tabSauce = byXpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div[@style='display: flex;']/div[2]");

    //Локатор таба "Начинки"
    private final By tabFilling = byXpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div[@style='display: flex;']/div[3]");

    //Локатор таба "Булки>"
    private final By tabBread = byXpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div[@style='display: flex;']/div[1]");

    //Локатор для заголовка "Булки"
    private final By headerBread = byXpath(".//h2[text()='Булки']");

    //Локатор для заголовка "Соусы"
    private final By headerSauce = byXpath(".//h2[text()='Соусы']");

    //Локатор для заголовка "Начинки"
    private final By headerFilling = byXpath(".//h2[text()='Начинки']");

    //className для выбранного таба
   String CLASSNAME_FOR_SELECTED_TAB="tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

    //Нажать на кнопку "Войти в аккаунт"
    @Step("Click on the \"Login\" button and wait for the page loading")
    public LoginPage clickSignInAccount() {
        $(buttonSignInAccount).click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    //Нажать на кнопку "Личный Кабинет"
    @Step("Click on the \"Personal account\" button")
    public void clickPersonalAccount() {
        $(buttonPersonalAccount).click();
    }
    //Проверить отображение кнопки "Оформить заказ"
    @Step("Check the \"Create order\" button")
    public void checkButtonCreateOrder() {
        $(buttonCreateOrder).shouldBe(visible);
    }
    //Дождаться загрузки домашней страницы(проверяем видимость таба "Булки")
    public void waitForLoadHomePage(){
        $(spanBread).shouldBe(visible);
    }

    //Нажать на таб "Булки"
    @Step("Click tab bread")
    public void clickTabBread() {
        $(spanBread).click();
    }
    //Нажать на таб "Соусы"
    @Step("Click tab sauce")
    public void clickTabSauce() {
        $(spanSauce).click();
    }
    //Нажать на таб "Начинки"
    @Step("Click tab filling")
    public void clickTabFilling() {
        $(spanFilling).click();
    }
    //Проверка выбран ли таб "Булки"
    @Step("Check tab \"Bread\" is selected")
    public void CheckTabBreadSelected() {
        assertEquals("Текущие атрибуты таба не соответствуют состоянию 'Выбран'",CLASSNAME_FOR_SELECTED_TAB, $(tabBread).attr("class"));;
        $(headerBread).shouldBe(visible);
    }
    //Проверка выбрал ли таб "Соусы"
    @Step("Check tab \"Sauce\" is selected")
    public void CheckTabSauceSelected() {
        assertEquals("Текущие атрибуты таба не соответствуют состоянию 'Выбран'",CLASSNAME_FOR_SELECTED_TAB, $(tabSauce).attr("class"));;
        $(headerSauce).shouldBe(visible);
    }
    //Проверка выбрал ли таб "Начинки"
    @Step("Check tab \"Filling\" is selected")
    public void CheckTabFillingSelected() {
        assertEquals("Текущие атрибуты таба не соответствуют состоянию 'Выбран'",CLASSNAME_FOR_SELECTED_TAB, $(tabFilling).attr("class"));;
        $(headerFilling).shouldBe(visible);
    }
    //Выбор кнопки перехода на страницу авторизации на домашней странице
    public void clickLoginButton(LoginFlow flow) {
        if (flow.equals(LoginFlow.TOP)) {
            clickPersonalAccount();
        }
        else {
            clickSignInAccount();
        }
    }
}
