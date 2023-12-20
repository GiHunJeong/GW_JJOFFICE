package com.GW.JJOFFICE.JJOFFICE.admin.board.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface BoardAdminRepository {
    List<Map<String, Object>> getBoardFolderList();
    Map<String, Object> getBoardFolderInfo(String boardFolderSn);
    void setBoardFolderOne(Map<String, Object> map);
    void setBoardFolderChileYn(String boardFolderUpperSn);
}
