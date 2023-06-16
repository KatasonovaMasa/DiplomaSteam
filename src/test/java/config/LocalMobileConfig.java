package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface LocalMobileConfig extends Config {
    @Key("deviceName")
    @DefaultValue("OnePlus 9")
    String deviceName();

    @Key("osVersion")
    @DefaultValue("11.0")
    String osVersion();

    @DefaultValue("http://0.0.0.0:4723/wd/hub")
    @Key("url")
    String url();

    @DefaultValue("android")
    @Key("platformName")
    String platformName();

}
