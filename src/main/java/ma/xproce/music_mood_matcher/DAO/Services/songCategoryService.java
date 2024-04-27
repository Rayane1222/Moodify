package ma.xproce.music_mood_matcher.DAO.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.xproce.music_mood_matcher.DAO.Entities.Song;
import ma.xproce.music_mood_matcher.DAO.Entities.songCategory;
import ma.xproce.music_mood_matcher.DAO.Repositories.songCategoryRepository;

@Service
public class songCategoryService {

    @Autowired
    private songCategoryRepository songCategoryRepository;

    public songCategory createSongCategory(songCategory category) {
        return songCategoryRepository.save(category);
    }

    public List<songCategory> getAllSongCategories() {
        return songCategoryRepository.findAll();
    }

    public songCategory getSongCategoryById(Integer id) {
        return songCategoryRepository.findById(id).orElse(null);
    }

    public songCategory updateSongCategory(songCategory category) {
        
        songCategory existingCategory = songCategoryRepository.findById(category.getId()).orElse(null);
        if (existingCategory == null) {
          
            return null;
        }

        existingCategory.setName(category.getName());
       
        return songCategoryRepository.save(existingCategory);
    }

    public void deleteSongCategoryById(Integer id) {
        songCategoryRepository.deleteById(id);
    }

    

    public void addSongToCategory(songCategory category, Song song) {
        
        song.setSongCategory(category);
        songCategoryRepository.save(category); 
    }

    public void removeSongFromCategory(songCategory category, Song song) {
        
        song.setSongCategory(null); 
        songCategoryRepository.save(category); 
    }
}
