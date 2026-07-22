package hn.ficohsa.msvc_ficohsa_insurance.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService {
  private final JwtProperties properties;

  private Key getKey() {
    return Keys.hmacShaKeyFor(properties.getSecret().getBytes(StandardCharsets.UTF_8));
  }

  public String generateToken(UserDetails user) {
    Date now = new Date();
    Date expire = new Date(now.getTime() + properties.getExpiration());

    return Jwts.builder()
        .subject(user.getUsername())
        .issuedAt(now)
        .expiration(expire)
        .signWith(getKey())
        .compact();

  }

  public String extractUsername(String token) {
    return extractClaims(token).getSubject();
  }

  public boolean isTokenValid(String token, UserDetails user) {
    return user.getUsername().equals(extractUsername(token))
        && !extractClaims(token).getExpiration().before(new Date());
  }

  private Claims extractClaims(String token) {
    return Jwts.parser()
        .verifyWith((SecretKey) getKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }
}
