package autotests.po;

import autotests.config.testdata.TestData;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PremiumPage extends BasePageObject {
    SelenideElement seViewPlans = $("a[href='#plans']");
    ElementsCollection ecPlansHeaders = $$("div[data-event-campaign-id][data-current-plan-text]");

    @Step("Go to plans details")
    public PremiumPage goPlansDetails() {
        seViewPlans.click();
        return this;
    }

    @Step("Verify plans details")
    public void verifyPlansInfo() {
        ecPlansHeaders.shouldHave((sizeGreaterThanOrEqual(3)))
                .filter(text(TestData.getMonthly())).shouldHave(sizeGreaterThanOrEqual(3))
                .shouldHave(texts(TestData.getPlans()))
                .filterBy(text(TestData.getFreeMonth())).shouldHave(sizeGreaterThanOrEqual(3))
                .filterBy(text(TestData.getFree3Month())).shouldHave(sizeGreaterThan(0));
    }
}
