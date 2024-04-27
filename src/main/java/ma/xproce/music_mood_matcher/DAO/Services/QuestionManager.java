package ma.xproce.music_mood_matcher.DAO.Services;



import java.util.List;

import ma.xproce.music_mood_matcher.DAO.Entities.Question;

public interface QuestionManager {

    Question createQuestion(Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(Integer id);

    Question updateQuestion(Question question);

    void deleteQuestionById(Integer id);
}
