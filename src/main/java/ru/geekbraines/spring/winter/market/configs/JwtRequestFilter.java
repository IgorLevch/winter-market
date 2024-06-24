// package ru.geekbraines.spring.winter.market.configs;




// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;
// import ru.geekbraines.spring.winter.market.utils.JwtTokenUtil;


// import java.io.IOException;
// import java.util.stream.Collectors;




// @Component
// @RequiredArgsConstructor
// @Slf4j
// public class JwtRequestFilter extends OncePerRequestFilter { // создаем свой собственный фильтр (фильтр включается в работу, когда 
//     // пользователь стучится в защищенную область )
// // OncePerRequestFilter  - работает 1 раз на запрос 

    
    // private final JwtTokenUtil jwtTokenUtil;


    // // проверяем наличие токена у польз-ля: 
    // @Override
    // protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
    // FilterChain filterChain) throws ServletException, IOException {
    //     String authHeader = request.getHeader("Authorization");// запрос пролетает сквозь фильтр и мы первым делом смотрим хедер 
    //     // Authorization, т.к. фильтр находится в нем 

    //     String username = null;
    //     String jwt = null;
    //     if (authHeader != null && authHeader.startsWith("Bearer ")) { // по http значениетокена должно начинаться со слова Bearer + пробел
    //         jwt = authHeader.substring(7);
    //         username = jwtTokenUtil.getUsernameFromToken(jwt); // с помощью утилит вытаскиваем юзернейм из токена 
    //     }  // в методе происходит сразу и парсинг токена и его валидация 

    //     if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
    //         // если юзернейм нормальный, то мы в обход мех-в СпрингСекьюрити этого польз-ля кладем в контекст: 
    //         //это происходит так:  формируем - new UsernamePasswordAuthenticationToken (гооврим, что воздадим объект с username и
    //         //такими-то ролями: null, jwtTokenUtil.getRoles(jwt).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    //         //и кладем в контекст -- SecurityContextHolder.getContext().setAuthentication(token);)

    //         UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
    //         (username, null, jwtTokenUtil.getRoles(jwt).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    //         SecurityContextHolder.getContext().setAuthentication(token);
    //     }

    //     filterChain.doFilter(request, response);
    // }


// }
