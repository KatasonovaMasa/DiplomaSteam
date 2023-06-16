package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class SteamBasketPage {
    private final SelenideElement
            search = $x("//*[@id='store_nav_search_term']"),
            openGames = $x("//span[text()='Cuphead']"),
            addGameToCart = $x("//div//*[(text()='Buy Cuphead')]/..//a[1]"),
            successBasket = $x("//div//*[text()='Your Shopping Cart']"),
            successBasketGame = $x("//div[@class='cart_status_message']"),
            deleteGameCart = $x("//a[contains(text(),'Remove')]"),
            successCartEmpty = $x("//div[@id='cart_estimated_total_text']");
    public SteamBasketPage openGames() {
        step("Открыть игру", () -> {
            search.setValue("Cuphead").pressEnter();
            openGames.click();
        });
        return this;
    }

    public SteamBasketPage addGameToCart() {
        step("Добавить игру в корзину", () -> {
            addGameToCart.click();
        });
        return this;
    }
    public SteamBasketPage successBasketGame() {
        step("Проверка наличие игры в корзине", () -> {
            successBasket.shouldHave(visible.because("Корзина не открыта"));
            successBasketGame.shouldHave(visible.because("Игра не добавлена в корзину"));
        });
        return this;
    }
    public SteamBasketPage deleteBasketGames() {
        step("Удалить игру из корзину", () -> {
            deleteGameCart.click();
        });
        return this;
    }
    public SteamBasketPage successBasketEmpty() {
        step("Убедиться, что корзина пуста", () -> {
            successCartEmpty.shouldHave(visible.because("Корзина не пуста"));
        });
        return this;
    }
}