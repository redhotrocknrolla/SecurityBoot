package com.example.securityboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.securityboot.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.getUserByName(name);
        user.getAuthorities().size();
        if(user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", name));
        }
        return user;
    }
}
