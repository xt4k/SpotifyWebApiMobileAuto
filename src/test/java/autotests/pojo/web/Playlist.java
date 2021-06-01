package autotests.pojo.web;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.Random;

@Data
public class Playlist {

    private String name;
    private String description;
    private String genre;
    private String singer;

    public Playlist() {
        Faker faker = new Faker();
        name = faker.rockBand().name() + "_playlist_" + new Random().nextInt(100);//
        description = faker.lorem().sentence(10);
        genre = faker.music().instrument();//.genre();
        singer = faker.artist().name();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}