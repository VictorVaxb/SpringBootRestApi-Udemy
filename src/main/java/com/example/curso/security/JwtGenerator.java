package com.example.curso.security;

import org.springframework.stereotype.Component;

import com.example.curso.contants.Contants;
import com.example.curso.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {
	
	public String generate(JwtUser jwtUser) {
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUserName());
		claims.put(Contants.USER_ID, String.valueOf(jwtUser.getId()));
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, Contants.YOUR_SECRET)
				.compact();
	}

}
