package com.GW.JJOFFICE.JJOFFICE.document.controller;

import com.GW.JJOFFICE.JJOFFICE.document.service.DocumentService;
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
    public String docWrite(Model model) {
        model.addAttribute("totalCount", documentService.getDocBoxTotal());
        return "document/docWrite";
    }
    @RequestMapping(value = "/ajax/getDocBoxList", method = RequestMethod.POST)
    public String ajax_getDocBoxList(@RequestParam Map<String, Object> map, Model model) {
        model.addAttribute("rs", documentService.getDocBoxList(map));
        return "jsonView";
    }
    @RequestMapping(value = "/ajax/getDocBoxTotal", method = RequestMethod.POST)
    public String ajax_getDocBoxList(Model model) {
        model.addAttribute("totalCount", documentService.getDocBoxTotal());
        return "jsonView";
    }
    /**
     * 문서작성(기안) 팝업
     * @return
     */
    @RequestMapping(value = "/docWritePop", method = RequestMethod.GET)
    public String docWritePop(String doc) {
        System.out.println("doc = "+doc);
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
    /**
     * 사용자 수신 문서함
     * @return
     */
    @RequestMapping(value = "/receiveDocBox", method = RequestMethod.GET)
    public String receiveDocBox() {
        return "document/receiveDocBox";
    }
}
