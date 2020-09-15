package com.skibnev.springbootwebsocketchat.service.impl;

import com.skibnev.springbootwebsocketchat.domain.Role;
import com.skibnev.springbootwebsocketchat.domain.User;
import com.skibnev.springbootwebsocketchat.repositories.UserRepo;
import com.skibnev.springbootwebsocketchat.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(s);

        if (user == null) {
            log.error("User with name: " + s + " not found in database");
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    @Override
    public boolean saveUser(User user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if (userFromDB != null) {
            log.info("User already exists in the database");
            return false;
        }
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return true;
    }

}
