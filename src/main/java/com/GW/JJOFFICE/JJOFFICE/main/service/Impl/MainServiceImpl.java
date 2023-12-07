package com.GW.JJOFFICE.JJOFFICE.main.service.Impl;

import com.GW.JJOFFICE.JJOFFICE.main.repository.MainRepository;
import com.GW.JJOFFICE.JJOFFICE.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    @Autowired
    private final MainRepository mainRepository;
    @Override
    public List<Map<String, Object>> getTestSelect() {
        return mainRepository.getTestSelect();
    }

    @Override
    public Map<String, Object> getTestOne(Map<String, Object> map) {
        return mainRepository.getTestOne(map);
    }
}
