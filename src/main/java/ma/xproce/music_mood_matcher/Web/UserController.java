package ma.xproce.music_mood_matcher.Web;




import lombok.RequiredArgsConstructor;
import ma.xproce.music_mood_matcher.DTO.LoginDTO;
import ma.xproce.music_mood_matcher.DTO.SignUpDTO;
import ma.xproce.music_mood_matcher.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import ma.xproce.music_mood_matcher.DAO.Entities.User;
import ma.xproce.music_mood_matcher.Services.UserService;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController {


    private UserService userService;



//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }
//
    @PostMapping(path="/save")
    public String saveEmployee(@RequestBody SignUpDTO signUpDTO){
        String id = userService.addUserDTO(signUpDTO);
        return id;
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping("/&{id}")
//    public User getUserById(@PathVariable Integer id) {
//        return userService.getUserById(id);
//    }
//
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
//        user.setId(id);
//        return userService.updateUser(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUserById(@PathVariable Integer id) {
//        userService.deleteUserById(id);
//    }
//
//
//    @PostMapping(path="/signin")
//    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
//        LoginMessage loginMessage = userService.loginUser(loginDTO);
//        return ResponseEntity.ok(loginMessage);
//    }



}
