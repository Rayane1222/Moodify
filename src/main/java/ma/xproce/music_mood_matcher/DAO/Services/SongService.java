package ma.xproce.music_mood_matcher.DAO.Services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.xproce.music_mood_matcher.DAO.Entities.Song;

import ma.xproce.music_mood_matcher.DAO.Repositories.songRepository;

@Service
public class SongService {

    @Autowired
    private songRepository songRepository;

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song getSongById(Integer id) {
        return songRepository.findById(id).orElse(null);
    }

    public Song updateSong(Song song) {

        Song existingSong = songRepository.findById(song.getId()).orElse(null);
        if (existingSong == null) {
            
            return null;
        }

        existingSong.setName(song.getName());
        existingSong.setDuration(song.getDuration());
        existingSong.setSongCategory(song.getSongCategory()); 
        existingSong.setArtiste(song.getArtiste());
        return songRepository.save(existingSong);
    }

    public void deleteSongById(Integer id) {
        songRepository.deleteById(id);
    }
}

