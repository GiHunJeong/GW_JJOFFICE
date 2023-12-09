package com.GW.JJOFFICE.JJOFFICE.admin.service.Impl;

import com.GW.JJOFFICE.JJOFFICE.admin.repository.AdminPageRepository;
import com.GW.JJOFFICE.JJOFFICE.admin.service.AdminPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminPageServiceImpl implements AdminPageService {
    @Autowired
    private final AdminPageRepository adminPageRepository;

    @Override
    public List<Map<String, Object>> getEmployeeList() {
        return adminPageRepository.getEmployeeList();
    }
}
