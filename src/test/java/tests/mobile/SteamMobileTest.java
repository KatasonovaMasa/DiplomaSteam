package tests.mobile;

import config.AuthorizationConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.qameta.allure.Allure.step;
import static java.time.temporal.ChronoUnit.MILLIS;

@Tag("steamMobile")
@Feature("Aвтотесты для Steam")
@Story("Автотесты для Mobile")
@Owner("Катасонова Мария")
public class SteamMobileTest extends tests.TestBase {
    static AuthorizationConfig config = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());


    @Test
    @Order(1)
    @DisplayName("Авторизация в приложении")
    void openApp() {
        step("Авторизация", () -> {
            $$(AppiumBy.className("android.widget.EditText")).get(0).click();
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(0).sendKeys(config.login());
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(1).click();
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(1).sendKeys(config.password());
            sleep(1000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(4).click();
            sleep(15000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(3).shouldHave(visible);
        });
    }

    @Test
    @Order(2)
    @DisplayName("Кнопка поиска игр")
    void searchJobApi() {
        step("Поиск игры", () -> {
            $$(AppiumBy.className("android.widget.EditText")).get(0).click();
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(0).sendKeys(config.login());
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(1).click();
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(1).sendKeys(config.password());
            sleep(1000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(4).click();
            sleep(15000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(3).shouldHave(visible);
            back();
            back();
            swipeUpQuick(12000);
            swipeUpQuick(12000);



            sleep(3000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(1).click();
            sleep(5000);
            $(AppiumBy.className("android.widget.EditText")).sendKeys("Cuphead" + "\n");
            sleep(5000);
            $(AppiumBy.xpath("//android.view.View[@content-desc=\"blank\"]/android.widget.Image")).click();
            sleep(5000);
            $$(AppiumBy.className("android.view.View")).get(1).shouldHave(text("Cuphead - The Delicious Last Course"));
        });
    }

    @Test
    @Order(3)
    @DisplayName("Добавление игры в корзину")
    void potentialBuyGames() {
        step("Добавление игры в корзину", () -> {
            $$(AppiumBy.className("android.widget.EditText")).get(0).click();
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(0).sendKeys(config.login());
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(1).click();
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(1).sendKeys(config.password());
            sleep(1000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(4).click();
            back();
            back();
            swipeUpQuick(12000);
            swipeUpQuick(12000);



            sleep(3000);
            $(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Steam\"]")).click();
            sleep(3000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(1).click();
            sleep(3000);
            $(AppiumBy.className("android.widget.EditText")).sendKeys("Cuphead" + "\n");
            sleep(1000);
            $(AppiumBy.xpath("//android.view.View[@content-desc=\"blank\"]/android.widget.Image")).click();
            sleep(1000);
            swipeUpQuick(12000);
            swipeUpQuick(12000);
            sleep(1000);
            $(AppiumBy.xpath("(//android.view.View[@content-desc=\"Add to Cart\"])[1]/android.widget.TextView")).click();
            sleep(3000);
            $$(AppiumBy.className("android.view.View")).get(2).shouldHave(text("YOUR SHOPPING CART")); // проверка нахождения в корзине
        });
    }

    @Test
    @Order(4)
    @DisplayName("Удалить игру из корзины")
    void deleteGameCart() {
        step("Удалить игру из корзины", () -> {
            $$(AppiumBy.className("android.widget.EditText")).get(0).click();
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(0).sendKeys(config.login());
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(1).click();
            sleep(1000);
            $$(AppiumBy.className("android.widget.EditText")).get(1).sendKeys(config.password());
            sleep(1000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(4).click();
            back();
            back();
            swipeUpQuick(12000);
            swipeUpQuick(12000);



            sleep(3000);
            $(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Steam\"]")).click();
            sleep(3000);
            $$(AppiumBy.className("android.view.ViewGroup")).get(1).click();
            sleep(3000);
            $(AppiumBy.xpath("//android.view.View[@content-desc=\"Remove\"]/android.widget.TextView")).click();
            sleep(5000);
            $$(AppiumBy.className("android.view.View")).get(4).shouldHave(text("Your item has been removed!"));
        });
    }

    public void swipeUp(int timeOfSwipeMs) {
        TouchAction action = new TouchAction((PerformsTouchActions) getWebDriver());
        Dimension size = getWebDriver().manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);


        action
                .press(point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.of(timeOfSwipeMs, MILLIS)))
                .moveTo(point(x, end_y))
                .release()
                .perform();
    }

    public void swipeUpQuick(int i) {
        swipeUp(2000);
    }

}
