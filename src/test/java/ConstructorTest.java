
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageDescription.HomePage;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    protected final String homePageUrl = "https://stellarburgers.nomoreparties.site/";
    HomePage homePage;

    @Before
    public void createUser() {
        open(homePageUrl);
        homePage = new HomePage();
   }

    //Проверка, что по умолчанию открыт раздел "Булки"
    @Test
    @DisplayName("Checking that the \"Breads\" section is open by default")
    public void checkDefaultTabTest() {
        homePage.CheckTabBreadSelected();
    }
    //Переход к разделу "Булки"
    @Test
    @DisplayName("Select section \"Breads\" and check \"Breads\" is chosen")
    public void selectBreadTabTest() {
        homePage.clickTabSauce();
        homePage.clickTabBread();
        homePage.CheckTabBreadSelected();
    }
    //Переход к разделу "Соусы"
    @Test
    @DisplayName("Select section \"Sauce\" and check \"Sauce\" is chosen")
    public void selectSauceTabTest() {
        homePage.clickTabSauce();
        homePage.CheckTabSauceSelected();
    }
    //Переход к разделу "Начинки"
    @Test
    @DisplayName("Select section \"Filling\" and check \"Filling\" is chosen")
    public void selectFillingTabTest() {
        homePage.clickTabFilling();
        homePage.CheckTabFillingSelected();
    }

}
