package ma.xproce.music_mood_matcher.DAO.Repositories;

import ma.xproce.music_mood_matcher.DAO.Entities.audioBookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface audioBookCategoryRepository extends JpaRepository<audioBookCategory,Integer> {
}
