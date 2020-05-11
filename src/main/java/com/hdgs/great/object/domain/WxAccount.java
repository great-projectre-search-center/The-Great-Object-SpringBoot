package com.hdgs.great.object.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
public class WxAccount implements UserDetails {
    private Integer uid;//用户id

    private String open_Id;
    private String session_Key;

    private String nick_Name;//昵称
    private String gender;//性别
    private String city;//城市
    private String province;//省份
    private String country;//国家
    private String avatar_Url;//头像地址
    private String encoded_Password;//加密的密码

    //日志属性
    private String created_User;
    private Date created_Time;
    private String modified_User;
    private Date modified_Time;

    //无参构造方法
    public WxAccount() {

    }

    //open_ID和session_Key的构造方法
    public WxAccount(String open_Id, String session_Key) {
        this.open_Id = open_Id;
        this.session_Key = session_Key;
    }

    //open_Id,nick_Name,encoded_Password的构造方法
    public WxAccount(String open_Id, String nick_Name, String encoded_Password) {
        this.open_Id = open_Id;
        this.nick_Name = nick_Name;
        this.encoded_Password = encoded_Password;
    }

    //全属性的构造方法
    public WxAccount(Integer uid, String open_Id, String session_Key, String nick_Name, String gender, String city, String province, String country, String avatar_Url, String encoded_Password, String created_User, Date created_Time, String modified_User, Date modified_Time) {
        this.uid = uid;
        this.open_Id = open_Id;
        this.session_Key = session_Key;
        this.nick_Name = nick_Name;
        this.gender = gender;
        this.city = city;
        this.province = province;
        this.country = country;
        this.avatar_Url = avatar_Url;
        this.encoded_Password = encoded_Password;
        this.created_User = created_User;
        this.created_Time = created_Time;
        this.modified_User = modified_User;
        this.modified_Time = modified_Time;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        ArrayList<SimpleGrantedAuthority> grantedAuthoritys = new ArrayList<>();
        grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_WXUSER"));

        return grantedAuthoritys;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return String.valueOf(uid);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
