package ma.xproce.music_mood_matcher.Services;


import java.util.List;


import ma.xproce.music_mood_matcher.DTO.LoginDTO;
import ma.xproce.music_mood_matcher.DTO.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.xproce.music_mood_matcher.DAO.Entities.User;
import ma.xproce.music_mood_matcher.DAO.Repositories.userRepository;

@Service
public class UserService implements UserManager{

    @Autowired
    userRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



    @Override
    public String addUserDTO(SignUpDTO signUpDTO) {
        User user = new User();
        user.setUsername(signUpDTO.getName());
        user.setPassword(bCryptPasswordEncoder.encode(signUpDTO.getPassword()));
        user.setRole("user");
        userRepository.save(user);
        return  String.valueOf(user.getUserid());
    }
}

