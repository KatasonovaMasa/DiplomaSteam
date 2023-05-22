package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import pages.SteamElements;

import static com.codeborne.selenide.Condition.visible;

public class SteamSteps {
    SteamElements steamelements = new SteamElements();

    @Step("Открытие сайта")
    public void openSteam(){
        Selenide.open("/?l=russian");
        steamelements.getLanguageSelection().click();
        steamelements.getEnglish().click();
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
        steamelements.getCheckActiveReference().shouldHave(visible.because("Рекомендаций в сообществе нет"));
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
}