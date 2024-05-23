// package ru.geekbraines.spring.winter.market.controllers;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
        
// import lombok.RequiredArgsConstructor;
// import ru.geekbraines.spring.winter.market.dtos.JwtRequest;
// import ru.geekbraines.spring.winter.market.dtos.JwtResponse;
// import ru.geekbraines.spring.winter.market.services.UserService;
// import ru.geekbraines.spring.winter.market.utils.JwtTokenUtil;

// @RestController
// @RequiredArgsConstructor
// public class AuthController {
//     // в этом классе получаем токен по имени пользователя и паролю 


//     //  3 бина для аутентификации: 
//     private final UserService userService;
//     private final JwtTokenUtil jwtTokenUtil;
//     private final AuthenticationManager authenticationManager;

//     @PostMapping("/auth")  // POST-ом приходит логин-пароль в виде джейсон обьекта 
//     public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
//         try {
//             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//         } catch (BadCredentialsException e) {  // первым делом просим authenticationManager проверить этого пользователя
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // вернем 401 , если не авторизован 
// //            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Incorrect username or password"), HttpStatus.UNAUTHORIZED);
//         }
//         UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername()); // далее из базы находим этого юзера 
//         // и достаем в виде userDetails -- очень усеченный вид. в котором есть только логин и список ролей 
//         String token = jwtTokenUtil.generateToken(userDetails); // по этому юзеру просим собрать токен 
//         return ResponseEntity.ok(new JwtResponse(token)); // клиенту возвращаем токен 
//     }

//     @GetMapping("/secured")
//     public String helloSecurity() {
//         return "Hello";
//     }


// }
