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
@Table(name = "users")
public class Users {

	@Id
	@Column(name = "user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Long id;

	@Column(name = "email")
	@NotFound(action = NotFoundAction.IGNORE)
	private String email;

	@Column(name = "name")
	@NotFound(action = NotFoundAction.IGNORE)
	private String name;

	@Column(name = "username")
	@NotFound(action = NotFoundAction.IGNORE)
	private String username;

	@Column(name = "school")
	@NotFound(action = NotFoundAction.IGNORE)
	private String school;

	@Column(name = "gradDate")
	@NotFound(action = NotFoundAction.IGNORE)
	private String gradDate;

	@Column(name = "major")
	@NotFound(action = NotFoundAction.IGNORE)
	private String major;

	@Column(name = "password")
	@NotFound(action = NotFoundAction.IGNORE)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrad() {
		return gradDate;
	}

	public void setGrad(String grad) {
		this.gradDate = grad;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Long getID() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public boolean isNew() {
//		return this.id == null;
//	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this)

				.append("user_id", this.getID()).append("user_name", this.getUsername())
				.append("first_name", this.getName()).append("school", this.getSchool()).append("grad", this.getGrad())
				.append("major", this.getMajor()).toString();

	}

}
