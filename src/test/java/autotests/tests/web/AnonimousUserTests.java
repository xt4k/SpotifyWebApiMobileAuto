package autotests.tests.web;

import autotests.annotations.JiraIssue;
import autotests.annotations.JiraIssues;
import autotests.annotations.Layer;
import autotests.annotations.TM4J;
import autotests.config.testdata.TestData;
import autotests.po.pages.BasePage;
import autotests.po.widgets.Top;
import autotests.tests.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;

@Feature("Web tests")
@Story("Anonymous User tests")
@Tags({@Tag("web"), @Tag("spotify_testsuite")})
@Owner("xt4k")
@JiraIssues({@JiraIssue("AUTO-226")})
@DisplayName("Testset for web UI tests by anonymous user.")
@Layer("Web")
public class AnonimousUserTests extends TestBase {

    @Test
    @TM4J("2943")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Description("Test 05. UI: Check Premium Plans")
    void verifyPlansInfo() {
        new BasePage().openHome();
        new Top().premium()
                .goPlansDetails()
                .verifyPlansInfo();
    }

    @Tag("download")
    @Test
    @JiraIssues({@JiraIssue("AUTO-226")})
    @TM4J("2944")
    @Description("Test 06. UI: Verify Download Windows Application button")
    void verifyDownloadWinButton() {
        step("Open Homepage", () -> open(baseUrl + "download/windows"));

        step("Setup cookie", () -> {
            getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", now().format(ofPattern("yyyy-MM-dd"))));
            refresh();
        });

        step("'Download to PC' elements has expected title.", () -> {
            $("button[data-testid='download-cta']").shouldHave(text("Download"));
            $("h1").shouldHave(text("Download Spotify"))
                    .sibling(0)
                    .shouldHave(text("Play millions of songs on your device."));
        });
    }

    @Tag("download")
    @Test
    @TM4J("2946")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Description("Test 07. UI: Verify Download Apple Application button")
    void verifyDownloadAppleButton() {
        step("Open Homepage", () -> open(baseUrl + "download/windows"));

        step("Setup cookie", () -> {
            getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", now().format(ofPattern("yyyy-MM-dd"))));
            refresh();
        });

        step("'Download on the Apple' elements has expected title.", () -> {
            $$("a img").first()
                    .shouldHave(attribute("alt", "Download on the App Store"))
                    .shouldHave(attribute("src", "https://www-growth.scdn.co/static/badges/apple/en.png"))
                    .parent()
                    .shouldHave(attribute("data-testid", "apple-store-badge"))
                    .parent()
                    .preceding(0).shouldHave(text("Listening on your phone or tablet is free, easy, and fun."))
                    .preceding(0).shouldHave(text("Bring your music to mobile and tablet, too."));
        });
    }

    @Tag("download")
    @Test
    @JiraIssues({@JiraIssue("AUTO-226")})
    @TM4J("2945")
    @Description("Test 08. UI: Verify 'GET IT ON Google Play' button.")
    void verifyDownloadGoogleButton() {
        step("Open Homepage", () -> open(baseUrl + "download/windows"));

        step("Setup cookie", () -> {
            getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", now().format(ofPattern("yyyy-MM-dd"))));
            refresh();
        });

        step("'GET IT ON Google Play' button has expected title.", () -> {
            $$("a img").get(1).shouldHave(attribute("alt", "Get it on Google Play"))
                    .shouldHave(attribute("src", "https://www-growth.scdn.co/static/badges/google/en.png"))
                    .parent()
                    .shouldHave(attribute("data-testid", "google-store-badge"));
        });
    }

    @Tags({@Tag("failed"), @Tag("advertisement")})
    @Test
    @TM4J("4444")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Description("Test 09. UI: Check Extended Premium Period Conditions.")
    void verifyExtendedPremiumConditionInfoMistaken() {
        step("Open Homepage", () -> open(baseUrl));
        step("Navigate to premium page", () -> $("a[data-ga-action='premium']").click());
        step("Check Advertisement label about preferential free period.", () ->
                $("div>h1").shouldHave(text(TestData.getPreferentialPeriodWrong())));
    }

    @Tags({@Tag("passed"), @Tag("advertisement")})
    @Test
    @TM4J("4455")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Description("Test 10. UI: Check Extended Premium Period Conditions.")
    void verifyExtendedPremiumConditionInfo() {
        step("Open Homepage", () -> open(baseUrl));
        step("Navigate to premium page", () -> $("a[data-ga-action='premium']").click());
        step("Check Advertisement label about preferential free period.", () ->
                $("div>h1").shouldHave(text(TestData.getPreferentialPeriod())));
    }
}
