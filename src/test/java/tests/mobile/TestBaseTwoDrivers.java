package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBaseTwoDrivers {
    static String deviceHost = System.getProperty("deviceHost");
    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalDriver.class.getName();
                break;
            default:
                throw new RuntimeException();
        }
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
        //  Attach.screenshotAs("Last screenshot");
        // Attach.pageSource();
        closeWebDriver();
        Attach.addVideo(sessionId);
        if (deviceHost.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
    }
}
