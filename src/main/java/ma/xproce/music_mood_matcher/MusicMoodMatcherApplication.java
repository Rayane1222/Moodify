package ma.xproce.music_mood_matcher;


import jakarta.annotation.PostConstruct;
import ma.xproce.music_mood_matcher.DAO.Entities.Question;
import ma.xproce.music_mood_matcher.DAO.Entities.User;
import ma.xproce.music_mood_matcher.Services.QuestionManager;


import ma.xproce.music_mood_matcher.Services.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication()
public class MusicMoodMatcherApplication {


    @Autowired
    private UserManager userManager;

    public static void main(String[] args) {
        SpringApplication.run(MusicMoodMatcherApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {return new BCryptPasswordEncoder();}

    //@PostConstruct
    void initial_users(){
        userManager.saveUser(new User(null,"admin","123","admin"));
        userManager.saveUser(new User(null,"user1","123","user"));
        userManager.saveUser(new User(null,"user2","123","user"));
    }

}
