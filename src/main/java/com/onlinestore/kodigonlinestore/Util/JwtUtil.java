package com.onlinestore.kodigonlinestore.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "KODIGO_PLEASE_I_NEED_A_JOB";

    private static final int TOKEN_VALIDITY =3600*5;

    public String getUserNameFromToken(String Token){
        return getClaimFromToken(Token, Claims::getSubject);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> resolver){
        final Claims claims = getAllClaimsFromToken(token);
        return resolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public boolean validateToken(String token, UserDetails details){
        String user = getUserNameFromToken(token);
        return (user.equals(details.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
       final Date expirationDate = getExpirationDateToken(token);
        return expirationDate.before(new Date());
    }

    private Date getExpirationDateToken(String token){
        return getClaimFromToken(token,Claims::getExpiration);
    }

    public String generateToken(UserDetails details){
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(details.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact()
                ;
    }

}
