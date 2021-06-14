package autotests.po.widgets;


import autotests.po.pages.BasePage;
import autotests.po.pages.Login;
import autotests.po.pages.Premium;
import autotests.po.pages.Signup;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Top extends BasePage {
    SelenideElement sePremium = $("a[data-ga-action='premium']");
    SelenideElement seSignup = $("a[data-ga-action='sign-up']");
    SelenideElement seBtnLogIn = $("li a[data-ga-action='log-in']");

    @Step("Go to premium plans page")
    public Premium premium() {
        sePremium.click();
        return new Premium();
    }

    @Step("Go to Sign up page")
    public Signup signUp() {
        seSignup.click();
        return new Signup();
    }

    @Step("Navigate to Login Page")
    public Login doLogin() {
        seBtnLogIn.click();
        return new Login();
    }

}
