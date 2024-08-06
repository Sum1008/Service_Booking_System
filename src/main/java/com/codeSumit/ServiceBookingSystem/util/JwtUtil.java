// package com.codeSumit.ServiceBookingSystem.util;

// import java.security.Key;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Function;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.JwtBuilder;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;

// @Component
// public class JwtUtil {

//     public static final String SECERT="9hS9ITQjrJJW7OcBmvjQ2IfOTZevat/pl+3YyNuXJi8=";

//     @SuppressWarnings("deprecation")
//     private String createToken(Map<String,Object> clains,String userName){
//         return Jwts.builder()
//         .setClaims(clains)
//         .setSubject(userName)
//         .setIssuedAt(new Date(System.currentTimeMillis()))
//         .setExpiration(new Date(System.currentTimeMillis()*1000*60*30))
//         .signWith(getSignKey(),SignatureAlgorithm.HS256).compact();
        
//     }

//     private Key getSignKey(){
//         byte[] keyBytes=Decoders.BASE64.decode(SECERT);
//         return Keys.hmacShaKeyFor(keyBytes);
//     }

//     private String genrateToken(String userName){
//         Map<String,Object> claims=new HashMap<>();
//         return createToken(claims, userName);
//     }

//     @SuppressWarnings("deprecation")
//     private Claims extractAllClaims(String token){
//         return Jwts
//                  .parser()
//                  .setSigningKey(getSignKey())
//                  .parseClaimsJws(token)
//                  .getBody();
//     }

//     public <T> T extractClaims(String token,Function<Claims,T> claimsResolver){
//         final Claims claims=extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }

//     public Date extractExpiration(String token){
//         return extractClaims(token,Claims::getExpiration) ;
//     }

//     public String extractUsername(String token){
//         return extractClaims(token, Claims::getSubject);
//     }

//     private Boolean isTokenExpired(String token){
//         return extractExpiration(token).before(new Date());

//     }

//     public Boolean validateToken(String token ,UserDetails userDetails){
//         final String username=extractUsername(token);
//         return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
//     }




// }
