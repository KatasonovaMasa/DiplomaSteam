package tests.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.http.ContentType;
import models.ResultSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.SteamSteps;
import tests.Specs;
import tests.TestBase;

import static help.CustomApiListener2.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
@Tag("steamUI")
@Owner("Катасонова Мария")
public class SteamTest extends TestBase {
    SteamSteps steamSteps = new SteamSteps();

    @Test
    @Feature("Автотесты")
    @Story("Раздел Игр")
    @DisplayName("Открытие раздела игр 'Выживание'")
    void openSurvivalGames() {
        steamSteps.openSteam();
        steamSteps.openShop();
        steamSteps.openCategories();
        steamSteps.openSectionSurvivalGames();
        steamSteps.successSurvivalGames();
    }

    @Test
    @Feature("Автотесты")
    @Story("Разделы Активность сообщества")
    @DisplayName("Рекомендации в Активности сообщества")
    void checkCommunityActive() {
        steamSteps.openSteam();
        steamSteps.openCommunity();
        steamSteps.successActiveCommunity();
    }

    @Test
    @Feature("Автотесты")
    @Story("Раздел Игр")
    @DisplayName("Кнопка поиска игр")
    void searchJob() {
        steamSteps.openSteam();
        steamSteps.setSearch();
        steamSteps.clickSearch();
        steamSteps.successSearchJob();
    }

    @Test
    @Feature("Автотесты")
    @Story("Корзина игр")
    @DisplayName("Добавление игры в корзину")
    void potentialBuyGames() {
        steamSteps.openSteam();
        steamSteps.openGames();
        steamSteps.addGameToCart();
        steamSteps.successBasketGame();
    }


    @Test
    @Feature("Автотесты")
    @Story("Корзина игр")
    @DisplayName("Удалить игру из корзины")
    void deleteGameCart() {
        steamSteps.openSteam();
        steamSteps.addGameCart();
        steamSteps.deleteGameCart();
        steamSteps.successCartEmpty();
    }
}