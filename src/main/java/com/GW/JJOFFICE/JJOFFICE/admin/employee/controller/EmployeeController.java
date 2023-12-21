package com.GW.JJOFFICE.JJOFFICE.admin.employee.controller;

import com.GW.JJOFFICE.JJOFFICE.admin.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;
    @RequestMapping(value = "/employeeList", method = RequestMethod.GET)
    public String employeeListPage() {
        return "admin/employee/employeeList";
    }
    @RequestMapping(value = "/ajax/employeeListTotal", method = RequestMethod.POST)
    public String ajaxEmployeeListTotal(@RequestParam Map<String, Object> map, Model model) {
        model.addAttribute("rs", employeeService.getEmployeeListTotal(map));
        return "jsonView";
    }
    @RequestMapping(value = "/ajax/employeeList", method = RequestMethod.POST)
    public String ajaxEmployeeList(@RequestParam Map<String, Object> map, Model model) {
        model.addAttribute("rs", employeeService.getEmployeeList(map));
        return "jsonView";
    }
    @RequestMapping(value = "/ajax/employeeDel", method = RequestMethod.POST)
    public String ajaxEmployeeDel(@RequestParam Map<String, Object> map, Model model) {
        model.addAttribute("rs", employeeService.setEmployeeOneDel(map));
        return "jsonView";
    }
    @RequestMapping(value = "/employeeReg" , method = RequestMethod.GET)
    public String employeeRegPage() {
        return "admin/employee/employeeReg";
    }
}
