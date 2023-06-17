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
    private String login = "Test_quru", password = "Mgbb4gas!)";
    @Test
    @Story("Корзина")
    @DisplayName("Добавление игры в корзину")
    void addBasketGames() {
        newAuthorizationPage.openSteam()
                .openAuthorization(login, password);
        newBasketPage.openGames()
                .addGameToCart()
                .successBasketGame();
        newAuthorizationPage.logout();
    }

    @Test
    @Story("Корзина")
    @DisplayName("Удалить игру из корзины")
    void deleteBasketGame() {
        newAuthorizationPage.openSteam()
                .openAuthorization(login, password);
        newBasketPage.openGames()
                .addGameToCart()
                .deleteBasketGames()
                .successBasketEmpty();
        newAuthorizationPage.logout();
    }
}