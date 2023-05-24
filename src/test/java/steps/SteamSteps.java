package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.AuthorizationConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import pages.SteamElements;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;


public class SteamSteps {
    SteamElements steamelements = new SteamElements();
    static AuthorizationConfig config = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());

    @Step("Открытие сайта")
    public void openSteam(){
        Selenide.open("/?l=russian");
        steamelements.getLanguageSelection().click();
        steamelements.getEnglish().click();
    }

    @Step("Авторизация")
    public void openAvtorization(){
        steamelements.in().click();
        steamelements.login().setValue(config.login());
        steamelements.password().setValue(config.password());
        steamelements.sigIn().click();
        sleep(6000);
    }
    @Step("Открыть 'Магазин'")
    public void openShop() {
        steamelements.getOpenShop().click();
    }

    @Step("Открыть раздел Категории")
    public void openCategories() {
        steamelements.getOpenCategories().click();
    }

    @Step("Открыть раздел игр 'Выживание'")
    public void openSectionSurvivalGames() {
        steamelements.getOpenSectionSurvivalGames().click();
    }

    @Step("Проверка открытия раздела игр 'Выживание'")
    public void successSurvivalGames() {
        steamelements.getSuccessSurvivalGames().shouldHave(visible.because("Раздел игр 'Выживание' не открыт"));
    }

    @Step("Открыть раздел 'Сообщество'")
    public void openCommunity() {
        steamelements.getOpenCommunity().click();
    }
    @Step("Проверка наличия рекомендаций в сообществе")
    public void successActiveCommunity() {
        steamelements.getCheckActiveCommunity().shouldHave(visible.because("Раздел 'Активность сообщества' не открыт"));
    }

    @Step("Открыть раздел SteamWorks")
    public void openSteamWorks() {
        steamelements.openSteamWorks().scrollTo().click();
    }

    @Step("Проверка открытия SteamWorks")
    public void successOpenSteamWorks() {
        switchTo().window(1);
        steamelements.successOpenSteamWorks().shouldHave(hidden.because("Раздел SteamWorks не открыт"));
        switchTo().window(0);
    }

    @Step("Открыть раздел Jobs")
    public void openJobsSteam() {
        steamelements.openJobs().scrollTo().click();
    }
    @Step("Проверка открытия SteamWorks")
    public void successJobsSoftwareEngineering() {
        switchTo().window(1);
        steamelements.openSoftwareEngineering().click();
        steamelements.successJobsSoftwareEngineering().shouldHave(hidden.because("Работы Software Engineering в Steam нет"));
        switchTo().window(0);
    }


    @Step("Ввести в поиск 'Cuphead'")
    public void setSearch() {
        steamelements.setSearch().setValue("Cuphead");
    }
    @Step("Нажать на кнопку 'Найти'")
    public void clickSearch() {
        steamelements.getButtonSearch().click();
    }
    @Step("Проверка кнопки поиска")
    public void successSearchJob() {
        steamelements.getSearchJob().shouldHave(visible.because("Поиск не работает, игра не найдена"));
    }
    @Step("Открыть игру")
    public void openGames() {
        steamelements.setSearch().setValue("Cuphead").pressEnter();
        steamelements.getOpenGames().click();
    }
    @Step("Добавить игру в корзину")
    public void addGameToCart() {
        steamelements.getAddGameToCart().click();
    }
    @Step("Проверка наличие игры в корзине")
    public void successBasketGame() {
        steamelements.getSuccessBasket().shouldHave(visible.because("Корзина не открыта"));
        steamelements.getSuccessBasketGame().shouldHave(visible.because("Игра не добавлена в корзину"));
    }
    @Step("Добавить игру в корзину")
    public void addGameCart(){
        steamelements.setSearch().setValue("Cuphead").pressEnter();
        steamelements.getOpenGames().click();
        steamelements.getAddGameToCart().click();
    }
    @Step("Удалить игру из корзину")
    public void deleteGameCart(){
        steamelements.getDeleteGameCart().click();
    }
    @Step("Убедиться, что корзина пуста")
    public void successCartEmpty(){
        steamelements.getSuccessCartEmpty().shouldHave(visible.because("Корзина не пуста"));
    }
    @Step("Выход из учетки")
    public void logout(){
        steamelements.account().click();
        steamelements.logout().click();
    }
}