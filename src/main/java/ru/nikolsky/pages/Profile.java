package ru.nikolsky.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Profile {
    private SelenideElement startSelector = $(".profile-button");

    public Profile hasUserName(String userName) {
        startSelector.$("#userName").shouldHave(Condition.text(userName));
        return this;
    }


}
