package swa.manage.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jinyan on 8/8/17 5:40 PM.
 */

@EnableWebSecurity
public class ManageSecurity extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ManageSecurity.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/manage/login", "/manage/index", "common/login").permitAll()
                .antMatchers("/reserve/**").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/manage/login").failureUrl("/roomConfig/roomConfigIndex");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}