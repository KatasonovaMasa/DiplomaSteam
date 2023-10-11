package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:test.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("username")
    String username();

    @Key("passwordKey")
    String passwordKey();

    @Key("remoteMobileUrl")
    String remoteMobileUrl();

    @Key("app")
    String app();

    @Key("deviceName")
    String deviceName();

    @Key("osVersion")
    String osVersion();

    @Key("url")
    String url();

    @Key("platformName")
    String platformName();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();
}
