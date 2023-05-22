package tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {
    public static RequestSpecification requestSearch = with()
            .baseUri("https://store.steampowered.com")
            .basePath("/search/results")
            .log().all()
            .contentType(ContentType.JSON);

    public static RequestSpecification requestOpen = with()
            .baseUri("https://store.steampowered.com")
            .basePath("/saleaction/ajaxgetsaledynamicappquery?")
            .log().all()
            .contentType(ContentType.JSON);

    public static RequestSpecification requestAddCard = with()
            .baseUri("https://store.steampowered.com")
            .basePath("dynamicstore/saledata/?")
            .log().all()
            .contentType(ContentType.JSON);

    public static RequestSpecification responseAccess  = with()
            .baseUri("https://store.steampowered.com")
            .basePath("/api")

            .log().all()
            .contentType(ContentType.JSON);
    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

}
