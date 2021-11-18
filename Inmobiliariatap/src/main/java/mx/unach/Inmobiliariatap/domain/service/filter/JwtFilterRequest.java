package mx.unach.Inmobiliariatap.domain.service.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import mx.unach.Inmobiliariatap.domain.service.BuildingUserDetailsService;
import mx.unach.Inmobiliariatap.web.security.JWTUtil;

@Component("jwtFilterRequest")
public class JwtFilterRequest extends OncePerRequestFilter{
	
	@Autowired
	@Qualifier("jwtUtil")
	private JWTUtil jwtUtil;
	
	@Autowired
	@Qualifier("buildingUserDetailsService")
	private BuildingUserDetailsService buildingUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader = request.getHeader("Authorization");
		
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
			String jwt = authorizationHeader.substring(7);
			String username = jwtUtil.extractUsername(jwt);
			
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = buildingUserDetailsService.loadUserByUsername(username);
				
				if (jwtUtil.validateToken(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

	
	
}
