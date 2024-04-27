package ma.xproce.music_mood_matcher.DAO.Services;


import java.util.List;

import ma.xproce.music_mood_matcher.DAO.Entities.User;

public interface UserManager {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    User updateUser(User user);

    void deleteUserById(Integer id);
}
