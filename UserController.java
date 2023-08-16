package com.example.hw17.Controller;

import com.example.hw17.ApiReespons.ApiRespons;
import com.example.hw17.Service.UserService;
import com.example.hw17.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private  final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAlluser(){
        List<User> userList=userService.getAllUser();
        return ResponseEntity.status(200).body(userList);
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       userService.adduser(user);
        return ResponseEntity.status(200).body(new ApiRespons("add user"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTodo(@RequestBody @Valid User user, @PathVariable Integer id,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdate= userService.updateUser(id,user);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiRespons("user update"));
        }
        return ResponseEntity.status(400).body(new ApiRespons("not found id"));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Boolean isDelete=userService.deleteUser(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiRespons("delete user"));
        }
        return ResponseEntity.status(400).body(new ApiRespons("not found id"));
    }

}
