package ma.xproce.music_mood_matcher.Services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.xproce.music_mood_matcher.DAO.Entities.Question;
import ma.xproce.music_mood_matcher.DAO.Repositories.questionRepository;

@Service
public class QuestionService {

    @Autowired
    private questionRepository questionRepository;


    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

   /* public Question getQuestionById(Integer id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question updateQuestion(Question question) {

        Question existingQuestion = questionRepository.findById(question.getId()).orElse(null);
        if (existingQuestion == null) {

            return null;
        }

        existingQuestion.setQuestionsList(question.getQuestionsList());  // Update specific field
        return questionRepository.save(existingQuestion);
    }

    public void deleteQuestionById(Integer id) {
        questionRepository.deleteById(id);
    }*/
}

