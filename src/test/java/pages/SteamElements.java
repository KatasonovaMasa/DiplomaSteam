package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SteamElements {
    private final SelenideElement openShop = $x("//a[contains(text(),'STORE')]");
    private final SelenideElement in = $x("//a[text()='login']");
    private final SelenideElement login = $x("//*[contains(@class,'newlogindialog_TextField')]//input[@type='text']");
    private final SelenideElement password = $x("//*[contains(@class,'newlogindialog_TextField')]//input[@type='password']");
    private final SelenideElement sigIn = $x("//button[text()='Sign in']");
    private final SelenideElement openSectionSurvivalGames = $x("//a[contains(text(),'Survival')]");
    private final SelenideElement successSurvivalGames = $x("//div[text()='Survival']");
    private final SelenideElement openCommunity = $x("//a[contains(text(),'COMMUNITY')]");
    private final SelenideElement checkActiveCommunity = $x(" //div[@class='community_home_title']");
    private final SelenideElement checkActiveReference = $x("//*//*//div[text()='Recommended']");
    private final SelenideElement addGameToCart = $x("//div//*[(text()='Buy Cuphead')]/..//a[1]");
    private final SelenideElement successBasket = $x("//div//*[text()='Your Shopping Cart']");
    private final SelenideElement deleteGameCart = $x("//a[contains(text(),'Remove')]");
    private final SelenideElement successCartEmpty = $x("//div[@id='cart_estimated_total_text']");
    private final SelenideElement setSearch = $x("//*[@id='store_nav_search_term']");
    private final SelenideElement buttonSearch = $x("//*[@id='store_search_link']/img");
    private final SelenideElement searchJob = $x("//span[contains(text(),'Cuphead')]");
    private final SelenideElement openGames = $x("//span[text()='Cuphead']");
    private final SelenideElement account = $x("//*[@id='account_pulldown']");
    private final SelenideElement openCategories = $x("//div[@id='genre_tab']//span[@class='pulldown']");
    private final SelenideElement successBasketGame = $x("//div[@class='cart_status_message']");
    private final SelenideElement languageSelection = $x("//*[@id='language_pulldown']");
    private final SelenideElement english = $x("//a[contains(text(),'English (английский)')]");
    private final SelenideElement logout = $x("//a[@href='javascript:Logout();']");

    private final SelenideElement opensSteamWorks = $x("//a[text()='Steamworks']");
    public SelenideElement openSteamWorks() {
        return opensSteamWorks;
    }
    private final SelenideElement successOpenSteamWorks = $x("//html/head/title");
    public SelenideElement successOpenSteamWorks(){
        return successOpenSteamWorks;
    }

    public SelenideElement logout(){
        return logout;
    }
    public SelenideElement account(){
        return account;
    }
    public SelenideElement getOpenShop(){
        return openShop;
    }
    public SelenideElement in(){
        return in;
    }
    public SelenideElement sigIn(){
        return sigIn;
    }
    public SelenideElement login(){
        return login;
    }
    public SelenideElement password(){
        return password;
    }
    public SelenideElement getOpenCategories(){
        return openCategories;
    }
    public SelenideElement getOpenSectionSurvivalGames(){
        return openSectionSurvivalGames;
    }
    public SelenideElement getOpenCommunity(){ return openCommunity; }
    public SelenideElement getSuccessSurvivalGames(){ return successSurvivalGames; }
    public SelenideElement getCheckActiveCommunity(){
        return checkActiveCommunity;
    }
    public SelenideElement getCheckActiveReference(){
        return checkActiveReference;
    }
    public SelenideElement getOpenGames(){return openGames;}
    public SelenideElement getAddGameToCart(){return addGameToCart;}
    public SelenideElement setSearch(){ return setSearch; }
    public SelenideElement getButtonSearch(){ return buttonSearch; }
    public SelenideElement getSearchJob(){
        return searchJob;
    }
    public SelenideElement getSuccessBasket(){
        return successBasket;
    }
    public SelenideElement getSuccessBasketGame(){
        return successBasketGame;
    }
    public SelenideElement getDeleteGameCart(){
        return deleteGameCart;
    }
    public SelenideElement getSuccessCartEmpty(){
        return successCartEmpty;
    }
    public SelenideElement getLanguageSelection(){
        return languageSelection;
    }
    public SelenideElement getEnglish(){
        return english;
    }
}