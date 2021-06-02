package autotests.tests.web;


import autotests.config.testdata.TestData;
import autotests.po.AccountMenuWidget;
import autotests.po.CapchaWidget;
import autotests.po.SignupPage;
import autotests.po.TopWidget;
import autotests.tests.TestBase;
import autotests.utils.CommonOperations;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.SimpleDateFormat;

import static autotests.drivers.DriverHelper.getDriverConfig;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;

@Feature("SignUp tests.")
@Tags({@Tag("signup"), @Tag("spotify_testsuite")})
@Story("Login tests with CAPTCHA WORKAROUND")
@Owner("xt4k")
@JiraIssues({@JiraIssue("AUTO-226")})
@Layer("Web")
@DisplayName("Testset for web UI shown automatic registration process against captcha service.")
public class SignUpTests extends TestBase {
    CommonOperations co = new CommonOperations();

    @Tag("web")
    @Test
    @TM4J("SX-W8")
    @JiraIssues({@JiraIssue("AUTO-226")})
    //@LabelAnnotations({@LabelAnnotation("Automatic"),@LabelAnnotation("Microphone"),("Failed test")})
    @DisplayName("Test 12.1. UI: SignUp (lambda step, failed test)")
    void signUpSpotify() {
        Faker faker = new Faker();

        step("Open Homepage", () -> {
            open(Configuration.baseUrl);
        });

        step("Navigate to Sign up page", () -> {
            $("a[data-ga-action='sign-up']").click();
        });

        step("Insert Cookie", () -> {
            getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", now().format(ofPattern("yyyy-MM-dd"))));
            refresh();
        });

        step("Sign Up form fill", () -> {
            String email = faker.internet().emailAddress();

            $("#facebook-terms-conditions-checkbox").parent().click();
            co.randSleep();
            $("#email").setValue(email);
            co.randSleep();
            $("#confirm").setValue(email);
            co.randSleep();
            $("#password").setValue(faker.internet().password(10, 15));
            co.randSleep();
            $("#displayname").setValue(faker.superhero().name());
            co.randSleep();
            $("#day").setValue(new SimpleDateFormat("dd").format(faker.date().birthday()));
            co.randSleep();
            $("#month").click();
            co.randSleep();
            $("#month").sendKeys(new SimpleDateFormat("MMM").format(faker.date().birthday()));
            co.randSleep();
            $("#year").setValue(new SimpleDateFormat("yyyy").format(faker.date().birthday()));
            co.randSleep();
            $("#gender_option_nonbinary").parent().click();
            co.randSleep();
            $("#marketing-opt-checkbox").parent().click();
            co.randSleep();
            $("#third-party-checkbox").parent().click();
            co.randSleep();
            $("#terms-conditions-checkbox").parent().scrollTo().click();
            co.randSleep();
        });

        step("Captcha: 'Not a robot'", () -> {
            switchTo().innerFrame($("#v2-container [title='reCAPTCHA']").getAttribute("name"));
            $("#rc-anchor-container").click();
            co.randSleep();
        });

        step("Captcha: 'Hear audio'", () -> {
            switchTo().parentFrame();
            String frameName = $$("div [style] iframe").last().getAttribute("name");
            switchTo().innerFrame(frameName);
            $("#recaptcha-audio-button").click();
            co.randSleep();
        });

        step("Captcha: Start extra tab with speech recognition service, and start listen.", () -> {

            browser = getDriverConfig().webBrowser();
            browserVersion = getDriverConfig().webBrowserVersion();
            browserSize = getDriverConfig().webBrowserSize();

            DesiredCapabilities capabilities = new DesiredCapabilities();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--use-fake-ui-for-media-stream");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

            SelenideDriver tab2 = new SelenideDriver(new SelenideConfig().browserCapabilities(capabilities));
            tab2.open("https://translate.google.com.ua/?sl=en&tl=ru&op=translate");
            tab2.find("div[soy-server-key]>c-wiz button[aria-pressed='false']").click();

            step("Captcha service : Switch to Captcha popup tab and play sound", () -> {
                Selenide.$("button[aria-labelledby='audio-instructions rc-response-label']").click();
                sleep(10000);
            });

            step("Captcha service : get text and set it to capcha.", () -> {
                String secretWord = tab2.getCurrentFrameUrl();
                step("secret word is: " + secretWord);
                tab2.close();
                $("#audio-response").sendKeys(secretWord);
                $("#recaptcha-verify-button").click();
            });

        });

        step("Submit form.", () -> {
            $("button[type='submit']").click();
        });

        step("Verify if User Nickname equal to submitted.", () -> {
            $("span[data-testid]").shouldHave(text(faker.superhero().name()));
        });
    }

    @Tag("web")
    @Disabled
    @Test
    @TM4J("SX-W9")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @DisplayName("Test 12.2 UI: SignUp (step form - disabled test).")
    void signUpSpotifyNoLambda() {
        Faker faker = new Faker();

        po.openHome();
        new TopWidget().signUp()
                .fillSignUpForm(faker);
        new CapchaWidget().goThrough();
        new SignupPage().signup();
        new AccountMenuWidget().verifyNickName(TestData.getUserNickName());
    }

}
