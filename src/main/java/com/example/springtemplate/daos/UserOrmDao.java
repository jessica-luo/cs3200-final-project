package com.example.springtemplate.daos;

import com.example.springtemplate.models.User;                                  // we'll CRUD User instances
import com.example.springtemplate.repositories.UserRestRepository;              // using User Repository
import org.springframework.beans.factory.annotation.Autowired;                  // autowired into the DAO
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class UserOrmDao {
    @Autowired
    // create an instance of the user
    UserRestRepository userRepository;                                          // repository and use it to implement
    // all these CRUD methods

    @GetMapping("/orm/users/create/{fn}/{ln}/{un}/{pw}/{em}/{db}")                     // return the user inserted into the
    public User createUser(@PathVariable("fn") String first,                    // database use parameters to create
                           @PathVariable("ln") String last,                     // new user instance
                           @PathVariable("un") String uname,
                           @PathVariable("pw") String pass,
                           @PathVariable("em") String email,
                           @PathVariable("db") Date date_of_birth)
    {
        User user = new User(first, last, uname, pass, email, date_of_birth);       // using the constructor
        // insert into database and
        return userRepository.save(user);                                      // return resulting record

        // when using @GetMapping and @Path Variable,
        // access the resource through HTTP, pass parameters in path, parse path, variables, and pass as parameters
        // create instance, insert into database, and return new record
    }


    @GetMapping("/orm/users/find")
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @GetMapping("/orm/users/find/id/{userId}")
    public User findUserById(
            @PathVariable("userId") Integer id) {
        return userRepository.findUserById(id);
    }

    @GetMapping("/orm/users/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Integer id) {                    // accept user's ID to be deleted
        userRepository.deleteById(id);                                              // use builtin deleteById method to
        // when @GetMapping and @PathVariable are used                              // remove record
        // encode user's ID at the end of the path
        // parse the user's ID from the path and pass as parameter
    }

    @GetMapping("/orm/users/update/{userId}/{password}")
    public User updateUser(@PathVariable("userId") Integer id, @PathVariable("password") String newPass) {
        User user = userRepository.findUserById(id);
        user.setPassword(newPass);
        return userRepository.save(user);
    }
}
