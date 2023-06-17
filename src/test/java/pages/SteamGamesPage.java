package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class SteamGamesPage {
    private final SelenideElement
            openShop = $x("//a[contains(text(),'STORE')]"),
            openCategories = $x("//div[@id='genre_tab']//span[@class='pulldown']"),
            openSectionSurvivalGames = $x("//a[contains(text(),'Survival')]"),
            successSurvivalGames = $x("//div[text()='Survival']"),
            setSearch = $x("//*[@id='store_nav_search_term']"),
            buttonSearch = $x("//*[@id='store_search_link']/img"),
            searchJob = $x("//span[contains(text(),'Cuphead')]");
    public SteamGamesPage openShop() {
        step("Открыть 'Магазин'", () -> {
            openShop.click();
        });
        return this;
    }
    public SteamGamesPage openCategories() {
        step("Открыть раздел Категории", () -> {
            openCategories.click();
        });
        return this;
    }
    public SteamGamesPage openSectionSurvivalGames() {
        step("Открыть раздел игр 'Выживание'", () -> {
            openSectionSurvivalGames.click();
        });
        return this;
    }
    public SteamGamesPage successSurvivalGames() {
        step("Проверка открытия раздела игр 'Выживание'", () -> {
            successSurvivalGames.shouldHave(visible.because("Раздел игр 'Выживание' не открыт"));
        });
        return this;
    }
    public SteamGamesPage setSearch() {
        step("Ввести в поиск 'Cuphead'", () -> {
            setSearch.setValue("Cuphead");
        });
        return this;
    }
    public SteamGamesPage clickSearch() {
        step("Нажать на кнопку 'Найти'", () -> {
            buttonSearch.click();
        });
        return this;
    }
    public SteamGamesPage successSearchJob() {
        step("Проверка кнопки поиска", () -> {
            searchJob.shouldHave(visible.because("Поиск не работает, игра не найдена"));
        });
        return this;
    }
}