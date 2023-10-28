package praktikum;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

import static pages.TestData.DEF_TIMEOUT;

public class DriverRule extends ExternalResource {
    WebDriver driver;

    @Override
    protected void before() throws Throwable {
        if ("yandex".equals((System.getProperty("browser"))))
            setUpYandex();
        else
            setUpChrome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEF_TIMEOUT));
    }

    private  void setUpChrome() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/Applications/chromedriver"))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary("/Applications/chrome.app/Contents/MacOS/Google Chrome for Testing");

        driver = new ChromeDriver(service, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEF_TIMEOUT));
    }

        private void setUpYandex() {
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("/Applications/chromedriver"))
                    .build();
            ChromeOptions options = new ChromeOptions()
                    .setBinary("/Applications/yandex.app/Contents/MacOS/Yandex");

            driver = new ChromeDriver(service, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEF_TIMEOUT));
        }


    @Override
    protected void after(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
