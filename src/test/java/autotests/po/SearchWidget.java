package autotests.po;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchWidget extends BasePageObject {
    SelenideElement seSearchField = $("form input");
    ElementsCollection ecTrackInfo = $$("div[aria-rowindex='1'] [dir='auto']");

    @Step("Set search by query: {genre}")
    public SearchWidget search(String genre) {
        setSeValue(seSearchField, genre);
        return this;
    }

    @Step("Verify that track found an contains searched info.")
    public void verifyTrackInfo(String genre) {
        ecTrackInfo.shouldBe(sizeGreaterThan(0))
                .shouldHave(anyMatch(genre, (WebElement we) -> (we.getText()).contains(genre)))
                .filter(text(genre)).shouldHave(sizeGreaterThan(0));
    }
}
