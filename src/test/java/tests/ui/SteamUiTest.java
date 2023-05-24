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
    void avtorization(){
        steamSteps.openSteam();
        steamSteps.openAvtorization();
        steamSteps.logout();
    }


    @Test
    @DisplayName("Открытие раздела игр 'Выживание'")
    void openSurvivalGames() {
        steamSteps.openSteam();
        steamSteps.openAvtorization();
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
        steamSteps.openAvtorization();
        steamSteps.openCommunity();
        steamSteps.successActiveCommunity();
        steamSteps.logout();
    }

    @Test
    @DisplayName("Открытие раздела SteamWorks")
    void openSteamWorks() {
        steamSteps.openSteam();
        steamSteps.openAvtorization();
        steamSteps.openSteamWorks();
        steamSteps.successOpenSteamWorks();
        steamSteps.logout();
    }

    @Test
    @DisplayName("Кнопка поиска игр")
    void searchJob() {
        steamSteps.openSteam();
        steamSteps.openAvtorization();
        steamSteps.setSearch();
        steamSteps.clickSearch();
        steamSteps.successSearchJob();
        steamSteps.logout();
    }

    @Test
    @DisplayName("Добавление игры в корзину")
    void potentialBuyGames() {
        steamSteps.openSteam();
        steamSteps.openAvtorization();
        steamSteps.openGames();
        steamSteps.addGameToCart();
        steamSteps.successBasketGame();
        steamSteps.logout();
    }


    @Test
    @DisplayName("Удалить игру из корзины")
    void deleteGameCart() {
        steamSteps.openSteam();
        steamSteps.openAvtorization();
        steamSteps.addGameCart();
        steamSteps.deleteGameCart();
        steamSteps.successCartEmpty();
        steamSteps.logout();
    }

    @Test
    @Tag("steamUITwo")
    @DisplayName("Работы в Steam")
    void jobsInSteam() {
        steamSteps.openSteam();
        steamSteps.openAvtorization();
        steamSteps.openJobsSteam();
        steamSteps.successJobsSoftwareEngineering();
        steamSteps.logout();
    }
}