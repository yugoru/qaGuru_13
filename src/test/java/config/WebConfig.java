package config;

import org.aeonbits.owner.Config;

import java.net.URL;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({"system:properties",
        "classpath:config/localWebConfig.properties",
        "classpath:config/remoteWebConfig.properties",
        "classpath:config/driver.properties" })

public interface WebConfig extends Config {

    @Key("remote.web.user")
    String remoteWebUser();

    @Key("remote.web.password")
    String remoteWebPassword();

    @Key("base.url")
    static String baseUrl() {
        return baseUrl();
    }

    @Key("webdriver.remote")
    boolean isRemote();

    @Key("webdriver.url")
    URL getURL();

    @Key("webdriver.browser")
    BROWSER getBrowser();

    @Key("webdriver.browser.version")
    String getBrowserVersion();

    enum BROWSER {
        CHROME,
        FIREFOX,
        OPERA
    }
}