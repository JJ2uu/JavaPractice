package com.multi.mydiary;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	mySQL_memberDAO dao;

	@RequestMapping("diary_join")
	public void insert(mySQL_memberVO bag) {

		System.out.println("insert 요청됨.");
		System.out.println(bag);
		System.out.println(dao);
		dao.insert(bag);
	}
	
	@RequestMapping("login")
	public String login(mySQL_memberVO bag, HttpSession session) {
		
		System.out.println("login요청됨");
		System.out.println(bag);
		mySQL_memberVO bag2 = dao.login(bag);
		if (bag2 != null) {
			session.setAttribute("id", bag2.getId());
			session.setAttribute("pw", bag2.getPw());
			session.setAttribute("name", bag2.getName());
			session.setAttribute("tel", bag2.getTel());
			return "login_true";
		} else {
			return "login_false";
		}
	}
	
	@RequestMapping("update")
	public void update(mySQL_memberVO bag) {
		System.out.println("update 요청됨.");
		System.out.println(bag);
		dao.update(bag);
	}
	
	@RequestMapping("delete")
	public void delete(mySQL_memberVO bag) {
		System.out.println("delete 요청됨");
		System.out.println(bag);
		dao.delete(bag);
	}
	
	@RequestMapping("one")
	public void one(mySQL_memberVO bag, Model model) {
		System.out.println("검색 요청됨");
		System.out.println(bag);
		mySQL_memberVO bag2 = dao.one(bag);
		model.addAttribute("bag2", bag2);
	}
	
	@RequestMapping("member_list")
	public void member_list(Model model) {
		ArrayList<mySQL_memberVO> list = dao.list();
		model.addAttribute("list", list);
	}
	
	
	
	
	
	
	
}