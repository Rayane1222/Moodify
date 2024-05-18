package ma.xproce.music_mood_matcher.Services;


import java.util.List;
import java.util.Optional;

import ma.xproce.music_mood_matcher.DTO.UserDTO;
import ma.xproce.music_mood_matcher.DTO.LoginDTO;
import ma.xproce.music_mood_matcher.payload.response.LoginMessage;
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
        return userRepository.save(existingUser);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public String addUserDTO(UserDTO userDTO){
       User user = new User(
            userDTO.getId(),
            userDTO.getPassword(),
            userDTO.getName(),
            userDTO.getEmail()
       );
       userRepository.save(user);
       return user.getName();
    }

    public LoginMessage loginUser(LoginDTO loginDTO){
        String msg="";
        User user1 = userRepository.findByEmail(loginDTO.getEmail());
        if(user1!=null){
            String password= loginDTO.getPassword();
            String encodedPassword= user1.getPassword();


                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(),encodedPassword);
                if(user.isPresent()){
                    return new LoginMessage("Login Success", true);
                }
                else{
                    return new LoginMessage("Login Failed", false);
                }

            }
            else{
                return new LoginMessage("password Not match",false);
            }

        }



}

