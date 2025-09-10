package lx.edu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lx.edu.springboot.dao.AddrBookDAO;
import lx.edu.springboot.vo.AddrBookVO;

@Controller
public class AddrBookController {
	
	@Autowired
	ApplicationContext context;

	@Autowired
	AddrBookDAO dao;

	@RequestMapping("/insert.do")
	public String insert(AddrBookVO vo) throws Exception {
		System.out.println(vo);
		dao.insertDB(vo);
		return "redirect:addrbook_list.do";
	}

	@RequestMapping("/addrbook_form.do")
	public String form() {
		return "addrbook_form";//jsp file name
	}
	
//	@RequestMapping("addrbook_list.do")
//	public String list(HttpServletRequest req) throws Exception {
//		List<AddrBookVO> list = dao.getDBList();
//		// list를 request에 넣는다. 
//		req.setAttribute("data", list);
//		return "addrbook_list";
//	}
	
	@RequestMapping("addrbook_list.do")
	public ModelAndView list() throws Exception {
		ModelAndView result = new ModelAndView();
		List<AddrBookVO> list = dao.getDBList();
		result.addObject("data", list);
		result.setViewName("addrbook_list");
		return result;
		
	}
	
	/*
	 * 
	@RequestMapping("addrbook_list.do")
	public String list(HttpSession session, HttpServletRequest req) throws Exception {
		if(session.getAttribute("userId")==null) {
			return "login";
		}
		List<AddrBookVO> list = dao.getDBList();
		return "addrbook_list";
	
	}
	 */
	
/*
	@RequestMapping("/edit.do")
	public ModelAndView edit(@RequestParam("abId") int abId) throws Exception {
	    
	    ModelAndView result = new ModelAndView();
	    AddrBookVO vo = dao.getDB(abId);
	    result.addObject("ab", vo);
	    result.setViewName("addrbook_edit_form");
	    return result;
	}
	
	*/
	

	
	

}
