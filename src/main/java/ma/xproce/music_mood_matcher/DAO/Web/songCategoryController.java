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

import ma.xproce.music_mood_matcher.DAO.Entities.songCategory;
import ma.xproce.music_mood_matcher.DAO.Services.songCategoryService;

@RestController
@RequestMapping("/api/songCategories")
public class songCategoryController {

    @Autowired
    private songCategoryService songCategoryService;

    @PostMapping
    public songCategory createSongCategory(@RequestBody songCategory category) {
        return songCategoryService.createSongCategory(category);
    }

    @GetMapping
    public List<songCategory> getAllSongCategories() {
        return songCategoryService.getAllSongCategories();
    }

    @GetMapping("/{id}")
    public songCategory getSongCategoryById(@PathVariable Integer id) {
        return songCategoryService.getSongCategoryById(id);
    }

    @PutMapping("/{id}")
    public songCategory updateSongCategory(@PathVariable Integer id, @RequestBody songCategory category) {
        category.setId(id); 
        return songCategoryService.updateSongCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteSongCategoryById(@PathVariable Integer id) {
        songCategoryService.deleteSongCategoryById(id);
    }
}

