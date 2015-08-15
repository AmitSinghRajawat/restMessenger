package org.riva.rest.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.research.ws.wadl.Link;

@XmlRootElement
public class message {
	private long id;
	private String msg;
	private Date created;
	private String author;
	private List<Links> links = new ArrayList<>();
	
	public message(){
		
	}
	
	public message(long id, String msg, String author) {
		this.id = id;
		this.msg = msg;
		this.author = author;
		this.created = new Date();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Links> getLinks() {
		return links;
	}

	public void setLinks(List<Links> links) {
		this.links = links;
	}
	
	public void addLinks(String url, String rel) {
		Links link = new Links();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);		
	}
}
