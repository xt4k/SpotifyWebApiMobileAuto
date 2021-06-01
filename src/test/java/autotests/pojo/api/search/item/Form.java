package autotests.pojo.api.search.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Form {
    @JsonProperty
    private String query;

    @JsonProperty
    private String type;

    @JsonProperty
    private String market;

    @JsonProperty
    private int limit;

    @JsonProperty
    private int offset;

    public Form() {
        Faker faker = new Faker();
        this.query = faker.music().genre();
        this.type = faker.artist().name();
        this.market = faker.address().countryCode();
        this.limit = faker.number().numberBetween(0, 99);
        this.offset = faker.number().numberBetween(0, 30);
    }

    public Form(AlbumItem ai, String market, int limit, int offset) {
        this.query = ai.getArtists().get(0).getName();
        this.type = ai.getType();
        this.market = market;
        this.limit = limit;
        this.offset = offset;
    }

    public String getQuery() {
        return query;
    }

    public String getType() {
        return type;
    }

    public String getMarket() {
        return market;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public String toString() {
        return "Form{" +
                "query='" + query + '\'' +
                ", type='" + type + '\'' +
                ", market='" + market + '\'' +
                ", limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
