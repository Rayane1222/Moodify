package ma.xproce.music_mood_matcher.DAO.Services;

import ma.xproce.music_mood_matcher.DAO.Entities.Mood;
import ma.xproce.music_mood_matcher.DAO.Repositories.moodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class MoodService implements MoodManager {

    @Autowired
    private moodRepository moodRepository;

    
    @Override
    public Mood saveOrUpdateMood(Mood mood) {
        return moodRepository.save(mood);
    }

    @Override
    public List<Mood> getAllMoods() {
        return moodRepository.findAll();
    }

    @Override
    public Optional<Mood> getMoodById(Integer id) {
        return moodRepository.findById(id);
    }

    @Override
    public void deleteMood(Integer id) {
        moodRepository.deleteById(id);
    }

   
}

