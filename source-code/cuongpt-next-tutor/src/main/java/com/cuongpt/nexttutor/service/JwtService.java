package com.cuongpt.nexttutor.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Service for JWT token generation and validation.
 * 
 * @author Next Tutor Team
 * @since 1.0.0
 */
@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key:404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970}")
    private String secretKey;

    @Value("${application.security.jwt.expiration:86400000}")
    private long jwtExpiration;

    /**
     * Generates a JWT token for the given user ID.
     * 
     * @param userId the user ID to include in the token
     * @return the generated JWT token
     */
    public String generateToken(UUID userId) {
        return generateToken(new HashMap<>(), userId);
    }

    /**
     * Generates a JWT token with additional claims.
     * 
     * @param extraClaims additional claims to include
     * @param userId      the user ID to include in the token
     * @return the generated JWT token
     */
    public String generateToken(Map<String, Object> extraClaims, UUID userId) {
        return buildToken(extraClaims, userId, jwtExpiration);
    }

    /**
     * Builds a JWT token with the specified parameters.
     * 
     * @param extraClaims additional claims
     * @param userId      user ID
     * @param expiration  expiration time in milliseconds
     * @return the JWT token
     */
    private String buildToken(
            Map<String, Object> extraClaims,
            UUID userId,
            long expiration) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(userId.toString())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey())
                .compact();
    }

    /**
     * Gets the signing key for JWT operations.
     * 
     * @return the secret key
     */
    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public UUID extractUserId(String token) {
        final io.jsonwebtoken.Claims claims = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return UUID.fromString(claims.getSubject());
    }
}
