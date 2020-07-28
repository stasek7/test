package ru.nikolsky;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeClass
    public void beforeClass() {
        SelenideLogger.addListener("Allure", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.fastSetValue = true;
        Configuration.timeout = 10000;
    }

    @BeforeMethod
    public void beforeTest() {
        open("https://gdcloud.ru/release-17/auth/login");
    }

    @AfterMethod
    public void afterTest() {
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }
}
