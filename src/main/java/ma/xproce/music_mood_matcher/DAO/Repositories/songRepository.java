package ma.xproce.music_mood_matcher.DAO.Repositories;

import ma.xproce.music_mood_matcher.DAO.Entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface songRepository extends JpaRepository<Song,Integer> {
}
