package com.cs309.users;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@Column(name = "company_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	@Column(name = "name")
	@NotFound(action = NotFoundAction.IGNORE)
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Column(name = "password")
	@NotFound(action = NotFoundAction.IGNORE)
	private String password;

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getPassword() {
		return this.password;
	}

	@Column(name = "email")
	@NotFound(action = NotFoundAction.IGNORE)
	private String email;

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	@Column(name = "position")
	@NotFound(action = NotFoundAction.IGNORE)
	private String position;

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return this.position;
	}

	@Column(name = "username")
	@NotFound(action = NotFoundAction.IGNORE)
	private String username;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	@Column(name = "company")
	@NotFound(action = NotFoundAction.IGNORE)
	private String company;

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return this.company;
	}

	@Column(name = "phone")
	@NotFound(action = NotFoundAction.IGNORE)
	private String phone;

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this)

				.append("id", this.getId()).append("company", this.getCompany()).append("name", this.getName())
				.append("position", this.getPosition()).append("username", this.getUsername())
				.append("password", this.getPassword()).append("email", this.getEmail())
				.append("phone", this.getPhone()).toString();
	}

}
