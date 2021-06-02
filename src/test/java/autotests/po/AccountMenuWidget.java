package autotests.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AccountMenuWidget {
    SelenideElement seTopItem = $("span[data-testid]");
    SelenideElement seSubMenuLogout = $("button[data-testid='user-widget-dropdown-logout']");

    @Step("Verify User Nickname `{nick} with actual.`")
    public void verifyNickName(String nick) {
        seTopItem.shouldHave(text(nick));
    }

    public void logOut() {
        seTopItem.parent().click();
        seSubMenuLogout.click();
    }
}
