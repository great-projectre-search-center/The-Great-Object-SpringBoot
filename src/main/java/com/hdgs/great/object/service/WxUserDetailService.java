package com.hdgs.great.object.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface WxUserDetailService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
