package com.GW.JJOFFICE.JJOFFICE.document.service;

import java.util.List;
import java.util.Map;

public interface DocumentService {
    int getDocBoxTotal(Map<String, Object> map);
    List<Map<String, Object>> getDocBoxList(Map<String, Object> map);
    Map<String, Object> getDocInfoOne(String docSn);
    String setDocumentInfo(Map<String, Object> map);
    int getDocListTotal (Map<String, Object> map);
    List<Map<String, Object>> getDocList(Map<String, Object> map);
    Map<String, Object> getDocumentInfoOne(String docSn);
}
