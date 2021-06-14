package autotests.po.pages;

import autotests.config.testdata.TestData;
import autotests.po.widgets.Top;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static autotests.helpers.AttachmentsHelper.attachScreenshot;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;

public class BasePage {

    @Step("Open Main page")
    public BasePage openHome() {
        open(Configuration.baseUrl);
        eraseCookie();
        insertCookie();
        return this;
    }

    @Step("Erase Logged User Cookie.")
    BasePage eraseCookie() {
        getWebDriver().manage().deleteCookieNamed("sp_dc");
        return this;
    }

    @Step("Set value into field")
    protected void setSeValue(SelenideElement se, String value) {
        se.clear();
        se.setValue(value);
    }

    @Step("Insert Cookie")
    public BasePage insertCookie() {
        getWebDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", now().format(ofPattern("yyyy-MM-dd"))));
        refresh();
        sleep(2000);
        return this;
    }

    @Step("Captha protection force to use only 'ui login'.")
    public void loginToAccount() {
        openHome();
        eraseCookie();
        refresh();
        new Top().doLogin()
                .setLogin(TestData.getUserLogin())
                .setPass(TestData.getUserPassword())
                .login()
                .insertCookie();
        attachScreenshot("after cookie");
        new PopupPremium().closeIfExistPremiumPopup();
    }

}