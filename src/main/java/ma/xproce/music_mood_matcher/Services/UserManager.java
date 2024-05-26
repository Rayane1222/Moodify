package ma.xproce.music_mood_matcher.Services;


import ma.xproce.music_mood_matcher.DAO.Entities.User;

import ma.xproce.music_mood_matcher.DTO.LoginDTO;
import ma.xproce.music_mood_matcher.DTO.SignUpDTO;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface UserManager {

    User saveUser(User user);
    User findUserByUsername(String username);
    List<User> findAllUsers();
    User getUserByUsername(String username);
    List<User> getAllUsers();


    String addUserDTO(SignUpDTO signUpDTO);
}
