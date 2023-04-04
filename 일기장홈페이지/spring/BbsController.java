package com.multi.mydiary;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BbsController {
	
	@Autowired
	BbsDAO dao;
	
	@Autowired
	mySQL_memberDAO dao2;
//	@Autowired
//	ReplyDAO dao2;
	
	@RequestMapping("insert2.multi")
	public void bbs_insert(BbsVO bag) {
		System.out.println("insert 요청됨");
		System.out.println(bag);
		System.out.println(dao);
		dao.insert(bag);
	}
	
	@RequestMapping("delete2.multi")
	public void bbs_delete(BbsVO bag) {
		System.out.println("delete 요청됨");
		System.out.println(bag);
		System.out.println(dao);
		dao.delete(bag);
	}
	
	@RequestMapping("update2.multi")
	public void bbs_update(BbsVO bag) {
		System.out.println("update 요청됨");
		System.out.println(bag);
		System.out.println(dao);
		dao.update(bag);
	}
	
	@RequestMapping("bbs_one")
	public void bbs_one(int no, Model model) {
		System.out.println("one 검색 요청됨");
		BbsVO bag = dao.one(no);
//		ArrayList<ReplyVO> list = dao2.list(no); // bbs 상세페이지 안에 reply list도 함께 가져오게끔
		model.addAttribute("bag", bag);
//		model.addAttribute("list", list);
	}
	
	@RequestMapping("diary_bbs_list")
	public void bbs_list(Model model, HttpSession session) {
			System.out.println("list검색 요청됨");
			String writer = (String)session.getAttribute("name");
			System.out.println(writer);
			ArrayList<BbsVO> list = dao.list(writer);
			System.out.println(list);
			model.addAttribute("list", list);
	}
	
//	@RequestMapping("reply_insert")
//	public String reply(ReplyVO bag, Model model) {
//		System.out.println(bag);
//		dao2.insert(bag);
//		return "bbs_one";
//	}
}
