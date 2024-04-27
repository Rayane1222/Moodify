package ma.xproce.music_mood_matcher.DAO.Repositories;

import ma.xproce.music_mood_matcher.DAO.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface questionRepository extends JpaRepository <Question,Integer>{
}
