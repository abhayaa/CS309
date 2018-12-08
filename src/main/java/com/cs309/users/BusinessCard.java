package com.cs309.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "business_cards")
public class BusinessCard {

	@Id
	@Column(name = "card_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Long id;

	@Column(name = "name")
	@NotFound(action = NotFoundAction.IGNORE)
	private String name;

	@Column(name = "position")
	@NotFound(action = NotFoundAction.IGNORE)
	private String position;

	@Column(name = "email")
	@NotFound(action = NotFoundAction.IGNORE)
	private String email;

	@Column(name = "phone")
	@NotFound(action = NotFoundAction.IGNORE)
	private String phone;


	@Column(name = "company")
	@NotFound(action = NotFoundAction.IGNORE)
	private String company;

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getCardId() {
		return this.id;
	}

	public void setCardId(Long id) {
		this.id = id;
	}

	public String name() {
		return this.name;
	}

	public void name(String name) {
		this.name = name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return this.position;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}



	@Override
	public String toString() {
		return new ToStringCreator(this).append("card_id", this.getCardId()).append("name", this.name())
				.append("position", this.getPosition()).append("email", this.getEmail())
				.append("phone", this.getPhone()).toString();
	}

}
