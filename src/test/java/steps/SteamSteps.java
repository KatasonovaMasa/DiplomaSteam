package steps;

import com.codeborne.selenide.Selenide;
import config.AuthorizationConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import pages.SteamBasketPage;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SteamSteps {
    SteamBasketPage steamelements = new SteamBasketPage();
    static AuthorizationConfig config = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());



//    @Step("Открыть раздел SteamWorks")
//    public void openSteamWorks() {
//        steamelements.openSteamWorks().scrollTo().click();
//    }
//
//    @Step("Проверка открытия SteamWorks")
//    public void successOpenSteamWorks() {
//        switchTo().window(1);
//        steamelements.successOpenSteamWorks().shouldHave(hidden.because("Раздел SteamWorks не открыт"));
//        switchTo().window(0);
//    }
//
//    @Step("Открыть раздел Jobs")
//    public void openJobsSteam() {
//        steamelements.openJobs().scrollTo().click();
//    }
//    @Step("Проверка открытия SteamWorks")
//    public void successJobsSoftwareEngineering() {
//        switchTo().window(1);
//        steamelements.openSoftwareEngineering().click();
//        steamelements.successJobsSoftwareEngineering().shouldHave(visible.because("Работы Software Engineering в Steam нет"));
//        switchTo().window(0);
//    }


//    @Step("Ввести в поиск 'Cuphead'")
//    public void setSearch() {
//        steamelements.setSearch().setValue("Cuphead");
//    }
//    @Step("Нажать на кнопку 'Найти'")
//    public void clickSearch() {
//        steamelements.getButtonSearch().click();
//    }
//    @Step("Проверка кнопки поиска")
//    public void successSearchJob() {
//        steamelements.getSearchJob().shouldHave(visible.because("Поиск не работает, игра не найдена"));
//    }
//    @Step("Открыть игру")
//    public void openGames() {
//        steamelements.setSearch().setValue("Cuphead").pressEnter();
//        steamelements.getOpenGames().click();
//    }
//    @Step("Добавить игру в корзину")
//    public void addGameToCart() {
//        steamelements.getAddGameToCart().click();
//    }
//    @Step("Проверка наличие игры в корзине")
//    public void successBasketGame() {
//        steamelements.getSuccessBasket().shouldHave(visible.because("Корзина не открыта"));
//        steamelements.getSuccessBasketGame().shouldHave(visible.because("Игра не добавлена в корзину"));
//    }
//    @Step("Добавить игру в корзину")
//    public void addGameCart(){
//        steamelements.setSearch().setValue("Cuphead").pressEnter();
//        steamelements.getOpenGames().click();
//        steamelements.getAddGameToCart().click();
//    }
//    @Step("Удалить игру из корзину")
//    public void deleteBasketGames(){
//        steamelements.getDeleteGameCart().click();
//    }
//    @Step("Убедиться, что корзина пуста")
//    public void successBasketEmpty(){
//        steamelements.getSuccessCartEmpty().shouldHave(visible.because("Корзина не пуста"));
//    }
//    @Step("Выход из учетки")
//    public void logout(){
//        steamelements.account().click();
//        steamelements.logout().click();
//    }
}