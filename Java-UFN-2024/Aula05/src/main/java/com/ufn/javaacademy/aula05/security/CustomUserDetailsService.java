package com.ufn.javaacademy.aula05.security;


import com.ufn.javaacademy.aula05.model.Usr;
import com.ufn.javaacademy.aula05.repository.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsrRepository usrRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usr usr = usrRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        return User.withUsername(usr.getUsername())
                .password(usr.getPassword())
                .roles(usr.getRole().split(","))
                .build();
    }
}
