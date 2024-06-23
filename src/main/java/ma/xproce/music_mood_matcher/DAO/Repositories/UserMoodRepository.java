package ma.xproce.music_mood_matcher.DAO.Repositories;

import ma.xproce.music_mood_matcher.DAO.Entities.UserMood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMoodRepository extends JpaRepository<UserMood, Long> {
    List<UserMood> findByUsername(String username);
}