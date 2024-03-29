package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import help.Attach;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.util.Map;


public class BaseWebTest {
    AuthorizationPage newAuthorizationPage = new AuthorizationPage();
    BasketPage newBasketPage = new BasketPage();
    CommunityPage newCommunityPage = new CommunityPage();
    GamesPage newGamesPage = new GamesPage();
    IntegrationPage newIntegrationPage = new IntegrationPage();

    static WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        SelenideLogger.addListener("Allure",new AllureSelenide());
//        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browser = webConfig.getBrowser();
        Configuration.browserVersion = webConfig.getBrowserVersion();
//        Configuration.remote = webConfig.getRemoteUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterAll
    static void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
