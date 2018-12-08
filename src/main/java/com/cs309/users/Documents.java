package com.cs309.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "files")
public class Documents {

	@Id
	@Column(name = "pairID")
	@NotFound(action = NotFoundAction.IGNORE)
	private Long id;

	@Column(name = "username")
	@NotFound(action = NotFoundAction.IGNORE)
	private String username;

	@Column(name = "fileName")
	@NotFound(action = NotFoundAction.IGNORE)
	private String fileName;

	public Long getPairId() {
		return this.id;
	}

	public void setPairId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return this.username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public void setFileName(String filename) {
		this.fileName = filename;
	}

	public String getFileName() {
		return this.fileName;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this).append("pairid", this.getPairId()).append("username", this.getUserName())
				.append("filename", this.getFileName()).toString();
	}

}
