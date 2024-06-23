package ma.xproce.music_mood_matcher.Web;

import ma.xproce.music_mood_matcher.DAO.Entities.UserMood;
import ma.xproce.music_mood_matcher.Services.UserMoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usermoods")
public class UserMoodController {
    @Autowired
    private UserMoodService userMoodService;

    @PostMapping
    public void saveUserMood(@RequestParam String username, @RequestParam String mood) {
        userMoodService.saveUserMood(username, mood);
    }

    @GetMapping("/{username}")
    public List<UserMood> getUserMoods(@PathVariable String username) {
        return userMoodService.getUserMoods(username);
    }
}