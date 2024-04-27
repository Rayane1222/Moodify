package ma.xproce.music_mood_matcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ma.xproce.music_mood_matcher.DAO.Services")
public class MusicMoodMatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicMoodMatcherApplication.class, args);
    }

}
