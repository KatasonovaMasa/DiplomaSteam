package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.Specification;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Tag("steamApi")
@Feature("Автотесты для API")
@Owner("Катасонова Мария")
public class SteamAccessApiTest {

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
}
