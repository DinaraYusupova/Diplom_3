import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import pageDescription.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class ConstructorTest {
    protected final String homePageUrl = "https://stellarburgers.nomoreparties.site/";

    @Test
    public void checkDefaultTabTest() {
        open(homePageUrl);
        HomePage homePage = new HomePage();
        homePage.CheckTabBreadSelected();
    }

    @Test
    public void selectBreadTabTest() {
        open(homePageUrl);
        HomePage homePage = new HomePage();
        homePage.clickTabSauce();
        homePage.clickTabBread();
        homePage.CheckTabBreadSelected();
    }

    @Test
    public void selectSauceTabTest() throws InterruptedException {
        open(homePageUrl);
        HomePage homePage = new HomePage();
        homePage.clickTabSauce();
        Thread.sleep(3000);
        homePage.CheckTabSauceSelected();
    }

    @Test
    public void selectFillingTabTest() throws InterruptedException {
        open(homePageUrl);
        HomePage homePage = new HomePage();
        homePage.clickTabFilling();
        Thread.sleep(3000);
        homePage.CheckTabFillingSelected();
    }

}
