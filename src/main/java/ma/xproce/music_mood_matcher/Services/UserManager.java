package ma.xproce.music_mood_matcher.Services;


import ma.xproce.music_mood_matcher.DAO.Entities.User;
import ma.xproce.music_mood_matcher.DTO.UserDTO;
import ma.xproce.music_mood_matcher.DTO.LoginDTO;
import ma.xproce.music_mood_matcher.payload.response.LoginMessage;

import java.util.List;

public interface UserManager {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    User updateUser(User user);

    void deleteUserById(Integer id);

    String addUserDTO(UserDTO userDTO);

    LoginMessage loginUser(LoginDTO loginDto);
}
