package autotests.pojo.api.userprofile;

import autotests.config.testdata.TestData;
import autotests.pojo.api.ExplicitContent;
import autotests.pojo.api.ExternalUrls;
import autotests.pojo.api.ImagesItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileInfo {

    @JsonProperty("country")
    private String country;

    @JsonProperty("images")
    private List<ImagesItem> images;

    @JsonProperty("product")
    private String product;

    @JsonProperty("followers")
    private Followers followers;

    @JsonProperty("explicit_content")
    private ExplicitContent explicitContent;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("type")
    private String type;

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("email")
    private String email;

    public ProfileInfo() {
    }

    public ProfileInfo(String me) {
        this.country = TestData.getCountryCode();
        this.images = new ArrayList<>();
        this.product = "open";
        this.type = "user";
        this.followers = new Followers();
        this.explicitContent = new ExplicitContent();
        this.displayName = TestData.getUserNickName();
        this.email = TestData.getUserLogin();
    }

}