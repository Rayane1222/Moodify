package ma.xproce.music_mood_matcher.Services;

import ma.xproce.music_mood_matcher.DAO.Entities.audioBookCategory;
import ma.xproce.music_mood_matcher.DAO.Repositories.audioBookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class audioBookCategoryService implements audioBookCategoryManager {


    private audioBookCategoryRepository audioBookCategoryRepository;


    @Override
    public audioBookCategory saveOrUpdateCategory(audioBookCategory category) {
        return null;
    }

    @Override
    public List<audioBookCategory> getAllCategories() {
        return audioBookCategoryRepository.findAll();
    }

    @Override
    public Optional<audioBookCategory> getCategoryById(Integer id) {
        return audioBookCategoryRepository.findById(id);
    }

    @Override
    public void deleteCategory(Integer id) {
        audioBookCategoryRepository.deleteById(id);
    }


    @Override
    public audioBookCategory updateCategory(Integer id, audioBookCategory newCategoryData) {
        Optional<audioBookCategory> optionalCategory = audioBookCategoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            audioBookCategory existingCategory = optionalCategory.get();
            existingCategory.setName(newCategoryData.getName());
            existingCategory.setAudioBookList(newCategoryData.getAudioBookList());

            return audioBookCategoryRepository.save(existingCategory);
        } else {

            return null;
        }
    }

   
}
