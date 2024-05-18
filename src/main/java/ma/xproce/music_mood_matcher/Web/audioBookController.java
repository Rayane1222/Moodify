package ma.xproce.music_mood_matcher.Web;



import ma.xproce.music_mood_matcher.DAO.Entities.audioBook;
import ma.xproce.music_mood_matcher.Services.audioBookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/audiobooks")
public class audioBookController {


    private audioBookManager audioBookService;

    @PostMapping
    public ResponseEntity<audioBook> addaudioBook(@RequestBody audioBook audioBook) {
        audioBook savedaudioBook = audioBookService.saveOrUpdateAudioBook(audioBook);
        return new ResponseEntity<>(savedaudioBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<audioBook>> getAllaudioBooks() {
        List<audioBook> audioBooks = audioBookService.getAllAudioBooks();
        return new ResponseEntity<>(audioBooks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<audioBook> getaudioBookById(@PathVariable Integer id) {
        Optional<audioBook> audioBook = audioBookService.getAudioBookById(id);
        return audioBook.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<audioBook> updateaudioBook(@PathVariable Integer id, @RequestBody audioBook newAudioBookData) {
        audioBook updatedAudioBook = audioBookService.updateAudioBook(id, newAudioBookData);
        if (updatedAudioBook != null) {
            return new ResponseEntity<>(updatedAudioBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteaudioBook(@PathVariable Integer id) {
        audioBookService.deleteAudioBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
