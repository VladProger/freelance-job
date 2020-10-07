package com.jobfreelance.service.util;

import com.jobfreelance.dto.UserCredentialsDto;
import com.jobfreelance.entity.UserEntity;
import com.jobfreelance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public UserCredentialsDto getUserByUcdmId(String ucdmId) throws UsernameNotFoundException {
        UserEntity user = userDao.findByUcdmId(ucdmId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with ucdmId: " + ucdmId);
        }
        return UserCredentialsDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .ucdmId(user.getUcdmId()).build();
    }

    public UserEntity save(UserCredentialsDto user) {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setUcdmId(UUID.randomUUID().toString());
        return userDao.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentialsDto user = getUserByUcdmId(username);
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}