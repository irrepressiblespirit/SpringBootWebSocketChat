package com.skibnev.springbootwebsocketchat.repositories;

import com.skibnev.springbootwebsocketchat.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
