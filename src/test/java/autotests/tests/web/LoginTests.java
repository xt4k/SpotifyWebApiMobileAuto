package autotests.tests.web;


import autotests.config.web.TestData;
import autotests.po.AccountMenuWidget;
import autotests.po.TopWidget;
import autotests.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Web tests")
@Story("Login tests")
@Owner("xt4k")
public class LoginTests extends TestBase {

    @Test
    @Tag("web")
    @DisplayName("Test 01. Successful login spotify as Free Plan user")
    void loginTest() {
        po.openHome();
        new TopWidget().doLogin()
                .setLogin(TestData.getUserLogin())
                .setPass(TestData.getUserPassword())
                .login();
        new AccountMenuWidget().verifyNickName(TestData.getUserNickName());
    }
}
