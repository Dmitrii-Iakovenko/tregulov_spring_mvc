package com.wutreg.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Autowired
    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);


//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//            .withUser(userBuilder
//                .username("заур")
//                .password("заур")
//                .roles("EMPLOYEE"))
//
//            .withUser(userBuilder
//                .username("elena")
//                .password("elena")
//                .roles("HR"))
//
//            .withUser(userBuilder
//                .username("ivan")
//                .password("ivan")
//                .roles("MANAGER", "HR"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);

        http.authorizeRequests()
            .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
            .antMatchers("/hr_info").hasRole("HR")
            .antMatchers("/manager_info").hasRole("MANAGER")
            .and().formLogin().permitAll()
            .and().logout().permitAll();
    }
}
