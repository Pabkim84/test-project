package com.its.membershipboard.controller;

import com.its.membershipboard.dto.BoardDTO;
import com.its.membershipboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService bs;

    @PostMapping("/board/save")
    public String save(BoardDTO boardDTO, Model model) {
        bs.save(boardDTO);
        List<BoardDTO> boardDTOList = bs.findAll();
        model.addAttribute(boardDTOList);
        return "/board";
    }
    @GetMapping("/board/{boardId}")
    public String findById(@PathVariable Long id, Model model){
        BoardDTO boardDTO = bs.findById(id);
        model.addAttribute(boardDTO);
        return "/boardPages/detail";
    }
}
