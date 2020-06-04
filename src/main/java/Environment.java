import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Environment {
    private static WebDriver webDriver;

    public static void setWebDriver(WebDriver webDriver) {
        Environment.webDriver = webDriver;
    }

    public static WebDriver initDriver() {

        System.setProperty("webdriver.gecko.driver","D:\\Work\\University\\Testing\\Web_Tests\\Lab_4_1\\geckodriver.exe");
        File pathBinary = new File("D:\\Programs\\Mozilla\\firefox.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        DesiredCapabilities desired = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
        WebDriver DRIVER = new FirefoxDriver(options);
        return DRIVER;
    }
}