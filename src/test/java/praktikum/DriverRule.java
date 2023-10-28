package praktikum;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import static praktikum.EnvConfig.*;

public class DriverRule extends ExternalResource {
    WebDriver driver;

    @Override
    protected void before() throws Throwable {
        if ("yandex".equals((System.getProperty("browser"))))
            setUpYandex(); //mvn -Dbrowser=yandex test
        else
            setUpChrome(); //mvn test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEF_TIMEOUT));
    }

    private  void setUpChrome() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .withLogOutput(System.out)
                .usingDriverExecutable(new File(CHROMEDRIVER))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary(CHROME_BIN);

        driver = new ChromeDriver(service, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEF_TIMEOUT));
    }

    private void setUpYandex() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
               .withLogOutput(System.out)
               .usingDriverExecutable(new File(CHROMEDRIVER))
               .build();
        ChromeOptions options = new ChromeOptions()
               .setBinary(YANDEX_BIN);

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
