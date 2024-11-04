package Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseUITest {
    WebDriver driver;

    @Before
    public void createDriver() {
        initYandex();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        driver.close();
    }

    public void initChrome() {
        driver = new ChromeDriver();
    }

    public void initFireFox() {
        driver = new FirefoxDriver();
    }

    public void initYandex(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Dmitry/WebDriver/bin/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/Dmitry/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
            driver = new ChromeDriver(options);
    }
}
