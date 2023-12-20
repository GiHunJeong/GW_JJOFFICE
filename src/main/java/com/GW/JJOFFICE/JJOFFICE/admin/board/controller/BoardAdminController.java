package com.GW.JJOFFICE.JJOFFICE.admin.board.controller;

import com.GW.JJOFFICE.JJOFFICE.admin.board.service.BoardAdminService;
import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BoardAdminController {
    @Autowired
    private final BoardAdminService boardAdminService;
    @RequestMapping(value = "/boardSetting", method = RequestMethod.GET)
    public String boardSetting() {
        return "admin/board/boardSetting";
    }
    @RequestMapping(value = "/ajax/boardSetting/menuList", method = RequestMethod.POST)
    public String boardSettingMenuList(Model model) {
        model.addAttribute("rs", boardAdminService.getBoardFolderList());
        return "jsonView";
    }
    @RequestMapping(value = "/ajax/boardSetting/createMenu", method = RequestMethod.POST)
    public String boardSettingCreateMenu(@RequestParam Map<String, Object> map, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        EmployeeDto employeeDto = (EmployeeDto) session.getAttribute("EmployeeDto");
        map.put("boardFolderRegEmpSn", employeeDto.getEmpSn());
        model.addAttribute("rs", boardAdminService.setBoardFolderOne(map));
        return "jsonView";
    }
}
