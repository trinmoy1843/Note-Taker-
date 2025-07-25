package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoadController {
	
	@RequestMapping("/home") //loads the home page
	public String loadHome() {
		return "home";
	}
	
	@RequestMapping("/loadRegister")  //loads the registration page
	public String loadRegister() {
		return "register";
	}
	
	@RequestMapping("/loadLogin") //loads the login page
	public String loadLogin() {
		return "login";
	}
	
	@RequestMapping("/loadNoteHome") //loads the note home
	public String loadNoteHome() {
		return "noteHome";
	}
	
	@RequestMapping("/loadAddNote") //loads the add note form
	public String loadAddNote() {
		return "addNote";
	}
	
	
}