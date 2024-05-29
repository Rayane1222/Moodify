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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class MusicMoodMatcherApplication {


    @Autowired
    private UserManager userManager;

//    @Autowired
//    private QuestionManager questionManager;

    public static void main(String[] args) {
        SpringApplication.run(MusicMoodMatcherApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {return new BCryptPasswordEncoder();}

    @PostConstruct
    void initial_users(){
        if(userManager.getAllUsers()==null) {
            userManager.saveUser(new User(null, "admin", "123", "admin",null));
            userManager.saveUser(new User(null, "user1", "123", "user",null));
            userManager.saveUser(new User(null, "user2", "123", "user",null));
        }
    }

//    @PostConstruct
//    void initial_questions(){
//        if (questionManager.getAllQuestions()==null) {
//            questionManager.createQuestion(new Question(null, "Did you have a good day today?"));
//            questionManager.createQuestion(new Question(null, "Have you experienced anything exciting or uplifting today?"));
//            questionManager.createQuestion(new Question(null, "Is there something bothering you right now?"));
//            questionManager.createQuestion(new Question(null, "Do you feel energetic at the moment?"));
//            questionManager.createQuestion(new Question(null, "Did any interactions today make you feel upset or frustrated?"));
//            questionManager.createQuestion(new Question(null, "Do you feel content and at peace right now?"));
//            questionManager.createQuestion(new Question(null, "Has anything happened today that made you feel down or disappointed?"));
//            questionManager.createQuestion(new Question(null, "Are you feeling relaxed and at ease right now?"));
//            questionManager.createQuestion(new Question(null, "Did something happen today that made you smile or laugh?"));
//        }
//    }

}
