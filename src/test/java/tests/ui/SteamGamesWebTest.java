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
public class SteamGamesWebTest extends BaseWebTest {


    @Test
    @Story("Раздел игр")
    @DisplayName("Открытие раздела игр 'Выживание'")
    void openSurvivalGames() {
        newAuthorizationPage.openSteam()
                .openAuthorization();
        newGamesPage.openShop()
                .openCategories()
                .openSectionSurvivalGames()
                .successSurvivalGames();
    }

    @Test
    @Story("Раздел игр")
    @DisplayName("Кнопка поиска игр")
    void searchJob() {
        newAuthorizationPage.openSteam()
                .openAuthorization();
        newGamesPage.setSearch()
                .clickSearch()
                .successSearchJob();
    }
}