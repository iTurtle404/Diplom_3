package praktikum;

import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.MainPage;


public class ConstructorTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
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
    public void goToSauceTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage()
                .clickOnSauceButton()
                .checkIsGoToSauce();
    }
    @Test
    public void goToFillingTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage()
                .clickOnFillingButton()
                .checkIsGoToFilling();
    }
    @Test
    public void goToBunTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage()
                .clickOnFillingButton()
                .clickOnBunButton()
                .checkIsGoToBun();
    }
    @Test
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
