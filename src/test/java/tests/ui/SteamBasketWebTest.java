package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("steamUI")
@Owner("Катасонова Мария")
@Feature("Автотесты для UI")
public class SteamBasketWebTest extends BaseWebTest {

    @Test
    @Story("Корзина")
    @DisplayName("Добавление игры в корзину")
    void addBasketGames(){
        newSteamAuthorizationPage.openSteam()
                                 .openAuthorization();
        newSteamBasketPage.openGames()
                          .addGameToCart()
                          .successBasketGame();
        newSteamAuthorizationPage.logout();
    }

    @Test
    @Story("Корзина")
    @DisplayName("Удалить игру из корзины")
    void deleteBasketGame(){
        newSteamAuthorizationPage.openSteam()
                                 .openAuthorization();
        newSteamBasketPage.openGames()
                          .addGameToCart()
                          .deleteBasketGames()
                          .successBasketEmpty();
        newSteamAuthorizationPage.logout();
    }


}