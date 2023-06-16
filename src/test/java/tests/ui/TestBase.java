package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import help.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.SteamAuthorizationPage;
import pages.SteamBasketPage;
import pages.SteamCommunityPage;
import pages.SteamGamesPage;

import java.util.Map;

public class TestBase {
    SteamAuthorizationPage newSteamAuthorizationPage = new SteamAuthorizationPage();
    SteamBasketPage newSteamBasketPage = new SteamBasketPage();
    SteamCommunityPage newSteamCommunityPage = new SteamCommunityPage();
    SteamGamesPage newSteamGamesPage = new SteamGamesPage();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://store.steampowered.com";
        Configuration.baseUrl = System.getProperty("baseurl", "https://store.steampowered.com/");
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.browserVersion = System.getProperty("browser_version", "100.0");//нельзя ставить версию больше чем на selenoid
//        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
//        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url", "selenoid.autotests.cloud/wd/hub"); //запускает автотесты не локально а через selenoid
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//
//    Configuration.browserCapabilities = capabilities;
}
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterAll
    static void addAttachments () {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
