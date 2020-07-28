package ru.nikolsky.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginForm {
    private SelenideElement startSelector = $(".login");

    public LoginForm setLogin(String login) {
        startSelector.$("#username").setValue(login);
        return this;
    }

    public LoginForm setPassword(String password) {
        startSelector.$("#password").setValue(password);
        return this;
    }

    public LoginForm rememberMe() {
        startSelector.$("#remember").click();
        return this;
    }

    public LoginForm enter() {
        startSelector.$("#login_button").click();
        return this;
    }

    public LoginForm enterWithOtherLogin() {
        startSelector.$("#login_button_domain").click();
        return this;
    }

    public LoginForm enterWithCurrentLogin() {
        startSelector.$("#login_button_current").click();
        return this;
    }

    public LoginForm hasMessageAboutBadLoginOrPassword() {
        startSelector.$("#error").shouldHave(Condition.text("Неверное имя пользователя или пароль"));
        return this;
    }

    public LoginForm hasRequiredAttributeInLoginField() {
        startSelector.$("#username").shouldHave(Condition.attribute("required"));
        return this;
    }

    public LoginForm hasRequiredAttributeInPasswordField() {
        startSelector.$("#password").shouldHave(Condition.attribute("required"));
        return this;
    }
}
