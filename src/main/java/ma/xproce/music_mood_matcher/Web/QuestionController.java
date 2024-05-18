package ma.xproce.music_mood_matcher.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.xproce.music_mood_matcher.DAO.Entities.Question;
import ma.xproce.music_mood_matcher.Services.QuestionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

//    @PostMapping
//    public Question createQuestion(@RequestBody Question question) {
//        return questionService.createQuestion(question);
//    }
//    @GetMapping("/{id}")
//    public Question getQuestionById(@PathVariable Integer id) {
//        return questionService.getQuestionById(id);
//    }
//
//    @PutMapping("/{id}")
//    public Question updateQuestion(@PathVariable Integer id, @RequestBody Question question) {
//        question.setId(id);
//        return questionService.updateQuestion(question);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteQuestionById(@PathVariable Integer id) {
//        questionService.deleteQuestionById(id);
//    }
}
