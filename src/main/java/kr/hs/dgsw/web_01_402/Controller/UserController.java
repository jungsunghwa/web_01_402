package kr.hs.dgsw.web_01_402.Controller;

import kr.hs.dgsw.web_01_402.Domain.User;
import kr.hs.dgsw.web_01_402.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/list/user")
    public List<User> listAllUser(){
        return this.userService.listAllUser();
    }

    @PostMapping("/add/user")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping("/update/user/{id}")
    public User updateComment(@PathVariable Long id, @RequestBody User user){
        return this.userService.updateUser(id,user);
    }

    @DeleteMapping("delete/user/{id}")
    public boolean deleteComment(@PathVariable Long id) {
        return this.userService.deleteUser(id);
    }

}
