package com.WhellsFirePB.WhellsFirePB.Model;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyAppUserService  implements UserDetailsService {

    @Autowired
    private MyappUserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyAppUser> user = Optional.ofNullable(repository.findByEmail(username));
        if(user.isPresent()){
            var userOBj = user.get();
            return User.builder()
                    .username(userOBj.getNome())
                    .password(userOBj.getSenha())
                    .roles("USER")
                    .build();
        }else{
            throw new UsernameNotFoundException(username);
        }
    }
}
