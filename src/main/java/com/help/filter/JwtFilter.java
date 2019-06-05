package com.help.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String auth = req.getHeader("authorization");
        if("OPTIONS".equals(req.getMethod())){
            res.setStatus(200);
            filterChain.doFilter(req,res);
        }else{
            if(auth == null || !auth.startsWith("Bearer ")){
                throw new ServletException("miss auth");
            }
            String token = auth.substring(7);
            Claims claims = Jwts.parser().setSigningKey("myjwtsecret")
                    .parseClaimsJws(token)
                    .getBody();
            req.setAttribute("username",claims.get("username"));
            filterChain.doFilter(req,res);
        }
    }
}
