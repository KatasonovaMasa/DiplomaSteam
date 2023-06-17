package config;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:test.properties"
})
public interface WebConfig extends Config {
    @Config.Key("baseUrl")
    @Config.DefaultValue("https://store.steampowered.com")
    String getBaseUrl();

    @Config.Key("browser")
    @Config.DefaultValue("FIREFOX")
    String getBrowser();

    @Config.Key("remoteUrl")
    String getRemoteUrl();

    @Config.Key("browserVersion")
    @Config.DefaultValue("113.0")
    String getBrowserVersion();

    @Config.Key("browserSize")
    @Config.DefaultValue("1920x1080")
    String getBrowserSize();
}
