package com.jobfreelance.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobfreelance.service.util.JwtUserDetailsService;
import com.jobfreelance.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final List<String> EXCLUDE_ENDPOINTS = Arrays.asList("/", "/**", "/swagger-ui.html", "/*swagger-resources/**");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);

            try {

                username = jwtTokenUtil.getUsernameFromToken(jwtToken);

            } catch (IllegalArgumentException e) {
                log.error("Unable to get JWT Token");

            } catch (ExpiredJwtException e) {
                log.error("JWT Token has expired");
            }
        } else {

            logger.warn("JWT Token does not begin with Bearer String");
        }


        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }
        chain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest httpServletRequest) {
        return EXCLUDE_ENDPOINTS.stream().anyMatch(x -> new AntPathMatcher().match(x, httpServletRequest.getServletPath()));
    }
}
