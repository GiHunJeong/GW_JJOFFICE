package com.GW.JJOFFICE.JJOFFICE.personal.service.Impl;

import com.GW.JJOFFICE.JJOFFICE.personal.repository.PersonalRepository;
import com.GW.JJOFFICE.JJOFFICE.personal.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {
    @Autowired
    private final PersonalRepository personalRepository;
}
