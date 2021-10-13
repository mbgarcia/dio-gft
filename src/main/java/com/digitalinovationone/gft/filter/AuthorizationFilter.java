package com.digitalinovationone.gft.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class AuthorizationFilter implements Filter {
	private static final String AUTHORIZATION_HEADER = "authorization";
	private static final String PASSWORD = "youpass";
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		
		if (PASSWORD.equals(request.getHeader(AUTHORIZATION_HEADER))) {
			chain.doFilter(req, resp);
		}
		else {
			HttpServletResponse response = (HttpServletResponse) resp;
			response.sendError(403);
		}
		
	}

}
