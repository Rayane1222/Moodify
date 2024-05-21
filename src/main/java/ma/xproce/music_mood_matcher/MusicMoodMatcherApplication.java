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




//    public MusicMoodMatcherApplication(QuestionManager questionManager) {
//        this.questionManager = questionManager;
//    }

//    public void run(String... args) throws Exception {
//        Question q1= new Question(null,"Did you have a good day today?");
//        Question q2= new Question(null,"Have you experienced anything exciting or uplifting today?");
//        Question q3= new Question(null,"Is there something bothering you right now?");
//        Question q4= new Question(null,"Do you feel energetic at the moment?");
//        Question q5= new Question(null,"Did any interactions today make you feel upset or frustrated?");
//        Question q6= new Question(null,"Do you feel content and at peace right now?");
//        Question q7= new Question(null,"Has anything happened today that made you feel down or disappointed?");
//        Question q8= new Question(null,"Are you feeling relaxed and at ease right now?");
//        Question q9= new Question(null,"Did something happen today that made you smile or laugh?");
//        questionManager.createQuestion(q1);
//        questionManager.createQuestion(q2);
//        questionManager.createQuestion(q3);
//        questionManager.createQuestion(q4);
//        questionManager.createQuestion(q5);
//        questionManager.createQuestion(q6);
//        questionManager.createQuestion(q7);
//        questionManager.createQuestion(q8);
//        questionManager.createQuestion(q9);
//
//        System.out.println(questionManager.getAllQuestions());
//
//
//    }
//@Bean
//public CommandLineRunner commandLineRunner() {
//    return args -> {
//        Question q1 = new Question();
//        q1.setQuestionsList("Did you have a good day today?");
//        Question q2 = new Question();
//        q1.setQuestionsList("Have you experienced anything exciting or uplifting today?");
//        Question q3 = new Question();
//        q1.setQuestionsList("Is there something bothering you right now?");
//        Question q4 = new Question();
//        q1.setQuestionsList("Do you feel energetic at the moment?");
//        Question q5 = new Question();
//        q1.setQuestionsList("Did any interactions today make you feel upset or frustrated?");
//        Question q6 = new Question();
//        q1.setQuestionsList("Do you feel content and at peace right now?");
//        Question q7 = new Question();
//        q1.setQuestionsList("Has anything happened today that made you feel down or disappointed?");
//        Question q8 = new Question();
//        q1.setQuestionsList("Are you feeling relaxed and at ease right now?");
//        Question q9 = new Question();
//        q1.setQuestionsList("Did something happen today that made you smile or laugh?");
//        questionManager.createQuestion(q1);
//        questionManager.createQuestion(q2);
//        questionManager.createQuestion(q3);
//        questionManager.createQuestion(q4);
//        questionManager.createQuestion(q5);
//        questionManager.createQuestion(q6);
//        questionManager.createQuestion(q7);
//        questionManager.createQuestion(q8);
//        questionManager.createQuestion(q9);
//
//        System.out.println(questionManager.getAllQuestions());


//        User user = new User(null,"ZBI","ZBI","ZABKBIR@gmail.com");
//        userManager.createUser(user);
//        System.out.println(userManager.getAllUsers());
//    };
//}
}
