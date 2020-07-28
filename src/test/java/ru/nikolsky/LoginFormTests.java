package ru.nikolsky;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import ru.nikolsky.pages.LoginForm;
import ru.nikolsky.pages.Profile;

public class LoginFormTests extends BaseTest {
    LoginForm form = new LoginForm();
    Profile profile = new Profile();

    private String login = "tester";
    private String password = "K35G3U";

    @Test(description = "Checking login with correct credential")
    public void successLogin() {
        form
                .setLogin(login)
                .setPassword(password)
                .enter();

        profile.hasUserName("Catswill J. J.");
    }

    @Test(description = "Checking warn message if user try to login with bad user name")
    public void badLogin() {
        form
                .setLogin(RandomStringUtils.random(10))
                .setPassword(password)
                .enter();

        form.hasMessageAboutBadLoginOrPassword();
    }

    @Test(description = "Checking warn message if user try to login with bad password")
    public void badPassword() {
        form
                .setLogin(login)
                .setPassword(RandomStringUtils.random(10))
                .enter();

        form.hasMessageAboutBadLoginOrPassword();
    }

    @Test(description = "All fields must be required")
    public void loginAndPasswordFields() {
        form.rememberMe()
                .hasRequiredAttributeInLoginField()
                .hasRequiredAttributeInPasswordField();
    }

}
