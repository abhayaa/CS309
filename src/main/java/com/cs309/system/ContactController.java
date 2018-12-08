package com.cs309.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs309.services.ContactService;
import com.cs309.users.Contacts;

@RestController
public class ContactController {

	@Autowired
	private ContactService serv;

	@Autowired
	ContactRepository compRepo;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	@ResponseBody
	public List<Contacts> getContacts() {
		return serv.getAll();
	}


	@RequestMapping(value = "/contacts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public Contacts saveWord(@RequestBody Contacts keyword) {
		return serv.save(keyword);
	}

	@RequestMapping(value = "/contacts/{user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String card(@PathVariable("user") String name) throws JSONException {

		List<Contacts> r = compRepo.getByusername(name);
		JSONObject result = new JSONObject();

		for (int i = 0; i < r.size(); i++) {
			Contacts x = r.get(i);
			result.put("contact" + i, x.getContact());
		}
		return result.toString();
	}

}
