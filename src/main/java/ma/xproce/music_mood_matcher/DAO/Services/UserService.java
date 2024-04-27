package ma.xproce.music_mood_matcher.DAO.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.xproce.music_mood_matcher.DAO.Entities.User;
import ma.xproce.music_mood_matcher.DAO.Repositories.userRepository;

@Service
public class UserService {

    @Autowired
    private userRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
       
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser == null) {
           
            return null;
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(existingUser);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}

