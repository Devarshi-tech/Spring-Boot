package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.helper.Message;
import com.example.demo.models.Contact;

public class UserDto {
	private int id;
	private String name;
	
	private String email;
	private String role;
	private boolean enabled;
	private String imageUrl;
	
	private Message message;
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	private List<Contact> contacts = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int id, String name, String email, String role, boolean enabled, String imageUrl, Message message,
			List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.enabled = enabled;
		this.imageUrl = imageUrl;
		this.message = message;
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", enabled=" + enabled
				+ ", imageUrl=" + imageUrl + ", message=" + message + ", contacts=" + contacts + "]";
	}


	
	
}
