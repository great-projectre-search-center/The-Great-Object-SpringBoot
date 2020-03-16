package com.hdgs.great.object.service;

import com.hdgs.great.object.repository.WxAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WxUserDetailServiceImpl implements WxUserDetailService {
    @Autowired
    WxAccountRepository wxAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails wxAccount = wxAccountRepository.findByOpenid(username);

        if (wxAccount == null) {
            throw new UsernameNotFoundException("wx account not found");
        } else {
            return wxAccount;
        }
    }
}
