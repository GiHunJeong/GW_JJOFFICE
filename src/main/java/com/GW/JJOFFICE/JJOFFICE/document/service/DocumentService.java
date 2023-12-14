package com.GW.JJOFFICE.JJOFFICE.document.service;

import java.util.List;
import java.util.Map;

public interface DocumentService {
    int getDocBoxTotal();
    List<Map<String, Object>> getDocBoxList(Map<String, Object> map);
}
