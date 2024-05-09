package ma.xproce.music_mood_matcher.Services;


import java.util.List;

import ma.xproce.music_mood_matcher.DAO.Entities.Song;
import ma.xproce.music_mood_matcher.DAO.Entities.songCategory;

public interface songCategoryManager {

    songCategory createSongCategory(songCategory category);

    List<songCategory> getAllSongCategories();

    songCategory getSongCategoryById(Integer id);

    songCategory updateSongCategory(songCategory category);

    void deleteSongCategoryById(Integer id);

  

    void addSongToCategory(songCategory category, Song song);

    void removeSongFromCategory(songCategory category, Song song);
}
