package com.flat.management.configuration.filter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.flat.management.configuration.SecurityTokenManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
public class JwtAuthFilter implements Filter {

    private SecurityTokenManager securityTokenManager;

    public JwtAuthFilter(SecurityTokenManager securityTokenManager){
        this.securityTokenManager = securityTokenManager;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException{
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String authHeader = req.getHeader("Authorization");
        String token = null;
        if(!req.getRequestURI().endsWith("/register") && !req.getRequestURI().endsWith("/login")) {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
                try{
                    String user = securityTokenManager.validateToken(token);
//                    SecurityContextHolder.get
                }
                catch (SignatureVerificationException | JWTDecodeException e){
                    res.setHeader("X-error", "Token Invalid");
                    res.setStatus(401);
                    return;
                }
            } else {
                res.setHeader("X-error", "Authorization Token Not Theire.");
                res.setStatus(401);
                return;
            }
        }
        filterChain.doFilter(request, response);;
    }

}
