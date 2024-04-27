package ma.xproce.music_mood_matcher.DAO.Repositories;

import ma.xproce.music_mood_matcher.DAO.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Integer> {
}
