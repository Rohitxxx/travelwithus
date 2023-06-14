package com.spirale.TourPackages.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spirale.TourPackages.service.CustomerService;
import com.spirale.TourPackages.util.JwtUtil;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	CustomerService customerService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// get jwt
		//Is it start from bearer
		//If it start from bearer then we validate
	String requestTokenHeader=	request.getHeader("Authorization"); 
	String userName=null;
	String jwtToken=null;
	if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
		jwtToken=requestTokenHeader.substring(7);
		
		try {
			
		userName=	jwtUtil.extractUsername(jwtToken);
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	UserDetails userDetails=	customerService.loadUserByUsername(userName);
		//security
		
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken	 =new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}else {
			
		}
		
	}
	filterChain.doFilter(request, response);
		
	}

}
