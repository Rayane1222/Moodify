package ma.xproce.music_mood_matcher.Services;

import ma.xproce.music_mood_matcher.DAO.Entities.audioBook;
import java.util.List;
import java.util.Optional;

public interface audioBookManager {

    audioBook saveOrUpdateAudioBook(audioBook audioBook);

    List<audioBook> getAllAudioBooks();

    Optional<audioBook> getAudioBookById(Integer id);

    void deleteAudioBook(Integer id);

    audioBook updateAudioBook(Integer id, audioBook newAudioBookData);

   
}
