package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class SteamCommunityPage {
    private final SelenideElement
            openCommunity = $x("//a[contains(text(),'COMMUNITY')]"),
            successActiveCommunity = $x(" //div[@class='community_home_title']");
    public SteamCommunityPage openCommunity() {
        step("Открыть раздел 'Сообщество'", () -> {
            openCommunity.click();
        });
        return this;
    }
    public SteamCommunityPage successActiveCommunity() {
        step("Проверка наличия рекомендаций в сообществе", () -> {
            successActiveCommunity.shouldHave(visible.because("Раздел 'Активность сообщества' не открыт"));
        });
        return this;
    }
}