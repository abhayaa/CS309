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

import com.cs309.services.CompanyService;
import com.cs309.users.Company;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService serv;

	@Autowired
	CompanyRepository compRepo;

	@RequestMapping(value = "/company", method = RequestMethod.GET)
	@ResponseBody
	public List<Company> getKeywords() {
		return serv.getAll();
	}

	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Company> getKeyword(@PathVariable("id") Long keyID) {
		return compRepo.getById(keyID);
	}

	@RequestMapping(value = "/company", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public Company saveWord(@RequestBody Company keyword) {
		return serv.save(keyword);
	}

	@RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteWord(@PathVariable int id) {
		serv.remove(id);
	}

	@RequestMapping(value = "/company/login/{username}", method = RequestMethod.GET)
	@ResponseBody
	public String validate(@PathVariable("username") String username) {

		return compRepo.findByUsername(username).getPassword();

	}

	@RequestMapping(value = "/company/card/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String card(@PathVariable("name") String name) throws JSONException {
//		String card = "name: " + compRepo.findByUsername(name).getName() + '\n' + "company: "
//				+ compRepo.findByUsername(name).getCompany() + '\n' + "position: "
//				+ compRepo.findByUsername(name).getPosition() + '\n' + "email: "
//				+ compRepo.findByUsername(name).getEmail() + '\n' + "phone: "
//				+ compRepo.findByUsername(name).getPhone();

		JSONObject result = new JSONObject();
		result.put("name", compRepo.findByUsername(name).getName());
		result.put("company", compRepo.findByUsername(name).getCompany());
		result.put("position", compRepo.findByUsername(name).getPosition());
		result.put("email", compRepo.findByUsername(name).getEmail());
		result.put("phone", compRepo.findByUsername(name).getPhone());

		return result.toString();
	}

}
