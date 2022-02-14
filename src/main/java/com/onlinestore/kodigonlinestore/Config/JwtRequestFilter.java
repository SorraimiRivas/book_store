package com.onlinestore.kodigonlinestore.Config;

import com.onlinestore.kodigonlinestore.Service.JwtService;
import com.onlinestore.kodigonlinestore.Util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtService service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String header = request.getHeader("Authorization");
        String jwtToken= null;
        String useName= null;
        if(!Objects.isNull(header) && header.startsWith("Bearer ")){
            jwtToken = header.substring(7);

            try{
                useName = jwtUtil.getUserNameFromToken(jwtToken);
            }catch (IllegalArgumentException e){
                System.out.println("Unable to get JWT Token");
            }catch (ExpiredJwtException e){
                System.out.println("JWT Token is expired");
            }
        }else {
            System.out.println("Jwt Token does not start with Bearer");
        }

        if(!Objects.isNull(useName) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())){
            UserDetails details = service.loadUserByUsername(useName);

            if(jwtUtil.validateToken(jwtToken,details)){
                UsernamePasswordAuthenticationToken userPAT
                        = new UsernamePasswordAuthenticationToken(details,
                        null,
                        details.getAuthorities());

                userPAT.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(userPAT);
            }
        }

        filterChain.doFilter(request,response);
    }
}
