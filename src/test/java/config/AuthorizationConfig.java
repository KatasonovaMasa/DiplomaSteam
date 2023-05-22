package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:authorization.properties"
})
public interface AuthorizationConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();
}
