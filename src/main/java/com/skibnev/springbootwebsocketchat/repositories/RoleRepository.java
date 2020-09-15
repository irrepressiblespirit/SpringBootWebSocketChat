package com.skibnev.springbootwebsocketchat.repositories;

import com.skibnev.springbootwebsocketchat.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
