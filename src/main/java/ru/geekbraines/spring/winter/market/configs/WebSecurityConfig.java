package ru.geekbraines.spring.winter.market.configs;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;





@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j                                       
public class WebSecurityConfig {    
// extends WebSecurityConfigurerAdapter
  //  private final JwtRequestFilter jwtRequestFilter;
    

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {

    //     http
    //         .csrf().disable()// для Рестовой связи выключаем цсрф-токены
    //         .cors().disable()
    //         .authorizeRequests()
    //         .anyRequest().permitAll() // пока ко всем енд-пойнтам даем доступ 
    //         .and()
    //         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Сессия не используется (т.к. РЕСт, то выключаем сесссии) 
    //         .and()
    //         .headers().frameOptions().disable() // эот чтобы не отвалился доступ к h2 консоли
    //         .and()
    //         .exceptionHandling()
    //         .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    //         // если польз-ль пытается зайти в какую-то защищенную область как гость, то ему вернется статус 401 (не авторизован)
     
    //         http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);    
    
    // }


        
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/js/**", "/css/**");
    }

    @Bean
   public  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("/").permitAll()
                                .anyRequest().permitAll()
                );
               /* .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());*/
        return http.build();
    }


    
    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }

    
    @Bean        
    public BCryptPasswordEncoder  passwordEncoder() {   
        return new BCryptPasswordEncoder();
    }    

    @Bean
    InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("HHH")
                .username("Admin")
                .password("admin")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    } 



    // @Override
    // @Bean
    // public AuthenticationManager authenticationManagerBean() throws Exception {
    //     return super.authenticationManagerBean();
    // }
  //  создали дефолтного authenticationManager  -- это который был изначально, по старому СпрингБуту



}
