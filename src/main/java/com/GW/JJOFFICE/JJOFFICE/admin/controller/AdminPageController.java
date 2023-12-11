package com.GW.JJOFFICE.JJOFFICE.admin.controller;

import com.GW.JJOFFICE.JJOFFICE.admin.service.AdminPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminPageController {
    @Autowired
    private final AdminPageService adminPageService;
    @GetMapping("")
    public String adminPage() {
        return "admin/adminPage";
    }
    @GetMapping("employeeList")
    public String employeeListPage(Model model) {
        model.addAttribute("empList", adminPageService.getEmployeeList());
        return "admin/employee/employeeList";
    }
    @GetMapping("employeeReg")
    public String employeeRegPage() {
        return "admin/employee/employeeReg";
    }
}
