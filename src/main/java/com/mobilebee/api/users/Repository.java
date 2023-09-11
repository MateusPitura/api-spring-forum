package com.mobilebee.api.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface Repository extends JpaRepository<User, Long>{
    UserDetails findByUsername(String user);
}
