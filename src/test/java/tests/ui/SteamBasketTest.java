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
public class SteamBasketTest extends TestBase {
    SteamSteps steamSteps = new SteamSteps();

    @Test
    @Story("Корзина")
    @DisplayName("Добавление игры в корзину")
    void addBasketGames(){
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
    void deleteBasketGame(){
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.addGameCart();
        steamSteps.deleteBasketGames();
        steamSteps.successBasketEmpty();
        steamSteps.logout();
    }


}