package example.archive.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

     // конфиг, позволяет реализовать авторизацию, систему ролей и т.д.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()// TODO: 6/22/21 check
                    .and()
                .authorizeRequests()
                .antMatchers("**").permitAll()// дает доступ на все без авторизации
                    .and()
                .csrf().disable();//так надо
    }
}
