package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class SteamIntegrationPage {
    private final SelenideElement
            opensSteamWorks = $x("//a[text()='Steamworks']"),
            successOpenSteamWorks = $x("//span[text()='Присоединиться к Steamworks']"),
            openJobs = $x("//a[text()='Jobs']"),
            successJobsSoftwareEngineering = $x("//h5[normalize-space()='Steam Software Engineer']"),
            openSoftwareEngineering = $x("//a[text()='Software Engineering']");
    public SteamIntegrationPage openSteamWorks() {
        step("Открыть раздел SteamWorks", () -> {
            opensSteamWorks.scrollTo().click();
        });
        return this;
    }
    public SteamIntegrationPage successOpenSteamWorks() {
        step("Проверка открытия SteamWorks", () -> {
            successOpenSteamWorks.shouldHave(hidden.because("Раздел SteamWorks не открыт"));
        });
        return this;
    }
    public SteamIntegrationPage openJobsSteam() {
        step("Открыть раздел Jobs", () -> {
            openJobs.scrollTo().click();
        });
        return this;
    }
    public SteamIntegrationPage successJobsSoftwareEngineering() {
        step("Проверка открытия SteamWorks", () -> {
            switchTo().window(1);
            openSoftwareEngineering.click();
            successJobsSoftwareEngineering.shouldHave(visible.because("Работы Software Engineering в Steam нет"));
            switchTo().window(0);
        });
        return this;
    }
}