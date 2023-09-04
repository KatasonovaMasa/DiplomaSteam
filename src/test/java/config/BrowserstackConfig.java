package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:test.properties"
})

public interface BrowserstackConfig extends Config {
    @Key("username")
    @DefaultValue("lulushina_YnwUoV")
    String username();

    @Key("passwordKey")
    @DefaultValue("S3vcbwdzdijxoDRdMDsQ")
    String passwordKey();

    @Key("remoteMobileUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String remoteMobileUrl();

    @Key("app")
    @DefaultValue("bs://a2fa7f1d67e412b06dd644afb42c35e9e27edb3e")
    String app();

}
