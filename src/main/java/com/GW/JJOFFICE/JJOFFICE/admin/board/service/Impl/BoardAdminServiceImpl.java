package com.GW.JJOFFICE.JJOFFICE.admin.board.service.Impl;

import com.GW.JJOFFICE.JJOFFICE.admin.board.repository.BoardAdminRepository;
import com.GW.JJOFFICE.JJOFFICE.admin.board.service.BoardAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardAdminServiceImpl implements BoardAdminService {
    @Autowired
    private final BoardAdminRepository boardAdminRepository;
    @Override
    public List<Map<String, Object>> getBoardFolderList() {
        return boardAdminRepository.getBoardFolderList();
    }

    @Override
    public String setBoardFolderOne(Map<String, Object> map) {
        Map<String, Object> addMap = boardAdminRepository.getBoardFolderInfo(map.get("boardFolderUpperSn").toString());
        if(Integer.parseInt(addMap.get("board_folder_dept").toString())+1 > 2) return "더 이상 하위 메뉴를 추가할 수 없습니다.";
        map.put("boardFolderDept", String.valueOf(Integer.parseInt(addMap.get("board_folder_dept").toString())+1));
        map.put("boardFolderPath", addMap.get("board_folder_path").toString()+"|"+map.get("boardFolderName").toString());
        System.out.println(map);
        String result = "";
        try {
            boardAdminRepository.setBoardFolderOne(map);
            if(addMap.get("board_folder_child_yn").toString().equals("N")) {
                boardAdminRepository.setBoardFolderChileYn(map.get("boardFolderUpperSn").toString());
            }
            result = "게시판 폴더를 생성했습니다.";
        }catch (Exception e) {
            System.out.println(e.getStackTrace());
            result = "게시판 폴더 생성에 실패했습니다.";
        }
        return result;
    }
}
