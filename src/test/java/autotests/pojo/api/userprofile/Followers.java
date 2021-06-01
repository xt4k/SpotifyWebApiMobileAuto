package autotests.pojo.api.userprofile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Followers {

    @JsonProperty("total")
    private int total;

    @JsonProperty("href")
    private String href;

    public Followers() {
        this.total = 0;
        this.href = null;
    }

    public int getTotal() {
        return total;
    }

    public String getHref() {
        return href;
    }
}