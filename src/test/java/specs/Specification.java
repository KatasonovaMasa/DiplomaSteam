package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static help.CustomApiListener.withCustomTemplates;

import static io.restassured.RestAssured.with;

public class Specification {
    public static RequestSpecification request = with()
            .baseUri("https://store.steampowered.com")
            .log().all()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);
    public static RequestSpecification requestNewsGames  = with()
            .baseUri("http://api.steampowered.com")
            .basePath("/")
            .log().all()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);
    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}