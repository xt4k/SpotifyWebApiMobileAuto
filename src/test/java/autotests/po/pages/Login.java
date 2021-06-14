package autotests.po.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class Login extends BasePage {
    SelenideElement loginField = $("#login-username");
    SelenideElement passField = $("#login-password");
    SelenideElement seLogin = $("#login-button");

    @Step("Set Login field with {login}")
    public Login setLogin(String login) {
        setSeValue(loginField, login);
        return this;
    }

    @Step("Set Password field with ***")
    public Login setPass(String s) {
        setSeValue(passField, s);
        return this;
    }

    @Step("Login.")
    public Playlist login() {
        seLogin.click();
        sleep(1000);
        return new Playlist();
    }
}
