package com.GW.JJOFFICE.JJOFFICE.auth.service;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.CustomUserDetails;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import com.GW.JJOFFICE.JJOFFICE.auth.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private final AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String empLoginId) throws UsernameNotFoundException {
        EmployeeDto employeeDto = authRepository.findByEmpId(empLoginId);
        if (employeeDto != null) {
            return new CustomUserDetails(employeeDto);
        }
        return null;
    }
}
