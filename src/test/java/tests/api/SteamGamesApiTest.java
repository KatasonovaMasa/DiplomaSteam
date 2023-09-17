package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import models.ResultSearch;
import models.Achievements;
import models.SteamNews;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.Specification;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("steamApi")
@Feature("Автотесты для API")
@Owner("Катасонова Мария")
public class SteamGamesApiTest {

    @Test
    @Story("Раздел игр")
    @DisplayName("Проверка поиска игр")
    void searchJobApi() {
        ResultSearch data = given()
                .queryParam("start", "50")
                .queryParam("term", "Cuphead")
                .queryParam("supportedlang", "russian")
                .queryParam("infinite", "1")
                .spec(Specification.request)
                .when()
                .get("/search/results/results/?query")
                .then()
                .spec(Specification.responseSpec)
                .log().body()
                .extract().as(ResultSearch.class);
        assertEquals(1, data.getSuccess());
        assertEquals(20, data.getTotal_count());
    }

    @Test
    @Story("Раздел игр")
    @DisplayName("Открытие раздела игр 'Выживание'")
    void openSurvivalGamesApi() {
        given()
                .queryParam("cc", "RU")
                .queryParam("l", "english")
                .queryParam("start", "32")
                .queryParam("flavor", "popularpurchased")
                .queryParam("strContentHubType", "category")
                .queryParam("strContentHubCategory", "survival")
                .spec(Specification.request)
                .when()
                .get("/saleaction/ajaxgetsaledynamicappquery?cc=RU&l=english")
                .then()
                .spec(Specification.responseSpec)
                .body(matchesJsonSchemaInClasspath("schemes/openCategories.json"));
    }

    @Test
    @Story("Игровые новости")
    @DisplayName("Проверка новостей по игре")
    void checkingGameNews() {
        SteamNews data = given()
                .queryParam("appid", 100)
                .queryParam("count", 3)
                .spec(Specification.requestNewsGames)
                .when()
                .get("ISteamNews/GetNewsForApp/v0002/")
                .then()
                .log().body()
                .extract().as(SteamNews.class);
        Assertions.assertEquals(1499722448, data.getAppnews().getNewsitems().get(0).getDate());
        assertThat(1499722448).isEqualTo(data.getAppnews().getNewsitems().get(0).getDate());
    }

    @Test
    @Story("Процент достижений")
    @DisplayName("Процент достижений полученный из статистики пользователей")
    void checkingAchievementPercentages() {
        Achievements data = given()
                .queryParam("gameid", 300)
                .spec(Specification.requestNewsGames)
                .when()
                .get("ISteamUserStats/GetGlobalAchievementPercentagesForApp/v0002/")
                .then()
                .log().body()
                .extract().as(Achievements.class);
        Assertions.assertEquals("DOD_WIN_KNIFE_FIGHT", data.getAchievementpercentages().getAchievements().get(2).getName());
        assertThat("DOD_WIN_KNIFE_FIGHT").isEqualTo(data.getAchievementpercentages().getAchievements().get(2).getName());

        Assertions.assertEquals(19.700000762939453, data.getAchievementpercentages().getAchievements().get(2).getPercent());
        assertThat(19.700000762939453).isEqualTo(data.getAchievementpercentages().getAchievements().get(2).getPercent());
    }
}
