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
public class SteamIntegrationTest extends TestBase {
    SteamSteps steamSteps = new SteamSteps();

    @Test
    @Story("Интеграция с другими сервисами")
    @DisplayName("Открытие раздела SteamWorks")
    void openSteamIntegrationWorks() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.openSteamWorks();
        steamSteps.successOpenSteamWorks();
        steamSteps.logout();
    }

    @Test
    @Story("Интеграция с другими сервисами")
    @DisplayName("Работа в Steam")
    void openSteamIntegrationJob() {
        steamSteps.openSteam();
        steamSteps.openAuthorization();
        steamSteps.openJobsSteam();
        steamSteps.successJobsSoftwareEngineering();
        steamSteps.logout();
    }
}