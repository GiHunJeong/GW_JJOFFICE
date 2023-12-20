package com.GW.JJOFFICE.JJOFFICE.admin.board.service;

import java.util.List;
import java.util.Map;

public interface BoardAdminService {
    List<Map<String, Object>> getBoardFolderList();
    String setBoardFolderOne(Map<String, Object> map);
}
