package com.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DataBase.Operations;
import com.Entity.User;

@Controller
public class LoginController {
	
	@Autowired
	private Operations operation;
	
	@RequestMapping(path="/doLogin", method=RequestMethod.POST)
	public String doLogin(@ModelAttribute User user, Model model, HttpSession session) {
		User u = (User)operation.login(user);
		if(u != null) {
			session.setAttribute("userId", u.getUid());
			session.setAttribute("username", u.getUsername());
			return "noteHome";
		}else {
			model.addAttribute("login", "fail");
			return "login";
		}
	}
}
