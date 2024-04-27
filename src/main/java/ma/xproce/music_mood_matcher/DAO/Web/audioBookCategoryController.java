package ma.xproce.music_mood_matcher.DAO.Web;



import ma.xproce.music_mood_matcher.DAO.Entities.audioBookCategory;
import ma.xproce.music_mood_matcher.DAO.Services.audioBookCategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/audiobookcategories")
public class audioBookCategoryController {

    @Autowired
    private audioBookCategoryManager audioBookCategoryService;

    @PostMapping
    public ResponseEntity<audioBookCategory> addaudioBookCategory(@RequestBody audioBookCategory category) {
        audioBookCategory savedCategory = audioBookCategoryService.saveOrUpdateCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<audioBookCategory>> getAllaudioBookCategories() {
        List<audioBookCategory> categories = audioBookCategoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<audioBookCategory> getaudioBookCategoryById(@PathVariable Integer id) {
        Optional<audioBookCategory> category = audioBookCategoryService.getCategoryById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<audioBookCategory> updateaudioBookCategory(@PathVariable Integer id, @RequestBody audioBookCategory newCategoryData) {
        audioBookCategory updatedCategory = audioBookCategoryService.updateCategory(id, newCategoryData);
        if (updatedCategory != null) {
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteaudioBookCategory(@PathVariable Integer id) {
        audioBookCategoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
