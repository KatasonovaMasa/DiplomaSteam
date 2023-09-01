package help;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CommandExecutor;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.temporal.ChronoUnit.MILLIS;

public class PhoneManagerHelper {
    @Step("Получить значение из буфера обмена")
    public static String getClipboardValue() {
        // ToDo добавить обработку: android or ios
        return ((AndroidDriver) WebDriverRunner.getWebDriver()).getClipboardText();
    }

    @Step("Загрузить медиафайл [{mediaClasspath}] на телефон")
    // https://www.browserstack.com/docs/app-automate/appium/advanced-features/test-with-sample-data#use-pre-loaded-media-files
    public static void uploadMedia(String mediaClasspath) {
        File file = new File("src/test/resources/media", mediaClasspath);
        if (!file.exists())
            throw new RuntimeException("File by path [" + file.getAbsoluteFile() + "] don't exist");

        // ToDo добавить обработку: android or ios
        try {
            ((AndroidDriver) WebDriverRunner.getWebDriver()).pushFile("/sdcard/Download/" + file.getName(), file);
        } catch (IOException e) {
            throw new RuntimeException("Error during upload media file");
        }
    }

    @Step("Нажать кнопку поиска на клавиатуре")
    public static void search() {
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @Step("Добавить заглушку: во время съемки на камеру отдавать заглушку")
    // https://www.browserstack.com/docs/app-automate/appium/advanced-features/camera-image-injection#1-how-browserstack-enables-camera-testing
    public static void addCameraImageInject(String imagePath) {
        //   String mediaId = BrowserstackApi.uploadImage(imagePath);

//        AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();
//        String script = String.format("browserstack_executor: " +
//                "{\"action\":\"cameraImageInjection\", " +
        //             "\"arguments\": {\"imageUrl\" : \"%s\"}}", mediaId);
        //   driver.executeScript(script);
    }
//    public void swipeUp(WebElement webElement) {
//        AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();
//
//        Dimension dimension = driver.manage().window().getSize();
//        Point point = webElement.getLocation();
//   //     Dimension dimension = webElement.getSize();
//        Point start = new Point(point.getX(), point.getY() + dimension.getHeight() - 1);
//        Point end = new Point(point.getX(), point.getY());
//        W3cActions.doSwipe(start, end);
//
//    }
    @Step("Свайп справа налево")
    public static void swipeFromRightToLeft() {
        AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();

        Dimension dimension = driver.manage().window().getSize();
        Point start = new Point((int) (dimension.width * 0.9), (int) (dimension.height * 0.9));
        Point end = new Point((int) (dimension.width * 0.2), (int) (dimension.height * 0.1));
        W3cActions.doSwipe(driver, start, end, 100);  //with duration 1s
    }

    @Step("Свайп слева направо")
    public static void swipeFromLeftToRight() {
        AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();

        Dimension dimension = driver.manage().window().getSize();
        Point start = new Point((int) (dimension.width * 0.2), (int) (dimension.height * 0.2));
        Point end = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.8));
        W3cActions.doSwipe(driver, start, end, 1000); //with duration 1s
    }

    @Step("Долгое нажатие в центр экрана")
    public static void longTap() {
        AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();
        Dimension dimension = driver.manage().window().getSize();
        Point center = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.5));
        W3cActions.doTap(driver, center, 4000);
    }

    @Step("Нажатие в правой части экрана")
    public static void rightTap() {
        AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();
        Dimension dimension = driver.manage().window().getSize();
        Point center = new Point((int) (dimension.width * 0.8), (int) (dimension.height * 0.5));
        W3cActions.doTap(driver, center, 0);
    }

    @Step("Нажатие в левой части экрана")
    public static void leftTap() {
        AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();
        Dimension dimension = driver.manage().window().getSize();
        Point center = new Point((int) (dimension.width * 0.2), (int) (dimension.height * 0.5));
        W3cActions.doTap(driver, center, 0);
    }

    @Step("Нажатие на рейтинге 5")
    public static void tapByCoordinates(int x, int y) {
        AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();
        Point center = new Point(x, y);
        W3cActions.doTap(driver, center, 0);
    }

    public static void swipeUp(int timeOfSwipeMs) {
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

    public static void swipeUpQuick(int i) {
        swipeUp(2000);
    }

}
