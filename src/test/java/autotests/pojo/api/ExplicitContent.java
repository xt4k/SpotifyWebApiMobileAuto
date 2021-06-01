package autotests.pojo.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExplicitContent {

    @JsonProperty("filter_locked")
    private boolean filterLocked;

    @JsonProperty("filter_enabled")
    private boolean filterEnabled;

    public ExplicitContent() {
        this.filterLocked = false;
        this.filterEnabled = false;
    }

    public boolean isFilterLocked() {
        return filterLocked;
    }

    public boolean isFilterEnabled() {
        return filterEnabled;
    }
}