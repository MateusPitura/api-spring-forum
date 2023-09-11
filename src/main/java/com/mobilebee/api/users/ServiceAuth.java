package com.mobilebee.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceAuth implements UserDetailsService{

    @Autowired
    private Repository r;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return r.findByUsername(username);
    }    
}
