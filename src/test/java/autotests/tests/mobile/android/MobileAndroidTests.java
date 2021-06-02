package autotests.tests.mobile.android;

import autotests.config.testdata.TestData;
import io.appium.java_client.MobileBy;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static autotests.helpers.AttachmentsHelper.attachScreenshot;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;

@Feature("Mobile tests")
@Story("Android platform")
@Tags({@Tag("mobile"), @Tag("live")})
@DisplayName("Testset for 'live' mobile and phone emulator on Android platform tests.")
@Owner("xt4k")
@Layer("Mobile")
@JiraIssues({@JiraIssue("AUTO-226")})
public class MobileAndroidTests extends MobileTestBase {

    @Test
    @DisplayName("Test 13. Mobile: Search band in mobile application.")
    @TM4J("SX-M1")
    @JiraIssues({@JiraIssue("AUTO-226")})
    void searchBand() {
        step("Open application", () -> {
            $(AccessibilityId("Spotify")).click();
        });

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
            attachScreenshot("Check found elements");
        });

        step("Close Spotify application", () -> {
            back();
            back();
            back();
            back();
        });
    }

    @Test
    @DisplayName("Test 14. Mobile: Search composition in mobile application.")
    @TM4J("SX-M2")
    @JiraIssues({@JiraIssue("AUTO-226")})
    void searchComposition() {
        step("Open application", () -> {
            $(AccessibilityId("Spotify")).click();
        });

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
            attachScreenshot("Check found elements");
        });

        step("Close Spotify application", () -> {
            back();
            back();
            back();
            back();
        });
    }

    @Test
    @DisplayName("Test 15. Mobile: Check personal profile info.")
    @TM4J("SX-M3")
    @JiraIssues({@JiraIssue("AUTO-226")})
    void verifyMyInfo() {
        step("Open application", () -> {
            $(AccessibilityId("Spotify")).click();
        });

        step("Navigate to profile", () -> {
            $(MobileBy.id("com.spotify.music:id/home_tab")).click();
            $(MobileBy.id("com.spotify.music:id/home_toolbar_settings")).click();
        });

        step("Check nickname", () -> {
            $(MobileBy.id("com.spotify.music:id/username"))
                    .shouldHave(text(TestData.getUserNickName()));
            attachScreenshot("Check nickname");
        });

        step("Navigate to email/password screen", () -> {
            $$(MobileBy.id("android:id/text1")).filterBy(text("Email")).first().click();
        });

        step("Check email info", () -> {
            $(MobileBy.id("com.spotify.music:id/email"))
                    .shouldHave(text(TestData.getUserLogin()));
            attachScreenshot("Check email");
        });

        step("Close Spotify application", () -> {
            back();
            back();
            back();
        });
    }
}