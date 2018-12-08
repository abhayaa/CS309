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

import com.cs309.services.DocumentService;
import com.cs309.users.Documents;

@RestController
public class DocumentController {

	@Autowired
	private DocumentService docserv;

	@Autowired
	DocumentRepository docRepo;

	@RequestMapping(value = "/showFiles", method = RequestMethod.GET)
	@ResponseBody
	public List<Documents> getDocuments() {
		return docserv.getAll();
	}

	@RequestMapping(value = "/files/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Documents> getDocument(@PathVariable("id") Long keyID) {
		return docRepo.getById(keyID);
	}

	@RequestMapping(value = "/addFiles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public Documents saveDocument(@RequestBody Documents document) {
		return docserv.save(document);
	}

	@RequestMapping(value = "/getFiles/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getUsers(@PathVariable("name") String name) throws JSONException {

		JSONObject result = new JSONObject();

		List<Documents> doc = docRepo.findByusername(name);

		for (int i = 0; i < doc.size(); i++) {
			Documents x = doc.get(i);
			result.put("file" + i, x.getFileName());

		}

		return result.toString();
	}

}
