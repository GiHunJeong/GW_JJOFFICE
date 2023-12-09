package com.GW.JJOFFICE.JJOFFICE.menu2.service.Impl;

import com.GW.JJOFFICE.JJOFFICE.menu2.repository.Menu2Repository;
import com.GW.JJOFFICE.JJOFFICE.menu2.service.Menu2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Menu2ServiceImpl implements Menu2Service {
    @Autowired
    private final Menu2Repository menu2Repository;
}
