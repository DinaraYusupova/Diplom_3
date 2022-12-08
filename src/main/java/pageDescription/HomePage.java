package pageDescription;

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

    //Локатор для таба "Булки"
    private final By tabSauce = byXpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div[@style='display: flex;']/div[2]");
    //Локатор таба "Соусы"
    private final By tabFilling = byXpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div[@style='display: flex;']/div[3]");
    //Локатор таба "Начинки"
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
    public LoginPage clickSignInAccount() {
        $(buttonSignInAccount).click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }
    //Нажать на кнопку "Личный Кабинет"
    public void clickPersonalAccount() {
        $(buttonPersonalAccount).click();
    }
    //Проверить отображение кнопки "Оформить заказ"
    public void checkButtonCreateOrder() {
        $(buttonCreateOrder).shouldBe(visible);
    }
    //Дождаться загрузки домашней страницы(проверяем видимость таба "Булки")
    public void waitForLoadHomePage(){
        $(spanBread).shouldBe(visible);
    }

    //Нажать на таб "Булки"
    public void clickTabBread() {
        $(spanBread).click();
    }
    //Нажать на таб "Соусы"
    public void clickTabSauce() {
        $(spanSauce).click();
    }
    //Нажать на таб "Начинки"
    public void clickTabFilling() {
        $(spanFilling).click();
    }
    //Проверка выбрал ли таб "Булки"
    public void CheckTabBreadSelected() {
        assertEquals("Текущие атрибуты таба не соответствуют состоянию 'Выбран'",CLASSNAME_FOR_SELECTED_TAB, $(tabBread).attr("class"));;
        $(headerBread).shouldBe(visible);
    }
    //Проверка выбрал ли таб "Соусы"
    public void CheckTabSauceSelected() {
        assertEquals("Текущие атрибуты таба не соответствуют состоянию 'Выбран'",CLASSNAME_FOR_SELECTED_TAB, $(tabSauce).attr("class"));;
        $(headerSauce).shouldBe(visible);
    }
    //Проверка выбрал ли таб "Начинки"
    public void CheckTabFillingSelected() {
        assertEquals("Текущие атрибуты таба не соответствуют состоянию 'Выбран'",CLASSNAME_FOR_SELECTED_TAB, $(tabFilling).attr("class"));;
        $(headerFilling).shouldBe(visible);
    }

}
