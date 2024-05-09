package ma.xproce.music_mood_matcher.Services;


import ma.xproce.music_mood_matcher.DAO.Entities.Mood;
import java.util.List;
import java.util.Optional;

public interface MoodManager {

    Mood saveOrUpdateMood(Mood mood);

    List<Mood> getAllMoods();

    Optional<Mood> getMoodById(Integer id);

    void deleteMood(Integer id);

}

