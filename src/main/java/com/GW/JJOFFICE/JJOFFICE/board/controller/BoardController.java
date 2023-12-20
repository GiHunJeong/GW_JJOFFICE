package com.GW.JJOFFICE.JJOFFICE.board.controller;

import com.GW.JJOFFICE.JJOFFICE.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class BoardController {
    @Autowired
    private final BoardService boardService;
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String boardPage() {
        return "";
    }
}
