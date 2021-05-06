package com.fernando.connecto.service;

import com.fernando.connecto.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${connecto.jwt.expiration}")
    private String expiration;
    @Value("${connecto.jwt.secret}")
    private String secret;

    public String generateToken(User user){
        Date current = new Date();
        Date expirationDate = new Date(current.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("Connecto Application")
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(current)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

}
