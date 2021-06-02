package autotests.tests.web;


import autotests.config.testdata.TestData;
import autotests.po.AccountMenuWidget;
import autotests.po.TopWidget;
import autotests.tests.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Feature("Web tests")
@Story("Login tests")
@Owner("xt4k")
@Tags({@Tag("web"), @Tag("spotify_testsuite")})
@JiraIssues({@JiraIssue("XS-???")})
@Layer("Web")
@DisplayName("Testset for web UI login.")
public class LoginTests extends TestBase {

    @Tag("login")
    @Test
    @TM4J("SX-W7")
    @DisplayName("Test 11. UI: Successful login spotify as Free Plan user")
    void loginTest() {
        po.openHome();
        new TopWidget().doLogin()
                .setLogin(TestData.getUserLogin())
                .setPass(TestData.getUserPassword())
                .login()
                .insertCookie();

        new AccountMenuWidget().verifyNickName(TestData.getUserNickName());
    }
}
