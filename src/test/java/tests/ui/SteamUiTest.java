package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.SteamSteps;
import tests.TestBase;

@Tag("steamUI")
@Owner("Катасонова Мария")
@Feature("Aвтотесты для Steam")
@Story("Автотесты для UI")
public class SteamUiTest extends TestBase {
    SteamSteps steamSteps = new SteamSteps();

    @Test
    @DisplayName("Авторизация на сайте")
    void authorization(){
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.logout();
    }


    @Test
    @DisplayName("Открытие раздела игр 'Выживание'")
    void openSurvivalGames() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.openShop();
        steamSteps.openCategories();
        steamSteps.openSectionSurvivalGames();
        steamSteps.successSurvivalGames();
        steamSteps.logout();
    }

    @Test
    @DisplayName("Рекомендации в Активности сообщества")
    void checkCommunityActive() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.openCommunity();
        steamSteps.successActiveCommunity();
        steamSteps.logout();
    }

    @Test
    @DisplayName("Открытие раздела SteamWorks")
    void openSteamWorks() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.openSteamWorks();
        steamSteps.successOpenSteamWorks();
        steamSteps.logout();
    }

    @Test
    @DisplayName("Кнопка поиска игр")
    void searchJob() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.setSearch();
        steamSteps.clickSearch();
        steamSteps.successSearchJob();
        steamSteps.logout();
    }

    @Test
    @DisplayName("Добавление игры в корзину")
    void potentialBuyGames() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.openGames();
        steamSteps.addGameToCart();
        steamSteps.successBasketGame();
        steamSteps.logout();
    }


    @Test
    @DisplayName("Удалить игру из корзины")
    void deleteGameCart() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.addGameCart();
        steamSteps.deleteGameCart();
        steamSteps.successCartEmpty();
        steamSteps.logout();
    }

    @Test
    @DisplayName("Работа в Steam")
    void jobsInSteam() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.openJobsSteam();
        steamSteps.successJobsSoftwareEngineering();
        steamSteps.logout();
    }
}