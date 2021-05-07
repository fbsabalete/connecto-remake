package com.fernando.connecto.security;

import com.fernando.connecto.model.User;
import com.fernando.connecto.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TokenAuthFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private List<String> skipUrls = Arrays.asList("/user/new", "/user/login");
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    public TokenAuthFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return skipUrls.stream().anyMatch(p -> pathMatcher.match(p, request.getRequestURI()));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request.getAuthType());
        String token = getToken(request);
        boolean valid = tokenService.validateToken(token);
        if(valid){
            authenticateUser(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticateUser(String token) {
        User user = tokenService.getUserFromToken(token);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7);
    }
}
