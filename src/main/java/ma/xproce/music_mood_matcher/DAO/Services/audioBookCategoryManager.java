package ma.xproce.music_mood_matcher.DAO.Services;


import ma.xproce.music_mood_matcher.DAO.Entities.audioBookCategory;
import java.util.List;
import java.util.Optional;

public interface audioBookCategoryManager {

    audioBookCategory saveOrUpdateCategory(audioBookCategory category);

    List<audioBookCategory> getAllCategories();

    Optional<audioBookCategory> getCategoryById(Integer id);

    void deleteCategory(Integer id);

    public audioBookCategory updateCategory(Integer id, audioBookCategory newCategoryData);

}
