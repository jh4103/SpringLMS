package com.oti.myuniversity.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oti.myuniversity.board.model.Board;
import com.oti.myuniversity.board.service.IBoardService;

@Controller
public class BoardController {
	static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	IBoardService boardService;
	
	@Autowired
	Pager pager;
	
	@RequestMapping("/board/cat/{categoryType}/{pageNo}")
	public String getListByCategoryType(@PathVariable int categoryType, @PathVariable int pageNo, HttpSession session, Model model) {
		session.setAttribute("page", pageNo);
		model.addAttribute("categoryType", categoryType);
		List<Board> libraryList = boardService.selectArticleListByCatoryType(categoryType, pageNo);
		model.addAttribute("libraryList", libraryList);
		
		//paging start
		int totalRows = boardService.selectTotalArticleCount(categoryType);
		 pager.init(10, 5, totalRows, pageNo);
		model.addAttribute("pager", pager);
		
		if(categoryType == 1) {
			return "board/library/list";
		} else {
			return "board/report/list";
		}
	}
	
	@RequestMapping("/board/cat/{categoryType}")
	public String getListByCategoryType(@PathVariable int categoryType, HttpSession session, Model model) {
		
		return getListByCategoryType(categoryType, 1, session, model);
	}
	
	
	
	
	
}