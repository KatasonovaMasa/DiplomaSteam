package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.SteamSteps;
import tests.TestBase;
import tests.TestBase2;

@Tag("steamUI")
@Owner("Катасонова Мария")
@Feature("UI aвтотесты")
public class SteamTest extends TestBase {
    SteamSteps steamSteps = new SteamSteps();

    @Test
    @Story("Раздел игр")
    @DisplayName("Авторизация на сайте")
    void avtorization(){
        steamSteps.openSteam();
        steamSteps.openAvtorization();
        steamSteps.logout();
    }


    @Test
    @Story("Раздел Игр")
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
    @Story("Разделы Активность сообщества")
    @DisplayName("Рекомендации в Активности сообщества")
    void checkCommunityActive() {
        steamSteps.openSteam();
        steamSteps.openAvtorization();
        steamSteps.openCommunity();
        steamSteps.successActiveCommunity();
        steamSteps.logout();
    }

    @Test
    @Story("Раздел Игр")
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
    @Story("Корзина игр")
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
    @Story("Корзина игр")
    @DisplayName("Удалить игру из корзины")
    void deleteGameCart() {
        steamSteps.openSteam();
        steamSteps.openAvtorization();
        steamSteps.addGameCart();
        steamSteps.deleteGameCart();
        steamSteps.successCartEmpty();
        steamSteps.logout();
    }
}