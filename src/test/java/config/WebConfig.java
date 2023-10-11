package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:test.properties"
})
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("2500x1080")
    String getBrowserSize();

    @Key("videoUrl")
    String videoUrl();

    @Config.Key("baseUrl")
    @Config.DefaultValue("https://store.steampowered.com")
    String getBaseUrl();

    @Key("false")
    @DefaultValue("isRemote")
    String isRemote();
}
