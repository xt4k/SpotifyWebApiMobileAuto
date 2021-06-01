package autotests.pojo.api.search.item;

import autotests.pojo.api.ExternalUrls;
import autotests.pojo.api.ImagesItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumItem {

    @JsonProperty("album_type")
    private String albumType;

    @JsonProperty
    private List<ArtistItem> artists;

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    @JsonProperty
    private String href;
    @JsonProperty
    private String id;
    @JsonProperty
    private List<ImagesItem> images;
    @JsonProperty
    private String name;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("release_date_precision")
    private String releaseDatePrecision;

    @JsonProperty("total_tracks")
    private int totalTracks;
    @JsonProperty
    private String type;
    @JsonProperty
    private String uri;

    public AlbumItem() {
    }

    public AlbumItem(String band, String albumName, String type, int tracks) {
        List<ArtistItem> art = new ArrayList<>();
        art.add(new ArtistItem(band));
        artists = art;
        name = albumName;
        albumType = type;
        this.type = type;
        totalTracks = tracks;
    }


    public String getAlbumType() {
        return albumType;
    }

    public List<ArtistItem> getArtists() {
        return artists;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getTotalTracks() {
        return totalTracks;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    @Override
    public String toString() {
        return "AlbumItem{" +
                "albumType='" + albumType + '\'' +
                ", artists=" + artists +
                ", name='" + name + '\'' +
                ", totalTracks=" + totalTracks +
                ", type='" + type + '\'' + '}';
    }
}