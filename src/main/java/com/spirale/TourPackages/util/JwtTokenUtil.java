package com.spirale.TourPackages.util;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	
	    @Value("${jwt.secret}")
	    private String secret;

	    @Value("${jwt.expiration}")
	    private Long expiration;

	    public String generateToken(Authentication authentication) {
	        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
	        Date now = new Date();
	        Date expiryDate = new Date(now.getTime() + expiration);

	        return Jwts.builder()
	                .setSubject(userPrincipal.getUsername())
	                .setIssuedAt(now)
	                .setExpiration(expiryDate)
	                .signWith(SignatureAlgorithm.HS512, secret)
	                .compact();
	    }

	    public boolean validateToken(String token) {
	        try {
	            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public String getUsernameFromToken(String token) {
	        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	        return claims.getSubject();
	    }
	}
