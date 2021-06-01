package autotests.pojo.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesItem {

    @JsonProperty("width")
    private int width;

    @JsonProperty("url")
    private String url;

    @JsonProperty("height")
    private int height;

    public ImagesItem() {
    }

    @Override
    public String toString() {
        return "ImagesItem{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}