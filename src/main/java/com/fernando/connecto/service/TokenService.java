package com.fernando.connecto.service;

import com.fernando.connecto.model.User;
import com.fernando.connecto.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TokenService {

    @Autowired
    private UserRepository repository;

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
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        //.setExpiration(expirationDate)
    }

    public boolean validateToken(String token) {
        try{
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public User getUserFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        Long id = Long.parseLong(claims.getSubject());
        Optional<User> user = repository.findById(id);
        return user.get();
    }
}
