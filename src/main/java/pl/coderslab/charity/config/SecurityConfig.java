package pl.coderslab.charity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.coderslab.charity.service.implementation.SpringDataUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception { //metoda konfigurujaca zachowania autoryzacyjne
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/*").authenticated()
                .antMatchers("/app/*").authenticated()
                .and().formLogin()
                .loginPage("/login")
                .permitAll();
        return http.build();
    }
    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
