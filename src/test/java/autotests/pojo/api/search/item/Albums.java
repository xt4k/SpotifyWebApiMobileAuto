package autotests.pojo.api.search.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Albums {

    @JsonProperty("next")
    private String next;

    @JsonProperty("total")
    private int total;

    @JsonProperty("offset")
    private int offset;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("href")
    private String href;

    @JsonProperty("items")
    private List<AlbumItem> items;
}