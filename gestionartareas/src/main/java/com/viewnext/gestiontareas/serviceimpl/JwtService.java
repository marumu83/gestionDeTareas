package com.viewnext.gestiontareas.serviceimpl;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.viewnext.gestiontareas.persistence.model.Usuario;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * @author Manuel Rubio
 * @author Jorge Garrido
 *
 */
@SuppressWarnings("deprecation")
@Service
public class JwtService {
	
	@Value("${security.jwt.secret-key}")
	private String SECRET_KEY;
	
	

	public String generateToken(Usuario usuario, Map<String, Object> stringObjectMap) {
		
		Date issuedAt = new Date(System.currentTimeMillis());
		Date expiration = new Date(issuedAt.getTime() + (30 * 60 * 1000));
		
		return Jwts.builder()
			.setClaims(stringObjectMap)
			.setSubject(usuario.getUsername())
			.setIssuedAt(issuedAt)
			.setExpiration(expiration)
			.setHeaderParam(Header.TYPE, Header.JWT_TYPE)
			.signWith(generateKey(), SignatureAlgorithm.HS256)
			.compact();	

	}
	
	//1:36
	private Key generateKey () {
		
		byte[] secretAsBytes = Decoders.BASE64.decode(SECRET_KEY);
		
		return Keys.hmacShaKeyFor(secretAsBytes);
	}


}
