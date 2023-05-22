package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})

public interface BrowserstackConfig extends Config {

    @Key("username")
    String username();
    @Key("passwordKey")
    String passwordKey();
    @Key("remoteUrl")
    String remoteUrl();
    @Key("app")
    String app();

}
