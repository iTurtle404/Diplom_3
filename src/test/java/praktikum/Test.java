package praktikum;

import org.junit.Rule;
import pages.MainPage;

public class Test {
    @Rule
    public DriverRule driverRule = new DriverRule();


    @org.junit.Test
    public void test() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
    }
}
