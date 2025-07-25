package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nid;
	private String title;
	@Lob
	@Column(columnDefinition="TEXT") //size of the field
	private String body;
	@ManyToOne
	private User user;
	
	public Note(int nid, String title, String body) {
		super();
		this.nid = nid;
		this.title = title;
		this.body = body;
	}
	@Override
	public String toString() {
		return "Note [nid=" + nid + ", title=" + title + ", body=" + body + ", user=" + user + "]";
	}
	public Note() {
		super();
	}
	public Note(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}
	public Note(String title, String body, User user) {
		super();
		this.title = title;
		this.body = body;
		this.user = user;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
