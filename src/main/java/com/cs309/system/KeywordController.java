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

import com.cs309.services.KeywordService;
import com.cs309.users.Keywords;

@RestController
public class KeywordController {

	@Autowired
	private KeywordService serv;

	@Autowired
	KeywordRepository keyRepo;

	@RequestMapping(value = "/keywords", method = RequestMethod.GET)
	@ResponseBody
	public List<Keywords> getKeywords() {
		return serv.getAll();
	}

	@RequestMapping(value = "/keywords/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Keywords> getKeyword(@PathVariable("id") Long keyID) {
		return keyRepo.getById(keyID);
	}

	@RequestMapping(value = "/keywords", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public Keywords saveWord(@RequestBody Keywords keyword) {
		return serv.save(keyword);
	}

	@RequestMapping(value = "/keywords/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWord(@PathVariable int id) {
		serv.remove(id);
	}

}
