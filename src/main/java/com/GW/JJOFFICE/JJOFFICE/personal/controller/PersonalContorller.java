package com.GW.JJOFFICE.JJOFFICE.personal.controller;

import com.GW.JJOFFICE.JJOFFICE.personal.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class PersonalContorller {
    @Autowired
    private final PersonalService personalService;
    @RequestMapping(value = "personalRecord", method = RequestMethod.GET)
    public String personalRecord() {
        return "personal/personalRecord";
    }
}
