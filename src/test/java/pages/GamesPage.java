package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class GamesPage {
    private final SelenideElement
            openShop = $x("//a[contains(text(),'STORE')]"),
            openCategories = $x("//div[@id='genre_tab']//span[@class='pulldown']"),
            openSectionSurvivalGames = $x("//a[contains(text(),'Survival')]"),
            successSurvivalGames = $x("//div[text()='Survival']"),
            setSearch = $x("//*[@id='store_nav_search_term']"),
            buttonSearch = $x("//*[@id='store_search_link']/img"),
            searchJob = $x("//span[contains(text(),'Cuphead')]");

    public GamesPage openShop() {
        step("Открыть 'Магазин'", () -> {
            openShop.click();
        });
        return this;
    }

    public GamesPage openCategories() {
        step("Открыть раздел Категории", () -> {
            openCategories.click();
        });
        return this;
    }

    public GamesPage openSectionSurvivalGames() {
        step("Открыть раздел игр 'Выживание'", () -> {
            openSectionSurvivalGames.click();
        });
        return this;
    }

    public GamesPage successSurvivalGames() {
        step("Проверка открытия раздела игр 'Выживание'", () -> {
            successSurvivalGames.shouldHave(visible.because("Раздел игр 'Выживание' не открыт"));
        });
        return this;
    }

    public GamesPage setSearch() {
        step("Ввести в поиск 'Cuphead'", () -> {
            setSearch.setValue("Cuphead");
        });
        return this;
    }

    public GamesPage clickSearch() {
        step("Нажать на кнопку 'Найти'", () -> {
            buttonSearch.click();
        });
        return this;
    }

    public GamesPage successSearchJob() {
        step("Проверка кнопки поиска", () -> {
            searchJob.shouldHave(visible.because("Поиск не работает, игра не найдена"));
        });
        return this;
    }
}