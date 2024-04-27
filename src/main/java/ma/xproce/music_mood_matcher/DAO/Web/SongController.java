package ma.xproce.music_mood_matcher.DAO.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.xproce.music_mood_matcher.DAO.Entities.Song;
import ma.xproce.music_mood_matcher.DAO.Services.SongService;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Integer id) {
        return songService.getSongById(id);
    }

    @PutMapping("/{id}")
    public Song updateSong(@PathVariable Integer id, @RequestBody Song song) {
        song.setId(id); 
        return songService.updateSong(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSongById(@PathVariable Integer id) {
        songService.deleteSongById(id);
    }
}
