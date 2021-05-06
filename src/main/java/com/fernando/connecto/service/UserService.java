package com.fernando.connecto.service;

import com.fernando.connecto.exceptions.InvalidLoginException;
import com.fernando.connecto.exceptions.ObjectNotFoundException;
import com.fernando.connecto.exceptions.ObjectAlreadyPresentException;
import com.fernando.connecto.model.User;
import com.fernando.connecto.model.UserLogin;
import com.fernando.connecto.model.dto.LoginDTO;
import com.fernando.connecto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private void checkEmailAvailable(String email){
        if(findByEmail(email).isPresent()){
            throw new ObjectAlreadyPresentException("Email already signed up");
        }
    }

    public LoginDTO login(UserLogin userData){
        Optional<User> user = findByEmail(userData.getEmail());
        if(user.isPresent()){
            if(passwordEncoder.matches(userData.getPassword(), user.get().getPassword())){
                userData.setToken("Bearer " + tokenService.generateToken(user.get()));
                userData.setId(user.get().getId());
                return new LoginDTO(userData);
            }
        }
        throw new InvalidLoginException("User or Password not valid");
    }

    public User findById (long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.isPresent() ? obj.get() : obj.orElseThrow(() -> new ObjectNotFoundException("User id="+id+" not found"));
    }

    public User save(User user){
        user.setEmail(user.getEmail().toLowerCase());
        checkEmailAvailable(user.getEmail());
        return userRepository.save(encryptPassword(user));
    }

    public User update(long id, User newUser){
        User oldUser = findById(id);
        newUser.setEmail(newUser.getEmail().toLowerCase());
        if(!oldUser.getEmail().equals(newUser.getEmail())){
            checkEmailAvailable(newUser.getEmail());
        }
        newUser.setId(id);
        return userRepository.save(encryptPassword(newUser));
    }

    private Optional<User> findByEmail(String email){
        return userRepository.findByEmailIgnoreCase(email);
    }

    private User encryptPassword(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

}
