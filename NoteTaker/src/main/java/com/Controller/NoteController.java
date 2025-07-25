package com.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.DataBase.Operations;
import com.Entity.Note;
import com.Entity.User;

@Controller
public class NoteController {
	
	@Autowired
	private Operations operation;
	
	//LOGOUT FROM THE SESSION
	@RequestMapping("/logout") 
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
	
	
	//ADD A NOTE TO THE DATABASE
	@RequestMapping(path="/addNote", method=RequestMethod.POST)
	public String addNote(@ModelAttribute Note note, HttpSession session, Model model) {
		int uid = (int)session.getAttribute("userId");
		User user = operation.getUser(uid);
		note.setUser(user);
		int n = operation.addNote(note);
		if(n > 0) model.addAttribute("add", "success");
		else model.addAttribute("add", "fail");
		return "addNote";
	}
	
	
	//DISPLAY ALL THE NOTE FOR A PARTICULAR USER
	@RequestMapping("/viewAllNote")
	public String viewAllNote(HttpSession session, Model model) {
		int uid = (int) session.getAttribute("userId");
		List<Note> notes = operation.displayNote(uid);
		model.addAttribute("allnotes", notes);
		return "displayNote";
	}
	
	//DELETE ONE NOTE FOR A USER
	@RequestMapping("/deleteNote")
	public String deleteNote(@RequestParam("noteId") int noteId) {
		operation.deleteNote(noteId);
		return "redirect:/viewAllNote";
	}
	

	@RequestMapping("/loadEditNote") //loads the edit note form
	public String loadEditNote(@RequestParam("noteId") int noteId, Model model) {
		Note note = operation.getNote(noteId);
		model.addAttribute("noteId", noteId);
		model.addAttribute("noteTitle", note.getTitle());
		model.addAttribute("noteBody", note.getBody());
		return "editNote";
	}
	
	@RequestMapping("/doEditNote") //edits the note
	public String editNote(@ModelAttribute Note note) {
		//need the value of noteId form user
		System.out.println(note);
		operation.editNote(note);
		return "redirect:/viewAllNote";
	}
	
}
