package autotests.tests;

import autotests.config.web.TestData;
import autotests.helpers.Auth;
import autotests.po.BasePageObject;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static autotests.helpers.AttachmentsHelper.*;
import static autotests.drivers.DriverHelper.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@ExtendWith({AllureJunit5.class})
public class TestBase {
    public static BasePageObject po = new BasePageObject();
    public static String API_TOKEN;

    @BeforeAll
    static void setUp() {
        configureDriver();
        Configuration.baseUrl = TestData.getWebUrl();
        API_TOKEN = new Auth().getToken();
        RestAssured.baseURI = TestData.getApiUrl();

    }

    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());

        closeWebDriver();

        if (isVideoOn()) attachVideo(sessionId);
    }
}
