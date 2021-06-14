package autotests.config.testdata;

import org.aeonbits.owner.ConfigFactory;

import java.util.List;

public class TestData {

    private static TestDataConfig getTestData() {
        return ConfigFactory.newInstance().create(TestDataConfig.class, System.getProperties());
    }

    public static String getWebUrl() {
        return getTestData().webUrl();
    }

    public static String getApiAuthUrl() {
        return getTestData().apiAuthUrl();
    }

    public static String getApiUrl() {
        return getTestData().apiUrl();
    }

    public static String getUserLogin() {
        return getTestData().userLogin();
    }

    public static String getUserNickName() {
        return getTestData().userNickName();
    }

    public static String getUserPassword() {
        return getTestData().userPassword();
    }

    public static String getUserId() {
        return getTestData().userId();
    }

    public static String getFreeMonth() {
        return getTestData().freeMonth();
    }

    public static String getFree3Month() {
        return getTestData().free3Month();
    }

    public static String getPreferentialPeriod() {
        return getTestData().preferentialPeriod();
    }

    public static String getPreferentialPeriodWrong() {
        return getTestData().preferentialPeriodWrong();
    }

    public static String getMonthly() {
        return getTestData().monthly();
    }

    public static List<String> getPlans() {
        return getTestData().plans();
    }

    public static String getClientId() {
        return getTestData().clientId();
    }

    public static String getClientSecret() {
        return getTestData().clientSecret();
    }

    public static String getCountryCode() {
        return getTestData().countryCode();
    }

    public static String getMusicBand() {
        return getTestData().musicBand();
    }

    public static String getMusicBandComposition() {
        return getTestData().musicBandComposition();
    }

    public static String getMusicBandProduct() {
        return getTestData().musicBandProduct();
    }

    public static String getSoundComposition() {
        return getTestData().soundComposition();
    }

    public static String getSoundCompositionBand() {
        return getTestData().soundCompositionBand();
    }
}
