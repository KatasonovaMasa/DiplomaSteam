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
public class SteamAuthorizationTest extends TestBase {
    SteamSteps steamSteps = new SteamSteps();

    @Test
    @Story("Авторизация на сайте")
    @DisplayName("Авторизация на сайте")
    void authorization(){
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.logout();
    }
}