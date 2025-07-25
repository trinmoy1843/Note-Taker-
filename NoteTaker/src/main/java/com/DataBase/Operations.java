package com.DataBase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.Query;
import com.Entity.Note;
import com.Entity.User;

@Repository //defines it as a bean to be autowired
public class Operations {

	@Autowired
	SessionFactory sessionFactory;
	
	//ADD DATA TO THE DATA BASE
	@Transactional
	public Integer save(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return (Integer)session.save(user);
		}catch(Exception e) {
			return 0;
		}
	}
	
	//LOGIN 
	@Transactional(readOnly = true)
	public User login(User user) {
		Session session = sessionFactory.getCurrentSession();
		User u;
		try{
			u = session.get(User.class, user.getUid());
		}catch(Exception e) {
			return null;
		}
		if(u == null) return null;
		if(user.getPassword().equals(u.getPassword())) return u;
		else return null;
  	}
	
	//RETURNS A USER USING USER ID
	@Transactional(readOnly = true)
	public User getUser(int uid) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class,uid);
	}
	
	//RETURNS A NOTE USING NOTE ID
	@Transactional(readOnly=true)
	public Note getNote(int nid) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Note.class, nid);
	}
	
	//ADD NOTE TO THE DATA BASE
	@Transactional
	public Integer addNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		try{
			return (Integer) session.save(note);
		}catch(Exception e) {
			return 0;
		}
	}
	
	//DISPLAY ALL THE NOTES FOR A PARTICULAR USER
	@Transactional(readOnly = true)
	public List<Note> displayNote(int uid) {
		User user = this.getUser(uid);
		user.getNotes().size();
		List<Note> notes = user.getNotes();
		return notes;
	}
	
	//DELETE A NOTE FROM THE DATABASE
	@Transactional
	public void deleteNote(int noteId) {
		Session session = sessionFactory.getCurrentSession();
		Note note = session.get(Note.class, noteId);
		session.delete(note);
	}
	
	//EDIT A EXISTING NOTE
	@Transactional
	public int editNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		String query = "update Note set title = :t, body=:b where nid=:id";
		Query q = session.createQuery(query);
		q.setParameter("t", note.getTitle());
		q.setParameter("b", note.getBody());
		q.setParameter("id", note.getNid());
		return q.executeUpdate();
	}
}
