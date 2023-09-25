package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:test.properties"
})

public interface BrowserstackConfig extends Config {
    @Key("username")
    @DefaultValue("katasonova_kmaPs9")
    String username();

    @Key("passwordKey")
    @DefaultValue("8TExsumVYK6Ge57hF2yT")
    String passwordKey();

    @Key("remoteMobileUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String remoteMobileUrl();

    @Key("app")
    @DefaultValue("bs://a50c24c8bed421284e6a1e201846f5776a569843")
    String app();

}
