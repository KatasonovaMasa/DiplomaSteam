package tests.mobile;

import com.codeborne.selenide.Configuration;
import config.WebConfig;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import help.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBaseMobile {

    protected static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    static boolean isRemote = Boolean.parseBoolean(System.getProperty("isRemote", config.isRemote()));

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = LocalDriver.class.getName();
        if (isRemote) {
             Configuration.browser = BrowserstackDriver.class.getName();
        }
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
        Configuration.browserSize = null;
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
        if (isRemote) {
            Attach.addVideo(sessionId);
        }
    }
}