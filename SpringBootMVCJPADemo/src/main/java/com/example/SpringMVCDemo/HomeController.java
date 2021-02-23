package com.example.SpringMVCDemo;

import java.awt.List;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringMVCDemo.model.User;

@Controller
public class HomeController {

	@Autowired
	UserRepo repo;
	
	
	@RequestMapping("/")
	public String home() {
		
		System.out.println("home page requested");
		
		return "index";
	}
	
	
	@RequestMapping("/add")
	public String add(@RequestParam("num1") int num1 ,@RequestParam("num2") int num2, ModelMap model) {
		
		
		/*
		 * ModelAndView modelAndView=new ModelAndView();
		 * modelAndView.setViewName("result");
		 */
		
		int num3=num1+num2;
		
		model.addAttribute("num3", num3);
		
		return "result";
		
		
	}
	
	@ModelAttribute
	public void modelData(Model m) {
		
		m.addAttribute("name","users");
	}
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user1") User user, Model model) {
		
		
		/*
		 * ModelAndView modelAndView=new ModelAndView();
		 * modelAndView.setViewName("result");
		 */

		//model.addAttribute("num3",user);
		repo.save(user);
		
		
		return "result";
	}
	
	@RequestMapping(value="/getUsers",method=RequestMethod.GET)
	public String getUsers(Model M) {
		System.out.println("heello");
	//java.util.List<User> users=Arrays.asList(new User(10,"suresh"),new User(20,"test"));
	
	M.addAttribute("result",repo.findAll());
		return "showusers";
	}
	
	
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public String getUser(@RequestParam int uid,Model M) {
		System.out.println("heello");
	//java.util.List<User> users=Arrays.asList(new User(10,"suresh"),new User(20,"test"));
	
	M.addAttribute("result",repo.getOne(uid));
		return "showusers";
	}
	
	@RequestMapping(value="/getUserByName",method=RequestMethod.GET)
	public String getUserByName(@RequestParam String uname,Model M) {
		System.out.println("heello");
	//java.util.List<User> users=Arrays.asList(new User(10,"suresh"),new User(20,"test"));
	
	M.addAttribute("result",repo.findByUnameOrderByUidDesc(uname));
	M.addAttribute("result",repo.find(uname));
		return "showusers";
	}
	
	/*
	@RequestMapping("/addUser")
	public String addUser(@RequestParam("uid") int uid ,@RequestParam("uname") String uname, Model model) {
		
		
		/*
		 * ModelAndView modelAndView=new ModelAndView();
		 * modelAndView.setViewName("result");
	
		
		User  user=new User();
		
		user.setUid(uid);
		user.setUname(uname);
		model.addAttribute("user",user);
		
		return "result";
	}
	 */
	/*
	
/*	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("num1") int num1 ,@RequestParam("num2") int num2) {
		
		
		ModelAndView modelAndView=new ModelAndView();
	modelAndView.setViewName("result");
		
		int num3=num1+num2;
		
		modelAndView.addObject("num3", num3);
		
		return modelAndView;
	}
	
	/*
	@RequestMapping("/add")
	public String add(@RequestParam("num1") int num1 ,@RequestParam("num2") int num2,  HttpSession session) {
		
		
		int num3=num1+num2;
		
	//	HttpSession session=request.getSession();
		session.setAttribute("num3", num3);
		
		
		return "result.jsp";
	}
	
	/* sample code for servlets and jsp
	  	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		
		int num3=num1+num2;
		
		HttpSession session=request.getSession();
		session.setAttribute("num3", num3);
		
		
		return "result.jsp";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		
		int num3=num1+num2;
		
		HttpSession session=request.getSession();
		session.setAttribute("num3", num3);
		
		
		return "result.jsp";
	}*/
}
