package com.example.springtemplate.daos;

import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.UserRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserRestOrmDao {
    @Autowired
    UserRestRepository userRepository;

    @PostMapping("/api/users")                          // map this method to an HTTP POST
    public User createUser(@RequestBody User user) {      // parse new user from HTTP Request BODY
        return userRepository.save(user);                 // insert new user into users table
    }
    
    @GetMapping("/api/users")                   // map this method to an HTTP GET request
    public List<User> findAllUsers() {            // execute this method if URL matches /api/users
        return userRepository.findAllUsers();     // retrieve all records from users table and return as list of users
    }
    
    @GetMapping("/api/users/{userId}")              // map this method to HTTP GET request
    public User findUserById(                         //  execute this method when URL matches /api/users/ID
        @PathVariable("userId") Integer id) {         // parse user ID from path variable userID
        return userRepository.findUserById(id);       // retrieve single user by ID and return as instance of User
    }
    
    @PutMapping("/api/users/{userId}")                          // map method to HTTP PUT
    public User updateUser(
            @PathVariable("userId") Integer id,                    // parse user's ID from URL
            @RequestBody User userUpdates) {                       // parse user object from BODY
        User user = userRepository.findUserById(id);               // retrieve user from database
        user.setFirstName(userUpdates.getFirstName());             // update
        user.setLastName(userUpdates.getLastName());               // user fields
        user.setUsername(userUpdates.getUsername());               // with new
        user.setPassword(userUpdates.getPassword());               // values from
        user.setEmail(userUpdates.getEmail());   // user interface
        user.setDateOfBirth(userUpdates.getDateOfBirth());
        return userRepository.save(user);                          // save changes to database
    }
    
    @DeleteMapping("/api/users/{userId}")       // map this method to HTTP DELETE request
    public void deleteUser(                        // execute this method if URL matches /api/users/ID
            @PathVariable("userId") Integer id) {  // parse user's ID from path variable
        userRepository.deleteById(id);              // use repository to permanently remove the user by their ID
    }
}