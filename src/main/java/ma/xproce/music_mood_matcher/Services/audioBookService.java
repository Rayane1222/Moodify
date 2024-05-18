package ma.xproce.music_mood_matcher.Services;

import ma.xproce.music_mood_matcher.DAO.Entities.audioBook;
import ma.xproce.music_mood_matcher.DAO.Repositories.audioBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class audioBookService {


    private audioBookRepository audioBookRepository;

    
    public audioBook saveOrUpdateAudioBook(audioBook audioBook) {
        return audioBookRepository.save(audioBook);
    }

    
    public List<audioBook> getAllAudioBooks() {
        return audioBookRepository.findAll();
    }

    
    public Optional<audioBook> getAudioBookById(Integer id) {
        return audioBookRepository.findById(id);
    }

    
    public void deleteAudioBook(Integer id) {
        audioBookRepository.deleteById(id);
    }

    
    public audioBook updateAudioBook(Integer id, audioBook newAudioBookData) {
        Optional<audioBook> optionalAudioBook = audioBookRepository.findById(id);
        if (optionalAudioBook.isPresent()) {
            audioBook existingAudioBook = optionalAudioBook.get();
            existingAudioBook.setName(newAudioBookData.getName());
            existingAudioBook.setDuration(newAudioBookData.getDuration());
            existingAudioBook.setAudioBookCategory(newAudioBookData.getAudioBookCategory());
            return audioBookRepository.save(existingAudioBook);
        } else {
        
            return null;
        }
    }

   
}
