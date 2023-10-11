package tests.mobile;

import com.codeborne.selenide.Configuration;
import drivers.LocalDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class LocalTestBaseMobile {

    static LocalMobileConfig localMobileConfig = ConfigFactory.create(LocalMobileConfig.class, System.getProperties());

    @BeforeAll
    public static void setup() {
    Configuration.browser = LocalDriver.class.getName();
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
        closeWebDriver();
    }
}
