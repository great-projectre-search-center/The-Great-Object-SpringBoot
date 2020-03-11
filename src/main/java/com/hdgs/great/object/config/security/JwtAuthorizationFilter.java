package com.hdgs.great.object.config.security;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.hdgs.great.object.config.security.GrantedAuthority.WxAuthenticationToken;
import com.hdgs.great.object.repository.WxAccountRepository;
import com.hdgs.great.object.service.JwtTokenServiceImpl;
import com.hdgs.great.object.util.HttpServletResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Autowired
    JwtTokenServiceImpl jwtTokenService;

    @Autowired
    WxAccountRepository wxAccountRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token != null && !token.equals("")) {
            try {
                int a = 123;
                Integer id = jwtTokenService.VerifyToken(token);
                UserDetails wxAccount = wxAccountRepository.findById(id);
                ArrayList<SimpleGrantedAuthority> grantedAuthoritys = new ArrayList<>();
                grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_WXUSER"));
                WxAuthenticationToken authenticationToken = new WxAuthenticationToken(wxAccount, id, grantedAuthoritys);

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);


            } catch (TokenExpiredException e) {
                //TODO: token过期
                HttpServletResponseUtil.returnString(response, "TokenExpiredException");
            } catch (SignatureVerificationException e) {
                //TODO: token验证失败
                HttpServletResponseUtil.returnString(response, "SignatureVerificationException");
            }
        }

        filterChain.doFilter(request, response);
    }
}
