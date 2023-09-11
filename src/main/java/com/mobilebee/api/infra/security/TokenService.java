package com.mobilebee.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.mobilebee.api.users.DtoUser;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String API;

    public String g(DtoUser d){
        try{
            Algorithm a = Algorithm.HMAC256(API);
            return JWT.create()
            .withIssuer("API mobilebee.com")
            .withSubject(d.username())
            .withExpiresAt(t())
            .sign(a);
        } catch(JWTCreationException e){
            throw new RuntimeException("Erro ao gerar token", e);
        }
    }

    private Instant t(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String c(String k){
        try{
            Algorithm a = Algorithm.HMAC256(API);
            return JWT.require(a)
            .withIssuer("API mobilee.com")
            .build()
            .verify(k)
            .getSubject();
        } catch(JWTCreationException e){
            throw new RuntimeException("Token inválido ou expirado", e);
        }
    }

}
