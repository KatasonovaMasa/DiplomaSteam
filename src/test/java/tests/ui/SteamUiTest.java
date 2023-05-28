package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.SteamSteps;

@Tag("steamUI")
@Owner("Катасонова Мария")
@Feature("Автотесты для UI")
public class SteamUiTest extends TestBase {
    SteamSteps steamSteps = new SteamSteps();

    @Test
    @Story("Авторизация на сайте")
    @DisplayName("Авторизация на сайте")
    void authorization(){
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.logout();
    }


    @Test
    @Story("Раздел игр")
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
    @Story("Раздел игр")
    @DisplayName("Рекомендации в Активности сообщества")
    void checkCommunityActive() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.openCommunity();
        steamSteps.successActiveCommunity();
        steamSteps.logout();
    }



    @Test
    @Story("Раздел игр")
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
    @Story("Корзина")
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
    @Story("Корзина")
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
    @Story("Интеграция с другими сервисами")
    @DisplayName("Открытие раздела SteamWorks")
    void openSteamWorks() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.openSteamWorks();
        steamSteps.successOpenSteamWorks();
        steamSteps.logout();
    }

    @Test
    @Story("Интеграция с другими сервисами")
    @DisplayName("Работы в Steam")
    void jobsInSteam() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.openJobsSteam();
        steamSteps.successJobsSoftwareEngineering();
        steamSteps.logout();
    }
}