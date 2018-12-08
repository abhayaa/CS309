package com.cs309.users;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "keywords")
public class Keywords {

	@Id
	@Column(name = "word_id")
	private long id;

	@Column(name = "word")
	@NotFound(action = NotFoundAction.IGNORE)
	private String keyword;

	public String getKeywords() {
		return this.keyword;
	}

	public void setKeyword(String kword) {
		this.keyword = kword;
	}
	
	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return new ToStringCreator(this)
				.append("word_id", this.getID()).append("word:", this.getKeywords()).toString();
	}
}
