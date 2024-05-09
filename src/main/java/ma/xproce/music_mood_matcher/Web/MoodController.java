package ma.xproce.music_mood_matcher.Web;



import ma.xproce.music_mood_matcher.DAO.Entities.Mood;
import ma.xproce.music_mood_matcher.Services.MoodManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/moods")
public class MoodController {

    @Autowired
    private MoodManager moodManager;

    @PostMapping
    public ResponseEntity<Mood> addMood(@RequestBody Mood mood) {
        Mood savedMood = moodManager.saveOrUpdateMood(mood);
        return new ResponseEntity<>(savedMood, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Mood>> getAllMoods() {
        List<Mood> moods = moodManager.getAllMoods();
        return new ResponseEntity<>(moods, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mood> getMoodById(@PathVariable Integer id) {
        Optional<Mood> mood = moodManager.getMoodById(id);
        return mood.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mood> updateMood(@PathVariable Integer id, @RequestBody Mood newMoodData) {
        Mood updatedMood = moodManager.saveOrUpdateMood( newMoodData);
        if (updatedMood != null) {
            return new ResponseEntity<>(updatedMood, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMood(@PathVariable Integer id) {
        moodManager.deleteMood(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
