package com.comprasapp.comprasapp.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenService {

    private final String JWT_KEY = "12345678ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567812345678";
    private final SecretKey key = Jwts.SIG.HS256.key().build();
    public String createToken(String username){
        return Jwts.builder()
                .claim("usuari",username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60  * 24))
                .signWith(key) // asignar el token
                //.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(JWT_KEY.getBytes())) // asignar el token
                .compact();
    }

    // se recomienda que devuelva un objeto ENUM
    public boolean isValidToken(String token){
        try{
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public Claims getClaims (String token){
        try{
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        }catch (Exception e){
            return null;
        }
    }

}
