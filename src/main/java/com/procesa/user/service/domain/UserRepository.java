package com.procesa.user.service.domain;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Juan Luis Cano <garfenter at adstter.com>
 */
public interface UserRepository extends Repository<User, Long> {

    Page<User> findAll(Pageable pagable);

    User save(User user);

    User findByDbid(Long dbid);
    
    List<User> findByName(String name);

}
