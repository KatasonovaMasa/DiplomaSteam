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
public class SteamIntegrationWebTest extends BaseWebTest {
    private String login = "Test_quru", password = "Mgbb4gas!)";
    @Test
    @Story("Интеграция с другими сервисами")
    @DisplayName("Открытие раздела SteamWorks")
    void openSteamIntegrationWorks() {
        newAuthorizationPage.openSteam()
                .openAuthorization(login, password);
        newIntegrationPage.openSteamWorks()
                .successOpenSteamWorks();
        newAuthorizationPage.logout();
    }

    @Test
    @Story("Интеграция с другими сервисами")
    @DisplayName("Работа в Steam")
    void openSteamIntegrationJob() {
        newAuthorizationPage.openSteam()
                .openAuthorization(login, password);
        newIntegrationPage.openJobsSteam()
                .successJobsSoftwareEngineering();
        newAuthorizationPage.logout();
    }
}