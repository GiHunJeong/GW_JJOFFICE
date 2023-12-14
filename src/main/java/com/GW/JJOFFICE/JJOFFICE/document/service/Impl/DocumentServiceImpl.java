package com.GW.JJOFFICE.JJOFFICE.document.service.Impl;

import com.GW.JJOFFICE.JJOFFICE.document.repository.DocumentRepository;
import com.GW.JJOFFICE.JJOFFICE.document.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private final DocumentRepository documentRepository;

    @Override
    public int getDocBoxTotal() {
        return documentRepository.getDocBoxTotal();
    }

    @Override
    public List<Map<String, Object>> getDocBoxList(Map<String, Object> map) {
        return documentRepository.getDocBoxList(map);
    }
}
