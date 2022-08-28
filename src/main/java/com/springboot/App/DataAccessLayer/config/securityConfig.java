package com.springboot.App.DataAccessLayer.config;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// import com.springboot.App.DataAccessLayer.service.StudentsService;


@Configuration
@Order(1)
public class securityConfig  {

	
    @Bean
    public UserDetailsService MyUserDetailsService()
    {
        return new MyUserDetailsService();
    }

	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(MyUserDetailsService());
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
  
    @Bean
    public DaoAuthenticationProvider userAuthenticationProvider() 
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(MyUserDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    @Bean
    public SecurityFilterChain filterChainAdmin(HttpSecurity http) throws Exception
    {
        http.authenticationProvider(userAuthenticationProvider() );
        http.antMatcher("/admin/**").authorizeRequests().anyRequest().hasRole("ADMIN")
            .and()
            .formLogin()
                .loginPage("/admin/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/admin/login")
                .defaultSuccessUrl("/admin/display/students")
                .permitAll()
            .and()
                .logout().logoutUrl("/admin/logout")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
           

        return http.build();
    }
}