package com.example.curso.security;

import org.springframework.stereotype.Component;

import com.example.curso.contants.Contants;
import com.example.curso.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	
	public JwtUser validate(String token) {
		JwtUser jwtUser = null;
		
		try {
			Claims body = Jwts.parser()
					.setSigningKey(Contants.YOUR_SECRET)
					.parseClaimsJws(token)
					.getBody();
			
			jwtUser = new JwtUser();
			jwtUser.setUserName(body.getSubject());
			jwtUser.setId(Long.parseLong((String)body.get(Contants.USER_ID)));
			
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return jwtUser;
	}

}
