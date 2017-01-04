package com.procesa.user.service.service;

import com.procesa.user.service.domain.User;
import com.procesa.user.service.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


/**
 *
 * @author Juan Luis Cano <garfenter at adstter.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void createUserTest() {
        User user = new User();
        user.setName("test");
        user.setEmail("test@test.com");

        given(userRepository.save(user)).willReturn(user);
        
        User result = userService.createUser(user);
        assertThat(result.getEmail()).isEqualTo("test@test.com");
        assertThat(result.getName()).isEqualTo("test");
        assertThat(result.getStatus()).isEqualTo("ACTIVE");
        assertThat(result.getCreationDate()).isNotNull();
    }

}
