package ru.geekbraines.spring.winter.market.configs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;





@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j                                         
public class SecurityConfig extends WebSecurityConfigurerAdapter{ 
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .csrf().disable()// для Рестовой связи выключаем цсрф-токены
            .cors().disable()
            .authorizeRequests()
            .anyRequest().permitAll() // пока ко всем енд-пойнтам даем доступ 
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Сессия не используется (т.к. РЕСт, то выключаем сесссии) 
            .and()
            .headers().frameOptions().disable() // эот чтобы не отвалился доступ к h2 консоли
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
            // если польз-ль пытается зайти в какую-то защищенную область как гость, то ему вернется статус 401 (не авторизован)
     
    }
    
    
    @Bean        
    public BCryptPasswordEncoder  passwordEncoder() {   
        return new BCryptPasswordEncoder();
    }    

   

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
  //  создали дефолтного authenticationManager



}
