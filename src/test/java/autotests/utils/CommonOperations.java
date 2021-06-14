package autotests.utils;

import io.qameta.allure.Step;

import java.util.Random;

import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.sleep;

public class CommonOperations {

    @Step("Human delay simulation")
    public void randSleep() {
        int delay = new Random().nextInt((int) timeout);
        sleep(delay);
    }
}