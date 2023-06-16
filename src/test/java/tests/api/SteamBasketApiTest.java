package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import models.ResultAddCart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.Specification;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("steamApi")
@Feature("Автотесты для API")
@Owner("Катасонова Мария")
public class SteamBasketApiTest {

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
}
