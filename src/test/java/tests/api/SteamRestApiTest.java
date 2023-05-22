package tests.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.http.ContentType;
import models.ResultAddCart;
import models.ResultSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.Specs;

import static help.CustomApiListener2.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("steamApi")
@Feature("Апишка для тестов Steam")
@Owner("Катасонова Мария")
public class SteamRestApiTest {

    @Test
    @Story("Раздел Игр")
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
                .spec(Specs.requestSearch)
                .when()
                .get("/results/?query")
                .then()
                .spec(Specs.responseSpec)
                .log().body()
                .extract().as(ResultSearch.class);
        assertEquals(1, data.getSuccess());
        assertEquals( 17, data.getTotal_count());
    }

    @Test
    @Story("Раздел Игр")
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
                .spec(Specs.requestOpen)
                .when()
                .get("cc=RU&l=english")
                .then()
                .spec(Specs.responseSpec)
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemes/openCategories.json"));
    }

    @Test
    @Story("Раздел Игр")
    @DisplayName("Добавление игры в корзину")
    void potentialBuyGamesApi() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        ResultAddCart data = given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .queryParam("cc", "RU")
                .spec(Specs.requestAddCard)
                .when()
                .get()
                .then()
                .spec(Specs.responseSpec)
                .extract().as(ResultAddCart.class);
        assertEquals(true, data.isbAllowAppImpressions());
    }
    @Test
    @Story("Раздел Игр")
    @DisplayName("Проверка доступа")
    void AccessGamesApi() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .spec(Specs.responseAccess)
                .when()
                .get()
                .then()
                .statusCode(403)
                .body(matchesJsonSchemaInClasspath("schemes/access.json"));
    }
}
