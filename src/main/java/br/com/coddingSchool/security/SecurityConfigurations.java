package br.com.coddingSchool.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    AutenticationService autenticationService;

    public SecurityConfigurations(AutenticationService autenticationService) {
        this.autenticationService = autenticationService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/categories").hasRole("COMUM")
                .antMatchers(HttpMethod.GET,"/api/categories").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/admin/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/admin/*").hasRole("ADMIN")
                .antMatchers("/category/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll().and().csrf().disable();
    }

//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//    }
}
