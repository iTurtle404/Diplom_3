package pages;

import org.openqa.selenium.WebDriver;

import static pages.TestData.BASE_URL;

public class MainPage {
    final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
