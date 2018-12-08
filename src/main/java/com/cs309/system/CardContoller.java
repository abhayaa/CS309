package com.cs309.system;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs309.services.CardService;
import com.cs309.users.BusinessCard;

@RestController
public class CardContoller {

	@Autowired
	private CardService serv;

	@Autowired
	BusinessCardRepository cardRepo;

	@RequestMapping(value = "/card", method = RequestMethod.GET)
	@ResponseBody
	public List<BusinessCard> getKeywords() {
		return serv.getAll();
	}

	@RequestMapping(value = "/card/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<BusinessCard> getKeyword(@PathVariable("id") Long keyID) {
		return cardRepo.getById(keyID);
	}

	@RequestMapping(value = "/card", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public BusinessCard saveWord(@RequestBody BusinessCard card) {
		return serv.save(card);
	}

	@RequestMapping(value = "/card/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWord(@PathVariable int id) {
		serv.remove(id);
	}

}
