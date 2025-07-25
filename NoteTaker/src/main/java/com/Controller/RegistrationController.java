package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DataBase.Operations;
import com.Entity.User;

@Controller
public class RegistrationController {
	
	@Autowired
	private Operations operation;
	
	@RequestMapping(path="/doRegister", method=RequestMethod.POST) //executes the registration process
	public String doRegister(@ModelAttribute User user, Model model) {
		int n = (int) operation.save(user);
		if(n > 0) {
			model.addAttribute("reg", Integer.toString(n));
			return "home";
		}else {
			model.addAttribute("reg", "fail");
			return "register";
		}
	}
	
}
