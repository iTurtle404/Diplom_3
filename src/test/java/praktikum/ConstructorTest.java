package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.MainPage;


public class ConstructorTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Transit to all section on Main Page (Constructor)")
    @Description("Possible Transit to all section on Main Page")
    public void transitToAllSectionTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage()
                .clickOnSauceButton()
                .checkIsGoToSauce()
                .clickOnFillingButton()
                .checkIsGoToFilling()
                .clickOnBunButton()
                .checkIsGoToBun();
    }

    @Test
    @DisplayName("Transit to section - Sauce. Constructor")
    @Description("Possible Transit to section - Sauce. Constructor")
    public void goToSauceTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage()
                .clickOnSauceButton()
                .checkIsGoToSauce();
    }
    @Test
    @DisplayName("Transit to section - Filling. Constructor")
    @Description("Possible Transit to section - Filling. Constructor")
    public void goToFillingTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage()
                .clickOnFillingButton()
                .checkIsGoToFilling();
    }
    @Test
    @DisplayName("Transit to section - Bun. Constructor")
    @Description("Possible Transit to section - Bun. Constructor")
    public void goToBunTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage()
                .clickOnFillingButton()
                .clickOnBunButton()
                .checkIsGoToBun();
    }
    @Test
    @DisplayName("Scroll on all section. Constructor")
    @Description("Possible scroll on all section.Constructor")
    public void scrollInIngredientsTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage()
                .ScrollDownToSauce();
        mainPage.ScrollDownToFilling();
        mainPage.ScrollUpToSauce();
        mainPage.ScrollUpToBun();
        mainPage.checkIsMainPage();
    }
}
