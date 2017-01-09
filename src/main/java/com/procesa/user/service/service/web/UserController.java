package com.procesa.user.service.service.web;

import com.procesa.user.service.domain.User;
import com.procesa.user.service.domain.UserRepository;
import com.procesa.user.service.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Luis Cano <garfenter at adstter.com>
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public User findUserByDbid(@PathVariable Long user) {
        return userRepository.findByDbid(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<User> findAllUsers(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @RequestMapping(value = "/name/{user}", method = RequestMethod.GET)
    public List<User> findUserByName( @PathVariable String user) {
        return userRepository.findByName(user);
    }

}
