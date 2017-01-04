package com.procesa.user.service.service;

import com.procesa.user.service.domain.User;
import com.procesa.user.service.domain.UserRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Luis Cano <garfenter at adstter.com>
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        user.setStatus("ACTIVE");
        user.setCreationDate(new Date());
        return userRepository.save(user);
    }

}
