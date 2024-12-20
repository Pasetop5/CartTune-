package finalCarTune.CARTUNE.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import finalCarTune.CARTUNE.Service.CustomSuccessHandler;
import finalCarTune.CARTUNE.Service.CustomUSerDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomSuccessHandler customSuccessHandler; // dependency injection


@Autowired
    CustomUSerDetailService customUSerDetailService;// dependency injection


    @Bean
    public static PasswordEncoder passwordEncoder(){ // password encoder
        return  new BCryptPasswordEncoder();

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/Assests/**").permitAll()
                        .requestMatchers("/appointment-success").hasAuthority("USER") // Allow access to the success page
                        .requestMatchers("/user-appointments").hasAuthority("USER")
                        .requestMatchers("/user/appointments").hasAuthority("USER")
                        .requestMatchers("/admin-page").hasAuthority("ADMIN")
                        .requestMatchers("/user-page").hasAuthority("USER")
                        .requestMatchers("/registration", "/admin/registration", "/styles.css").permitAll()
                        .requestMatchers("/CarImages","/HomePage","/CarInfo").permitAll()
                        .anyRequest().authenticated()
                )


                .formLogin(form -> form
                        .loginPage("/login").loginProcessingUrl("/login")
                        .successHandler(customSuccessHandler).permitAll()
                )
                .logout(form -> form
                        .invalidateHttpSession(true).clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout").permitAll()
                );

        return http.build();
    }

    @Autowired
    public  void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUSerDetailService).passwordEncoder(passwordEncoder());

            }




}
