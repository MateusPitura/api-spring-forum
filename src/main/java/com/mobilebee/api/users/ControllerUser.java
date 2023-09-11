package com.mobilebee.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobilebee.api.infra.security.TokenService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/login")
public class ControllerUser {
    
    @Autowired
    private AuthenticationManager a;

    @Autowired
    private TokenService s;

    @PostMapping
    @Transactional
    public ResponseEntity m(@RequestBody DtoUser d){
        var t = new UsernamePasswordAuthenticationToken(d.username(), d.password());
        var h = a.authenticate(t);
        var j = s.g((User) h.getPrincipal());
        return ResponseEntity.ok(new DtoToken(j));
    }
}
