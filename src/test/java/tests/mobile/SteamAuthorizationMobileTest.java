package tests.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import config.AuthorizationConfig;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;

@Tag("steamMobile")
@Feature("Автотесты для Mobile")
@Owner("Катасонова Мария")
public class SteamAuthorizationMobileTest extends BrowserstackTestBaseMobile {
    static AuthorizationConfig config = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());

    @Test
    @Story("Авторизация в приложении")
    @DisplayName("Авторизация в приложении")
    void openApp() {
        $$(MobileBy.className("android.widget.EditText")).get(0).click();
        $$(MobileBy.className("android.widget.EditText")).get(0).sendKeys(config.login());
        $$(MobileBy.className("android.widget.EditText")).get(1).click();
        $$(MobileBy.className("android.widget.EditText")).get(1).sendKeys(config.password());

        $$(MobileBy.className("android.view.ViewGroup")).get(4).click();

// ...

        $$(MobileBy.className("android.widget.TextView")).get(14).shouldHave(Condition.text("Done")).click();
        $$(MobileBy.className("android.widget.TextView")).get(4).shouldHave(Condition.text("Add authenticator")).click();

        $$(MobileBy.className("android.widget.ImageView")).get(0).shouldBe(Condition.visible).click();
        $$(MobileBy.className("android.widget.TextView")).get(0).shouldHave(Condition.text("katasonomasa").because("Не вошли в профиль"));

        $$(MobileBy.className("android.widget.TextView")).get(20).shouldHave(Condition.text("Sign Out")).click();
        $$(MobileBy.className("android.widget.Button")).get(0).click();
        $(MobileBy.xpath("//android.widget.TextView[contains(@text, 'Forgot your account name or password?')]")).shouldHave(Condition.visible.because("Не вышли из приложения"));
    }
        //    public <MobileDriver> void swipeRightToLeft(int duration) {
//        Dimension size = getWebDriver().manage().window().getSize();
//        int startX = (int) (size.width * 0.8);
//        int endX = (int) (size.width * 0.2);
//        int startY = size.height / 2;
//        TouchAction action = new TouchAction((PerformsTouchActions) getWebDriver());
//        action.press(PointOption.point(startX, startY))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
//                .moveTo(PointOption.point(endX, startY))
//                .release()
//                .perform();
//    }

    public static void swipeRightToLeft() {
        AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.8);
        int endX = (int) (size.width * 0.2);
        int startY = size.height / 2;
        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
    }

}
