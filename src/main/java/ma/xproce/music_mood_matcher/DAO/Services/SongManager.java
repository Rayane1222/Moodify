package ma.xproce.music_mood_matcher.DAO.Services;


import java.util.List;

import ma.xproce.music_mood_matcher.DAO.Entities.Song;

public interface SongManager {

    Song createSong(Song song);

    List<Song> getAllSongs();

    Song getSongById(Integer id);

    Song updateSong(Song song);

    void deleteSongById(Integer id);
}
