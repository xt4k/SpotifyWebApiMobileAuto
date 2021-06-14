package autotests.tests.web;

import autotests.annotations.JiraIssue;
import autotests.annotations.JiraIssues;
import autotests.annotations.Layer;
import autotests.annotations.TM4J;
import autotests.config.testdata.TestData;
import autotests.po.widgets.AccountMenu;
import autotests.po.widgets.Top;
import autotests.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Feature("Web tests")
@Story("Login tests")
@Owner("xt4k")
@Tags({@Tag("web"), @Tag("spotify_testsuite")})
@Layer("Web")
@JiraIssues({@JiraIssue("AUTO-226")})
@DisplayName("Testset for web UI login.")
public class LoginTests extends TestBase {

    @Tag("login")
    @Test
    @TM4J("2949")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @DisplayName("Test 13. UI: Successful login spotify as free plan user")
    void loginTest() {
        po.openHome();
        new Top().doLogin()
                .setLogin(TestData.getUserLogin())
                .setPass(TestData.getUserPassword())
                .login()
                .insertCookie();

        new AccountMenu().verifyNickName(TestData.getUserNickName());
    }
}
