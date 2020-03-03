package com.example.party2.configuration;

import com.example.party2.model.entity.MemberSession;
import com.example.party2.repository.MemberSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class SessionIdFilter extends OncePerRequestFilter {

    @Autowired
    private MemberSessionRepository memberSessionRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String header = httpServletRequest.getHeader("Authorization");
        if(header != null){
           MemberSession memberSession =  memberSessionRepository
                    .findBySessionIdAndIsValidTrue(header);
            if(memberSession != null){
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(
                        memberSession.getMember(),
                        null,
                        new ArrayList<>()
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
