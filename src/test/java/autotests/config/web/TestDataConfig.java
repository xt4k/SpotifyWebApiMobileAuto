package autotests.config.web;

import org.aeonbits.owner.Config;

import java.util.List;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:testdata/testdata.properties",
        "classpath:config/app.properties"
})
public interface TestDataConfig extends Config {
    @Key("web.url")
    String webUrl();

    @Key("api.auth.url")
    String apiAuthUrl();

    @Key("api.url")
    String apiUrl();

    @Key("user.login")
    String userLogin();

    @Key("user.password")
    String userPassword();

    @Key("user.nickname")
    String userNickName();

    @Key("user.id")
    String userId();

    @Key("plan.list")
    List<String> plans();

    @Key("monthly.common")
    String monthly();

    @Key("free.period")
    String freeMonth();

    @Key("free.period2")
    String free3Month();

    @Key("client.id")
    String clientId();

    @Key("cli.secret")
    String clientSecret();

    @Key("cookie.name")
    String cookieName();

    @Key("country.code")
    String countryCode();

    @Key("music.band")
    String musicBand();

    @Key("music.band.composition")
    String musicBandComposition();

    @Key("music.band.product")
    String musicBandProduct();

    @Key("sound.composition")
    String soundComposition();

    @Key("sound.composition.band")
    String soundCompositionBand();

}
