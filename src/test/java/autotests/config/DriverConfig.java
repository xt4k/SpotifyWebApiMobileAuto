package autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${srv}_driver.properties"
})
public interface DriverConfig extends Config {

    @Key("mobile")
    String mobileCloud();

    @Key("web.browser.mobile.view")
    String webBrowserMobileView();

    @Key("web.browser")
    String webBrowser();

    @Key("web.browser.version")
    String webBrowserVersion();

    @Key("web.browser.size")
    String webBrowserSize();


    @Key("web.browser.locale")
    String webBrowserLocale();

    @Key("log.type")
    String browserLogType();

    @Key("web.remote.driver.url")
    String webRemoteDriverUrl();

    @Key("web.remote.driver.user")
    String webRemoteDriverUser();

    @Key("web.remote.driver.password")
    String webRemoteDriverPassword();

    @Key("video.storage")
    String videoStorage();

    @Key("server.url")
    String getServer();

    @Key("os.version")
    String getOsVersion();

    @Key("automation.name")
    String getAutoName();

    @Key("platform.name")
    String getPlatformName();

    @Key("device.name")
    String getDeviceName();

    @Key("locale")
    String getLocale();

    @Key("language")
    String getLanguage();

    @Key("app.package")
    String getAppPackage();

    @Key("app.activity")
    String getAppActivity();

    @Key("absolute.path")
    String getAbsPath();


    @Key("app")    // @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String getApp();

    //-----bs
    @Key("user.bs")
    String getBsUser();

    @Key("access.key")
    String getBsAccessKey();

    @Key("browserstack.debug")
    String getBsDebug();

    @Key("build")
    String getBuild();

    @Key("project")
    String getProject();

    @Key("testset.name")
    String getTestsetName();

}
