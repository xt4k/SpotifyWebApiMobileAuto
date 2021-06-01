package autotests.tests.mobile.android;

import autotests.config.web.TestData;
import autotests.drivers.MobileDriver;
import autotests.tests.TestBase;
import io.appium.java_client.MobileBy;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static autotests.drivers.DriverHelper.getSessionId;
import static autotests.helpers.AttachmentsHelper.*;
import static autotests.helpers.BrowserstackHelper.getBSPublicLink;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;

;

@Feature("Mobile tests")
@Story("Android")
@Tag("mobile")
@Owner("xt4k")
public class AppiumAndroidTests extends TestBase {

    @BeforeAll
    public static void setUp() {
        step("mobile");
        addListener("AllureSelenide", new AllureSelenide());
        browser = MobileDriver.class.getName();
        startMaximized = false;
        browserSize = null;
        timeout = 12000;
        // open();
    }

    @BeforeEach
    void openUp() {
        open();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browserstack build link", getBSPublicLink(sessionId));

        closeWebDriver();
        attachBsVideo(sessionId);
    }

    @Test
    @DisplayName("Search band in mobile application `Spotify`.")
    @TM4J("XT-MAP-1")
    @JiraIssues({@JiraIssue("AUTO-201")})
    void searchBand() {
        step("Open application", () -> $(AccessibilityId("Spotify")).click());

        step("Search band", () -> {
            $(MobileBy.id("com.spotify.music:id/search_tab")).click();
            $(MobileBy.id("com.spotify.music:id/background")).click();
            $(MobileBy.id("com.spotify.music:id/query")).sendKeys(TestData.getMusicBand());
            back();

        });
        step("Check if band is found", () -> {
            $$(MobileBy.id("com.spotify.music:id/card_title"))
                    .shouldHave(sizeGreaterThan(0))
                    .filter(text(TestData.getMusicBand())).shouldHave(sizeGreaterThan(0));
        });

        step("Check for any song", () -> {
            $$(MobileBy.id("android:id/text2"))
                    .filter(text(TestData.getMusicBandProduct())).shouldHave(sizeGreaterThan(0));
        });

        step("Check if famous song is found", () -> {
            $$(MobileBy.id("android:id/text1"))
                    .filter(text(TestData.getMusicBandComposition())).shouldHave(sizeGreaterThan(0));
        });

        step("Close Spotify application", () -> {
            back();
            back();
            back();
            back();
        });
    }

    @Test
    @DisplayName("Search composition in mobile application `Spotify`.")
    @TM4J("XT-MAP-2")
    @JiraIssues({@JiraIssue("AUTO-203")})
    void searchComposition() {
        step("Open application", () -> $(AccessibilityId("Spotify")).click());

        step("Search composition", () -> {
            $(MobileBy.id("com.spotify.music:id/search_tab")).click();
            $(MobileBy.id("com.spotify.music:id/background")).click();
            $(MobileBy.id("com.spotify.music:id/query")).sendKeys(TestData.getSoundComposition());
            back();
        });

        step("Check if composition is found", () -> {
            $$(MobileBy.id("android:id/text1"))
                    .shouldHave(sizeGreaterThan(0))
                    .filter(text(TestData.getSoundComposition())).shouldHave(sizeGreaterThan(0));
        });

        step("Check for song author.", () -> {
            $$(MobileBy.id("android:id/text2"))
                    .filter(text(TestData.getSoundCompositionBand())).shouldHave(sizeGreaterThan(0));
        });

        step("Close Spotify application", () -> {
            back();
            back();
            back();
            back();
        });
    }


    @Test
    @DisplayName("Check profile info.")
    @TM4J("XT-MAP-2")
    @JiraIssues({@JiraIssue("AUTO-203")})
    void verifyMyInfo() {
        step("Open application", () -> $(AccessibilityId("Spotify")).click());

        step("Navigate to profile", () -> {
            $(MobileBy.id("com.spotify.music:id/home_tab")).click();
            $(MobileBy.id("com.spotify.music:id/home_toolbar_settings")).click();
        });

        step("Check nickname", () -> {
            $(MobileBy.id("com.spotify.music:id/username"))
                    .shouldHave(text(TestData.getUserNickName()));
        });

        step("Navigate to email/password screen", () -> {
            $$(MobileBy.id("android:id/text1")).filterBy(text("Email")).first().click();
        });

        step("Check email info", () -> {
            $(MobileBy.id("com.spotify.music:id/email"))
                    .shouldHave(text(TestData.getUserLogin()));
        });

        step("Close Spotify application", () -> {
            back();
            back();
            back();
        });
    }


}