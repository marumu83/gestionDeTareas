package com.viewnext.gestiontareas.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.viewnext.gestiontareas.config.filter.JwtAuthenticationFilter;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Configuration
@EnableWebSecurity
public class HttpSecutirtyConfig {
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		
		http
			.csrf(csrfConfig -> csrfConfig.disable())
			.sessionManagement(sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authenticationProvider(authenticationProvider)
			.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
			.authorizeHttpRequests( authConfig -> {
				
				authConfig.requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll();				
				authConfig.requestMatchers(HttpMethod.POST, "/apir/usuarios/all").hasAnyRole("ADMIN");
				authConfig.requestMatchers(HttpMethod.POST, "/apir/usuarios/nuevo").hasAnyRole("USER");
				authConfig.requestMatchers(HttpMethod.POST, "/apir/usuarios/nombre").hasAnyRole("USER");
				authConfig.requestMatchers(HttpMethod.POST, "/apir/usuarios/email").hasAnyRole("USER");
				authConfig.requestMatchers(HttpMethod.POST, "/api/tareas/nueva").hasAnyRole("USER");
				authConfig.requestMatchers(HttpMethod.POST, "/api/tareas/all").hasAnyRole("USER");
				authConfig.requestMatchers(HttpMethod.POST, "/api/tareas/id").hasAnyRole("USER");
				authConfig.requestMatchers(HttpMethod.POST, "/api/tareas/eliminar").hasAnyRole("USER");
				authConfig.requestMatchers(HttpMethod.POST, "/api/tareas/update").hasAnyRole("USER");
				authConfig.anyRequest().denyAll();				
			});				
		
		return http.build();
	}
}
