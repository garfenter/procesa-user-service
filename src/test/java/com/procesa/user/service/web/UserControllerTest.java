package com.procesa.user.service.web;

import com.procesa.user.service.domain.User;
import com.procesa.user.service.domain.UserRepository;
import com.procesa.user.service.service.web.UserController;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Juan Luis Cano <garfenter at adstter.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private UserController userController;
    
    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUserTest() {
        given(this.userRepository.findByDbid(1l)).willReturn(new User() {
            {
                this.setDbid(1l);
                this.setName("test");
                this.setEmail("test@test.com");
                this.setCreationDate(new Date());
                this.setStatus("ACTIVE");
            }
        });
        User user = this.userController.findUserByDbid(1l);
        assertThat(user.getDbid()).isEqualTo(1l);
        assertThat(user.getName()).isEqualTo("test");
        assertThat(user.getEmail()).isEqualTo("test@test.com");
    }
    
}
