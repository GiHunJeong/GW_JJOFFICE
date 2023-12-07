package com.GW.JJOFFICE.JJOFFICE.main.service;

import java.util.List;
import java.util.Map;

public interface MainService {
    List<Map<String, Object>> getTestSelect();
    Map<String, Object> getTestOne(Map<String, Object> map);
}
