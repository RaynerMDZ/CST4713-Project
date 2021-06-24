package edu.citytech.cst.s23253396.cst4713project.security.configuration;

import edu.citytech.cst.s23253396.cst4713project.security.services.JsonUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final JsonUserDetailService jsonUserDetailService;

    public SecurityConfiguration(JsonUserDetailService jsonUserDetailService) {
        this.jsonUserDetailService = jsonUserDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jsonUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .and()
                .authorizeRequests().anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");

//        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
//        http.authorizeRequests().antMatchers("/").permitAll().and()
//                .authorizeRequests().antMatchers("/h2-console/**").permitAll();
//        http.csrf().disable();
//        http.headers().frameOptions().disable();

    }

//    @Bean
//    public ServletRegistrationBean h2servletRegistration(){
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
//        registrationBean.addUrlMappings("/h2-console/*");
//        return registrationBean;
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
