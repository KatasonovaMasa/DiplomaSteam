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
public class SteamCommunityWebTest extends BaseWebTest {

    @Test
    @Story("Раздел игр")
    @DisplayName("Рекомендации в Активности сообщества")
    void checkCommunityActive(){
        newSteamAuthorizationPage.openSteam()
                                 .openAuthorization();
        newSteamCommunityPage.openCommunity()
                             .successActiveCommunity();
        newSteamAuthorizationPage.logout();
    }
}