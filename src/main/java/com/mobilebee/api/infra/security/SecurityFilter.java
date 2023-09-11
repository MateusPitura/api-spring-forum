package com.mobilebee.api.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.mobilebee.api.users.Repository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

    @Autowired
    private TokenService k;

    @Autowired
    private Repository r;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain f) throws ServletException, IOException {
        var t = request.getHeader("Authorization");

        if(t!=null){
            var token = t.replace("Bearer ", "");
            var s = k.c(token);
            var u = r.findByUsername(s);
            var a = new UsernamePasswordAuthenticationToken(u, null, u.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(a);
        }

        f.doFilter(request, response);
    }
}
