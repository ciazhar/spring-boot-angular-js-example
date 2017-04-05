package com.ciazhar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.sql.DataSource;

/**
 * Created by ciazhar on 3/30/17.
 */

@Configuration
@EnableWebSecurity
public class KonfigurasiSecurity extends WebSecurityConfigurerAdapter{

    private static final String SQL_LOGIN = "select username, password, enabled "
            + "from user where username = ?";
    private static final String SQL_PERMISSION =
            "select u.username as username, p.nama_permission as authority "
            + "from user u "
            + "inner join user_role ur on u.id_user = ur.id_user "
            + "inner join role r on ur.id_role = r.id_role "
            + "inner join role_permission rp on rp.id_role = r.id_role "
            + "inner join permission p on rp.id_permission = p.id_permission "
            + "where u.username = ?";



    @Autowired
    DataSource dataSource;

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(SQL_LOGIN)
                .authoritiesByUsernameQuery(SQL_PERMISSION)
                /*.passwordEncoder(passwordEncoder())*/;
    }


//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        //setting security non database
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password("123")
//                .roles("OPERATOR");
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/css/**","/js/**").permitAll()
                .antMatchers("/aplikasi/form","/versi/form").hasAuthority("EDIT")
                .antMatchers(HttpMethod.POST).hasAuthority("EDIT")
                .antMatchers(HttpMethod.DELETE).hasAuthority("EDIT")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .and()
                .addFilterAfter(new CsrfAttributeToCookieFilter(), CsrfFilter.class)
                .csrf().csrfTokenRepository(csrfTokenRepository());
        ;
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
}
