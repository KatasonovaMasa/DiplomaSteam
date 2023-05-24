package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import config.LocalConfig;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    static LocalConfig configLocal = ConfigFactory.create(LocalConfig.class, System.getProperties());
    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials
          mutableCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        mutableCapabilities.setCapability("browserstack.user", config.username());
        mutableCapabilities.setCapability("browserstack.key", config.passwordKey());
        mutableCapabilities.setCapability("app", config.app());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", configLocal.deviceName());
        mutableCapabilities.setCapability("os_version", configLocal.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project","config.project()");
        mutableCapabilities.setCapability("build", "config.build()");
        mutableCapabilities.setCapability("name", "config.name()");

        try {
            return new RemoteWebDriver(
                    new URL(config.remoteUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}