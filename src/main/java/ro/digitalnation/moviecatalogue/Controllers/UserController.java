package ro.digitalnation.moviecatalogue.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.digitalnation.moviecatalogue.Models.Genre;
import ro.digitalnation.moviecatalogue.Models.User;
import ro.digitalnation.moviecatalogue.Services.GenreService;
import ro.digitalnation.moviecatalogue.Services.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/adduser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/update/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Integer id){
        userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
