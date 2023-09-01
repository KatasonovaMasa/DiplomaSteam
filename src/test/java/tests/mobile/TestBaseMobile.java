package tests.mobile;

import com.codeborne.selenide.Configuration;
import config.BrowserstackConfig;
import config.LocalMobileConfig;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import help.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBaseMobile {
    static String deviceHost = System.getProperty("deviceHost");
    @BeforeAll
    public static void setup() {
        if (deviceHost == null) {
            deviceHost = "local";
        }

        switch (deviceHost) {
            case "real":
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
    }
//    static LocalMobileConfig localMobileConfig = ConfigFactory.create(LocalMobileConfig.class, System.getProperties());
  //  static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

//    @BeforeAll
//    public static void setup() {
//        Configuration.browser = BrowserstackMobileDriver.class.getName();
//        Configuration.pageLoadStrategy = "eager";
////        Configuration.browser = LocalMobileDriver.class.getName();
//        Configuration.browserSize = null;
//        Configuration.timeout = 10000;
//    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId().toString();
        closeWebDriver();
        Attach.addVideos(sessionId);
        if (deviceHost.equals("browserstack")) {
            Attach.addVideos(sessionId);
        }
    }
}
