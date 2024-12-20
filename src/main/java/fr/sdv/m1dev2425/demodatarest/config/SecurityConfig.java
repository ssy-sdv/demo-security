package fr.sdv.m1dev2425.demodatarest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig {

    PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /** * Déclaration des utilisateurs en mémoire de l'application avec leur mot de passe chiffré et leurs rôles */
    /*@Bean
    InMemoryUserDetailsManager userDetailsManager() {

        UserDetails sega = User.builder().username("ssylla").password(passwordEncoder.encode("ssy")).roles("USER", "ADMIN").build();
        UserDetails lass = User.builder().username("lsylla").password(passwordEncoder.encode("lass")).roles("USER").build();
        //TODO d'autres utilisateurs
        return new InMemoryUserDetailsManager(sega, lass);
    }*/
    /** * Récupération des utilisateurs de l'application via la base de données */
    @Bean
    JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("""
                SELECT login, pwd, `active`
                FROM person
                WHERE login=?
                """);
        userDetailsManager.setAuthoritiesByUsernameQuery("""
                SELECT p.login, r.label
                FROM role r
                INNER JOIN person_role pr ON r.id = pr.role_id
                INNER JOIN person p ON pr.person_id = p.id
                WHERE p.login=?
                """);
        return userDetailsManager;
    }


    /*@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests -> {
           authorizeRequests.requestMatchers("/rest/admin").hasRole("ADMIN");
        });
        return http.build();
    }*/
}
