package com.GW.JJOFFICE.JJOFFICE.document.controller;

import com.GW.JJOFFICE.JJOFFICE.auth.dto.EmployeeDto;
import com.GW.JJOFFICE.JJOFFICE.document.service.DocumentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class DocumentContorller {
    @Autowired
    private final DocumentService documentService;
    /**
     * 문서작성(기안) 페이지
     * @return
     */
    @RequestMapping(value = "/docWrite", method = RequestMethod.GET)
    public String docWrite() {
        return "document/docWrite";
    }
    @RequestMapping(value = "/ajax/getDocBoxList", method = RequestMethod.POST)
    public String ajax_getDocBoxList(@RequestParam Map<String, Object> map, Model model) {
        model.addAttribute("rs", documentService.getDocBoxList(map));
        return "jsonView";
    }
    @RequestMapping(value = "/ajax/getDocBoxTotal", method = RequestMethod.POST)
    public String ajax_getDocBoxTotal(@RequestParam Map<String, Object> map, Model model) {
        model.addAttribute("totalCount", documentService.getDocBoxTotal(map));
        return "jsonView";
    }
    /**
     * 문서작성(기안) 팝업
     * @return
     */
    @RequestMapping(value = "/docWritePop", method = RequestMethod.GET)
    public String docWritePop(String doc, Model model) {
        model.addAttribute("rs", documentService.getDocInfoOne(doc));
        return "document/docWritePop";
    }
    /**
     * 사용자 발신 문서함
     * @return
     */
    @RequestMapping(value = "/sentDocBox", method = RequestMethod.GET)
    public String sentDocBox() {
        return "document/sentDocBox";
    }
    @RequestMapping(value = "/ajax/getDocList", method = RequestMethod.POST)
    public String ajax_getDocList(@RequestParam Map<String, Object> map, Model model, HttpServletRequest request) {
        System.out.println(map);
        HttpSession session = request.getSession();
        EmployeeDto employeeDto = (EmployeeDto) session.getAttribute("EmployeeDto");
        map.put("docDrafterEmpSn", employeeDto.getEmpSn());
        model.addAttribute("rs", documentService.getDocList(map));
        return "jsonView";
    }
    @RequestMapping(value = "/ajax/getDocListTotal", method = RequestMethod.POST)
    public String ajax_getDocListTotal(@RequestParam Map<String, Object> map, Model model, HttpServletRequest request) {
        System.out.println(map);
        HttpSession session = request.getSession();
        EmployeeDto employeeDto = (EmployeeDto) session.getAttribute("EmployeeDto");
        map.put("docDrafterEmpSn", employeeDto.getEmpSn());
        model.addAttribute("totalCount", documentService.getDocListTotal(map));
        return "jsonView";
    }
    @RequestMapping(value = "/sentDocReadPop", method = RequestMethod.GET)
    public String sentDocReadPop(@RequestParam String doc, Model model) {
        model.addAttribute("rs", documentService.getDocumentInfoOne(doc));
        return "document/sentDocReadPop";
    }
    /**
     * 사용자 수신 문서함
     * @return
     */
    @RequestMapping(value = "/receiveDocBox", method = RequestMethod.GET)
    public String receiveDocBox() {
        return "document/receiveDocBox";
    }
    /**
     * 문서작성
     * @param map
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/ajax/setDocumentInfo", method = RequestMethod.POST)
    public String setDocumentInfo(@RequestParam Map<String, Object> map, Model model, HttpServletRequest request) {
        Map<String, Object> addMap = new HashMap<>();
        HttpSession session = request.getSession();
        EmployeeDto employeeDto = (EmployeeDto) session.getAttribute("EmployeeDto");
        addMap.put("docDrafterEmpSn", employeeDto.getEmpSn());
        addMap.put("docDrafterEmpName", employeeDto.getEmpName());
        addMap.put("regEmpSn", employeeDto.getEmpSn());
        map.putAll(addMap);
        String result = documentService.setDocumentInfo(map);
        model.addAttribute("rs", result);
        return "jsonView";
    }
}
