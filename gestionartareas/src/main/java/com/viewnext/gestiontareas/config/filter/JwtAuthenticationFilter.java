package com.viewnext.gestiontareas.config.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.viewnext.gestiontareas.persistence.model.Usuario;
import com.viewnext.gestiontareas.persistence.repository.UsuarioRepositorio;
import com.viewnext.gestiontareas.serviceimpl.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authHeader = request.getHeader("Authorization");
		
		if(authHeader == null || !authHeader.startsWith("Bearer")) {
			filterChain.doFilter(request, response);
						
			return;
		}
		
		String jwt = authHeader.split(" ")[1];
		
		String username = jwtService.extractUsername(jwt);
		
		Usuario usuario = usuarioRepositorio.findByNombre(username);
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
				username, null, usuario.getAuthorities());
		
		
		SecurityContextHolder.getContext().setAuthentication(authToken);
		
		filterChain.doFilter(request, response);
		
	}

}
