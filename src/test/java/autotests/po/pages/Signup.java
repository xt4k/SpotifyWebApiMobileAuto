package autotests.po.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

public class Signup extends BasePage {
    SelenideElement seTermConditions = $("#facebook-terms-conditions-checkbox");
    SelenideElement seEmail = $("#email");
    SelenideElement seEmailConfirm = $("#confirm");
    SelenideElement sePass = $("#password");
    SelenideElement seNick = $("#displayname");

    SelenideElement seDay = $("#day");
    SelenideElement seMonth = $("#month");
    SelenideElement seYear = $("#year");

    SelenideElement seMarket = $("#marketing-opt-checkbox");
    SelenideElement seGender = $("#gender_option_nonbinary");

    SelenideElement seAgree = $("#terms-conditions-checkbox");
    SelenideElement seShare = $("#third-party-checkbox");
    SelenideElement seSubmitForm = $("button[type='submit']");


    @Step("Fill SignUp form")
    public void fillSignUpForm(Faker faker) {
        insertCookie();
        String email = faker.internet().emailAddress();
        seTermConditions.parent().click();
        seEmail.setValue(email);
        seEmailConfirm.setValue(email);
        sePass.setValue(faker.internet().password(10, 15));
        seNick.setValue(faker.superhero().name());
        Date birtDate = faker.date().birthday();
        String month = new SimpleDateFormat("MMM").format(birtDate);
        String day = new SimpleDateFormat("dd").format(birtDate);
        String year = new SimpleDateFormat("yyyy").format(birtDate);

        setSeValue(seDay, day);
        seMonth.click();
        seMonth.sendKeys(month);
        setSeValue(seYear, year);

        seGender.parent().click();
        seMarket.parent().click();
        seShare.parent().click();
        seAgree.parent().scrollTo().click();
    }

    @Step("Submit spotify registration profile form")
    public Playlist signup() {
        seSubmitForm.click();
        insertCookie();
        return new Playlist();
    }
}
