package autotests.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static autotests.helpers.AttachmentsHelper.attachScreenshot;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class LoginPage extends BasePageObject {
    SelenideElement loginField = $("#login-username");
    SelenideElement passField = $("#login-password");
    SelenideElement seLogin = $("#login-button");

    @Step("Set Login field with {login}")
    public LoginPage setLogin(String login) {
        setSeValue(loginField, login);
        return this;
    }

    @Step("Set Password field with ***")
    public LoginPage setPass(String s) {
        setSeValue(passField, s);
        return this;
    }

    @Step("Login.")
    public PlaylistPage login() {
       // attachScreenshot("before log in");
        seLogin.click();
        sleep(1000);
        //attachScreenshot("logged in");
        return new PlaylistPage();
    }
}
