package swa;

//import org.mybatis.spring.annotation.MapperScan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("swa.manage.mapper")
@Controller
public class ManageApplication implements WebMvcConfigurer {


    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }

    /**
     * 添加login页面
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    /**
     * 程序启动时运行（否则无法加载登录页面）
     */
    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class ManageSecurity extends WebSecurityConfigurerAdapter {
        @Resource
        private DataSource dataSource;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/reserve/*", "/staffRecord/*").hasAnyAuthority("USER", "ADMIN").and()
                    .authorizeRequests().antMatchers("/roomConfig/*").hasAuthority("ADMIN")
                    .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll().and()
                    .logout().permitAll();
        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication().dataSource(this.dataSource);
        }
    }
}
