package tests.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.http.ContentType;
import models.ResultSearch;
import models.SteamAchievements;
import models.SteamNews;
import models.ResultAddCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.Specification;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("steamApi")
@Feature("Автотесты для API")
@Owner("Катасонова Мария")
public class SteamApiTest {

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
        assertEquals( 17, data.getTotal_count());
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
    @Story("Корзина")
    @DisplayName("Добавление игры в корзину")
    void potentialBuyGamesApi() {
        ResultAddCart data = given()
                .queryParam("cc", "RU")
                .spec(Specification.request)
                .when()
                .get("dynamicstore/saledata/?/")
                .then()
                .spec(Specification.responseSpec)
                .extract().as(ResultAddCart.class);
        assertTrue(data.isbAllowAppImpressions());
    }

    @Test
    @Story("Ограничение доступа")
    @DisplayName("Проверка доступа")
    void AccessGamesApi() {
        given()
                .spec(Specification.request)
                .when()
                .get("/api")
                .then()
                .body(matchesJsonSchemaInClasspath("schemes/access.json"));
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
        SteamAchievements data = given()
                .queryParam("gameid", 300)
                .spec(Specification.requestNewsGames)
                .when()
                .get("ISteamUserStats/GetGlobalAchievementPercentagesForApp/v0002/")
                .then()
                .log().body()
                .extract().as(SteamAchievements.class);
        Assertions.assertEquals("DOD_WIN_KNIFE_FIGHT", data.getAchievementpercentages().getAchievements().get(2).getName());
        assertThat("DOD_WIN_KNIFE_FIGHT").isEqualTo(data.getAchievementpercentages().getAchievements().get(2).getName());

        Assertions.assertEquals( 19.799999237060547, data.getAchievementpercentages().getAchievements().get(2).getPercent());
        assertThat( 19.799999237060547).isEqualTo(data.getAchievementpercentages().getAchievements().get(2).getPercent());
    }
}
