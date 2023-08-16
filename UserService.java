package com.example.hw17.Service;

import com.example.hw17.Repostere.UserRpository;
import com.example.hw17.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRpository userRpository;

    public List<User> getAllUser(){
        return userRpository.findAll();
    }
    public void adduser(User user){
        userRpository.save(user);
    }
    public Boolean updateUser(Integer id, User user){
        User oldUser=userRpository.getById(id);
        if (oldUser==null){
            return false;

        }
        oldUser.setName(user.getName());
        oldUser.setRole(user.getRole());
        oldUser.setEmail(user.getEmail());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        return true;
    }
    public Boolean deleteUser(Integer id) {
        User oldUser = userRpository.getById(id);
        if (oldUser == null) {
            return false;
        }
        userRpository.delete(oldUser);
        return true;
    }

}
