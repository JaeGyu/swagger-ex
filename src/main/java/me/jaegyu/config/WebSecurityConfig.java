package me.jaegyu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable();
//		http.httpBasic().and().authorizeRequests().antMatchers("/dummy").fullyAuthenticated();
		//http.authorizeRequests().antMatchers("/dummy").authenticated();
//		http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
		http.cors().disable();
		http.headers().frameOptions().disable();
		http.csrf().disable();
//		http.httpBasic().and().authorizeRequests().antMatchers("/dummy").access("hasRole('USER')");
//		http.httpBasic().and().authorizeRequests().antMatchers("/dummy").permitAll();
//		http.authorizeRequests().antMatchers("/dummy");
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN", "DBA");
		auth.inMemoryAuthentication().withUser("alice").password("{noop}alice@12").roles("USER", "SETTING");
	}
	
}
