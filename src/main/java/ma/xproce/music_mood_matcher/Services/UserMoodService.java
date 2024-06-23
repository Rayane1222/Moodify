package ma.xproce.music_mood_matcher.Services;

import ma.xproce.music_mood_matcher.DAO.Entities.UserMood;
import ma.xproce.music_mood_matcher.DAO.Repositories.UserMoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserMoodService {
    @Autowired
    private UserMoodRepository userMoodRepository;

    public void saveUserMood(String username, String mood) {
        UserMood userMood = new UserMood();
        userMood.setUsername(username);
        userMood.setMood(mood);
        userMood.setDate(LocalDateTime.now());
        userMoodRepository.save(userMood);
    }

    public List<UserMood> getUserMoods(String username) {
        return userMoodRepository.findByUsername(username);
    }
}
