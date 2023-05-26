package tests.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.http.ContentType;
import lombok.ResultSearch;
import lombok.SteamNews;
import models.ResultAddCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static help.CustomApiListener.withCustomTemplates;
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
        SelenideLogger.addListener("allure", new AllureSelenide());
        ResultSearch data = given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .queryParam("start", "50")
                .queryParam("term", "Cuphead")
                .queryParam("supportedlang", "russian")
                .queryParam("infinite", "1")
                .spec(Specification.requestSearch)
                .when()
                .get("/results/?query")
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
        SelenideLogger.addListener("allure", new AllureSelenide());
        given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .queryParam("cc", "RU")
                .queryParam("l", "english")
                .queryParam("start", "32")
                .queryParam("flavor", "popularpurchased")
                .queryParam("strContentHubType", "category")
                .queryParam("strContentHubCategory", "survival")
                .spec(Specification.requestOpen)
                .when()
                .get("cc=RU&l=english")
                .then()
                .spec(Specification.responseSpec)
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemes/openCategories.json"));
    }

    @Test
    @Story("Корзина")
    @DisplayName("Добавление игры в корзину")
    void potentialBuyGamesApi() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        ResultAddCart data = given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .queryParam("cc", "RU")
                .spec(Specification.requestAddCard)
                .when()
                .get()
                .then()
                .spec(Specification.responseSpec)
                .extract().as(ResultAddCart.class);
        assertTrue(data.isbAllowAppImpressions());
    }

    @Test
    @Story("Ограничение доступа")
    @DisplayName("Проверка доступа")
    void AccessGamesApi() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .spec(Specification.requestAccess)
                .when()
                .get()
                .then()
                .statusCode(403)
                .body(matchesJsonSchemaInClasspath("schemes/access.json"));
    }

    @Test
    @Story("")
    @DisplayName("Проверка новостей по игре")
    void checkingGameNews() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        SteamNews data = given()
                .filter(withCustomTemplates())
                .contentType(ContentType.JSON)
                .queryParam("appid", 100)
                .queryParam("count", 3)
                .spec(Specification.requestNewsGames)
                .when()
                .get()
                .then()
                .log().body()
                .extract().as(SteamNews.class);
        Assertions.assertEquals(1499722448, data.getAppnews().getNewsitems().get(0).getDate());
        assertThat(1499722448).isEqualTo(data.getAppnews().getNewsitems().get(0).getDate());
    }
}
