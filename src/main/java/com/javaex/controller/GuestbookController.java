package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {

	// 필드
	@Autowired
	//private GuestbookDao guestDao = new GuestbookDao();
	private GuestbookDao guestDao;
	
	// 생성자

	// 메소드-gs

	// 메소드-일반
	
	//list
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("GuestbookController>list");
		
		// Dao를 통해서 getList(주소)를 가져온다
		//GuestbookDao guestDao = new GuestbookDao();
		List<GuestbookVo> gList = guestDao.getList();

		model.addAttribute("gList", gList);
		
		// View Resolver 설정
		// return "/WEB-INF/views/addList.jsp";
		return "addList";
	}

	// add
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVo vo) {
		System.out.println("GuestbookController>add");

		//GuestbookDao guestDao = new GuestbookDao();
		int count = guestDao.insert(vo);

		System.out.println(count);
		return "redirect:list";
	}
	
	// 삭제 : deleteForm
	@RequestMapping(value = "/deleteForm/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm(@PathVariable("no") int no, Model model) {
		System.out.println("GuestbookController>deleteForm");
		System.out.println(no);

		model.addAttribute("no", no);
		
		// View Resolver 설정
		// return "/WEB-INF/views/deleteForm.jsp";
		return "deleteForm";
	}
	
	// delete
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestbookVo vo) {
		System.out.println("GuestbookController>delete");

		System.out.println(vo);

		//GuestbookDao guestDao = new GuestbookDao();
		int count = guestDao.delete(vo);

		System.out.println(count);

		return "redirect:list";

	}

	@RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
	public String test() {
		System.out.println("GuestbookController>test");
		
		return "test";
	}

}