package autotests.po;

import autotests.config.web.TestData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
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
    }

    @Step("CAPCHA force to use only 'ui login'.")
    public void loginToAccount() {
        openHome();
        new TopWidget().doLogin()
                .setLogin(TestData.getUserLogin())
                .setPass(TestData.getUserPassword())
                .login()
                .insertCookie();

        new PopupPremium().closeIfExistPremiumPopup();
    }

}