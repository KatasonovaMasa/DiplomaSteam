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
public class SteamAuthorizationWebTest extends BaseWebTest {
    private String login = "Test_quru", password = "Mgbb4gas!)";

    @Test
    @Story("Авторизация на сайте")
    @DisplayName("Авторизация на сайте")
    void authorization() {
        newAuthorizationPage.openSteam().openAuthorization(login, password).logout();
    }
}