package ma.xproce.music_mood_matcher.DAO.Repositories;

import ma.xproce.music_mood_matcher.DAO.Entities.Mood;
import org.springframework.data.jpa.repository.JpaRepository;



public interface moodRepository extends JpaRepository<Mood, Integer> {
}
