package com.GW.JJOFFICE.JJOFFICE.menu3.service.Impl;

import com.GW.JJOFFICE.JJOFFICE.menu3.repository.Menu3Repository;
import com.GW.JJOFFICE.JJOFFICE.menu3.service.Menu3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Menu3ServiceImpl implements Menu3Service {
    @Autowired
    private final Menu3Repository menu3Repository;
}
