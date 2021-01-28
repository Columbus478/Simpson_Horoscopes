/**
 * 
 */
package com.Simpson_Horoscopes.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Samuel Columbus Jan 27, 2021
 */
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private AuthenticationEntryPoint authEntryPoint;

  @Bean
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("admin123").password(encoder().encode("password"))
        .roles("USER");

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
    .csrf().disable()
    .authorizeRequests().anyRequest().authenticated()
    .and()
//    .httpBasic().authenticationEntryPoint(authEntryPoint);
    //Let's use Okta OAuth 2.0 with OpenID Connect
    .oauth2ResourceServer().jwt();
  }
}
