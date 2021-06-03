package autotests.po;

import autotests.config.testdata.TestData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static autotests.helpers.AttachmentsHelper.attachScreenshot;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;

public class BasePageObject {

    @Step("Open Main page")
    public BasePageObject openHome() {
        open(Configuration.baseUrl);
        insertCookie();
        return this;
    }

    @Step("Set value into field")
    void setSeValue(SelenideElement se, String value) {
        se.clear();
        se.setValue(value);
    }

    @Step("Insert Cookie")
    public void insertCookie() {
        getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", now().format(ofPattern("yyyy-MM-dd"))));
        refresh();
        sleep(500);
    }

    @Step("Captha protection force to use only 'ui login'.")
    public void loginToAccount() {
        openHome();
        new TopWidget().doLogin()
                .setLogin(TestData.getUserLogin())
                .setPass(TestData.getUserPassword())
                .login()
                .insertCookie();
        //attachScreenshot("after cookie");
        new PopupPremium().closeIfExistPremiumPopup();
    }

}