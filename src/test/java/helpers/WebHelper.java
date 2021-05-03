package helpers;

import com.codeborne.selenide.Configuration;
import config.WebConfig;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.aeonbits.owner.Config.LoadType.MERGE;


public class WebHelper {

    public WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    public boolean isRemote() {
        return config.isRemote();
    }

    public String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid", "");
    }

    public void configureDriver(String baseUrl) {
        Configuration.baseUrl = baseUrl;
        Configuration.browser = config.getBrowser().toString();
        Configuration.browserVersion = config.getBrowserVersion();

        if (isRemote()) {
            Configuration.remote = config.getURL().toString();
        }
    }
    public void initDriver(WebConfig config, WebDriver driver) {

        if (config.isRemote()) {
            DesiredCapabilities capabilities;
            switch (config.getBrowser()) {
                case CHROME: {
                    capabilities = DesiredCapabilities.chrome();
                    break;
                }
                case FIREFOX: {
                    capabilities = DesiredCapabilities.firefox();
                    break;
                }
                case OPERA: {
                    capabilities = DesiredCapabilities.opera();
                    break;
                }
                default: {
                    capabilities = DesiredCapabilities.chrome();
                }
            }

            driver = new RemoteWebDriver(config.getURL(), capabilities);
        } else {
            driver = new ChromeDriver();
        }
    }
}

