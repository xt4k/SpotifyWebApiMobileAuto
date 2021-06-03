package autotests.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static autotests.helpers.AttachmentsHelper.attachScreenshot;
import static com.codeborne.selenide.Selenide.$;

public class TopWidget extends BasePageObject {
    SelenideElement sePremium = $("a[data-ga-action='premium']");
    SelenideElement seSignup = $("a[data-ga-action='sign-up']");
    SelenideElement seBtnLogIn = $("li a[data-ga-action='log-in']");

    @Step("Go to premium plans page")
    public PremiumPage premium() {
        sePremium.click();
        return new PremiumPage();
    }

    @Step("Go to Sign up page")
    public SignupPage signUp() {
        seSignup.click();
        return new SignupPage();
    }

    @Step("Navigate to Login Page")
    public LoginPage doLogin() {
        seBtnLogIn.click();
       // attachScreenshot("navigated");
        return new LoginPage();
    }

}
