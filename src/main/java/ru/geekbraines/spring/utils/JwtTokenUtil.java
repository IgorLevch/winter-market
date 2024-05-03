package ru.geekbraines.spring.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class JwtTokenUtil { // класс, который полностью будет обрабатывать джейсон веб-токена
    // как генерирует токен, так и парсит его (т.е.наоборот, вынимает данные,зашитые в нем)

    
    @Value("${jwt.secret}")
    private String secret; // секретный ключ для генерации и валидации токена 

    @Value("${jwt.lifetime}")
    private Integer jwtLifetime;  // время жизни токена 

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();  // некие полезные данные, которые мы хотим зашить в токен дополнтильено 
        List<String> rolesList = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()); // преобразуем список ролей к листу строк 
        claims.put("roles", rolesList); // кладем в claims

        Date issuedDate = new Date(); // дата выпуска токена
        Date expiredDate = new Date(issuedDate.getTime() + jwtLifetime); // когда время жизни токена закончится
        return Jwts.builder()  // сборщик токенов 
                .setClaims(claims) // положи в пейлоад нашу Мапу
                .setSubject(userDetails.getUsername()) // в качестве Subject - имя пользователя
                .setIssuedAt(issuedDate)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secret) // здесь и выше: положи в токен дату выпуска, время жизни, алгоритм шифрования
                // с нашим серкетным ключом 
                .compact(); // собери токен 
    }

    // ниже идут методы для парсинга токена (вывтаскиваем полезную инфо из него, когда он нам придет): 


    // методом  getAllClaimsFromToken вытаскиваем все данные из токена 
    //  а у результата запрашиваем имя пользователя (getSubject())
    public String getUsernameFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    // методом  getAllClaimsFromToken вытаскиваем все данные из токена 
    //  а у результата запрашиваем роли get("roles", List.class)
    public List<String> getRoles(String token) {
        return getAllClaimsFromToken(token).get("roles", List.class);
    }


    // основной метод для парсинга токена (из токена достаем пейлоад): 
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()  // создается парсер 
                .setSigningKey(secret) // ему отдается ключ
                .parseClaimsJws(token)  // ему отадется токен, чтобы он сделал, собственно, парсинг 
                .getBody();
    }


}
