package autotests.drivers;


import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static autotests.drivers.DriverHelper.getDriverConfig;
import static io.appium.java_client.remote.MobileCapabilityType.*;


public class MobAndroidDriverHelper implements WebDriverProvider {
    WebDriver customDriver;


    public static URL getUrl(DesiredCapabilities dc) {
        try {
            return new URL(dc.getCapability("server").toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("server", getDriverConfig().getServer());
        capabilities.setCapability("locale", getDriverConfig().getLocale());
        capabilities.setCapability("language", getDriverConfig().getLanguage());

        capabilities.setCapability(PLATFORM_NAME, getDriverConfig().getPlatformName());
        capabilities.setCapability(DEVICE_NAME, getDriverConfig().getDeviceName());
        capabilities.setCapability(VERSION, getDriverConfig().getOsVersion());
        capabilities.setCapability(AUTOMATION_NAME, getDriverConfig().getAutoName());

        if (getDriverConfig().mobileCloud().equals("browserstack")) {//step("bs");
            //System.out.println("browserstack.user " + getDriverConfig().getBsUser());
            //System.out.println("browserstack.key " + getDriverConfig().getBsAccessKey());

            capabilities.setCapability("browserstack.user", getDriverConfig().getBsUser());
            capabilities.setCapability("browserstack.key", getDriverConfig().getBsAccessKey());
            capabilities.setCapability("device", getDriverConfig().getDeviceName());
            capabilities.setCapability("os_version", getDriverConfig().getOsVersion());
            capabilities.setCapability("project", getDriverConfig().getProject());
            capabilities.setCapability("build", getDriverConfig().getBuild());
            capabilities.setCapability("name", getDriverConfig().getTestsetName());
            capabilities.setCapability("browserstack.debug", getDriverConfig().getBsDebug());
        }

        else if (getDriverConfig().mobileCloud().contains("emulator")) {
            capabilities.setCapability(NEW_COMMAND_TIMEOUT, 20);
            capabilities.setCapability(FULL_RESET, false);
            capabilities.setCapability("local.video.storage", getDriverConfig().getMobileVideoStorage());
        }
        customDriver = new AndroidDriver(getUrl(capabilities), capabilities);

        return customDriver;
    }
}
