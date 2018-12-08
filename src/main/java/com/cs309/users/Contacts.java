package com.cs309.users;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "contacts")
public class Contacts {

	@Id
	@Column(name = "contact_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Long id;

	@Column(name = "username")
	@NotFound(action = NotFoundAction.IGNORE)
	private String username;

	@Column(name = "contacts")
	@NotFound(action = NotFoundAction.IGNORE)
	private String contact;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setUser(String username) {
		this.username = username;
	}

	public String getUser() {
		return this.username;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContact() {
		return this.contact;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this)

				.append("id", this.getId()).append("username", this.getUser()).append("contact", this.getContact())
				.toString();
	}

}
