package com.GW.JJOFFICE.JJOFFICE.auth.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
public class CustomUserDetail implements UserDetails {
    private EmployeeDto employeeDto;
    public CustomUserDetail(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return employeeDto.getRole();
            }
        });

        return collection;
    }

    @Override
    public String getPassword() {
        return employeeDto.getEmpLoginPw();
    }

    @Override
    public String getUsername() {
        return employeeDto.getEmpLoginId();
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
