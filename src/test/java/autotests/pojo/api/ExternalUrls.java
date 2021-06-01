package autotests.pojo.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalUrls {

    @JsonProperty("spotify")
    private String spotify;

    public ExternalUrls() {
    }

    @Override
    public String toString() {
        return "ExternalUrls{" +
                "spotify='" + spotify + '\'' +
                '}';
    }
}