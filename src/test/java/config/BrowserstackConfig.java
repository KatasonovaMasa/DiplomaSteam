package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:test.properties"
})

public interface BrowserstackConfig extends Config {
    @Key("username")
    @DefaultValue("katas_NkXKwR")
    String username();

    @Key("passwordKey")
    @DefaultValue("4E8c6VrCNUUjqBzoLNe8")
    String passwordKey();

    @Key("remoteMobileUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String remoteMobileUrl();

    @Key("app")
    @DefaultValue("bs://191ad38940ff32f9801b28c7121d3651e9a94e57")
    String app();

}
