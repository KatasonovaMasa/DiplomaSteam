package tests.mobile;

import com.codeborne.selenide.Configuration;
import config.BrowserstackConfig;
import drivers.BrowserstackDriver;
import help.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class BrowserstackTestBaseMobile {

    static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @BeforeAll
    public static void setup() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }


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
    }
}
