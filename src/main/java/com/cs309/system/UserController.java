package com.cs309.system;

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

import com.cs309.services.UserService;
import com.cs309.users.Users;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserService serv;

	@Autowired
	UserRepository users;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String welcome() {
		return "Welcome";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<Users> getUsers() {
		return serv.getAll();
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Users> getUser(@PathVariable("id") Long userID) {
		return users.getById(userID);
	}

	@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public Users saveUser(@RequestBody Users user) {
		return serv.save(user);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCar(@PathVariable int id) {
		serv.remove(id);
	}

	@RequestMapping(value = "/login/{username}", method = RequestMethod.GET)
	@ResponseBody
	public String validate(@PathVariable("username") String username) {

		return users.findByUsername(username).getPassword();

	}

	@RequestMapping(value = "/users/profile/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String card(@PathVariable("name") String name) throws JSONException {

		JSONObject result = new JSONObject();
		result.put("name", users.findByUsername(name).getName());
		result.put("major", users.findByUsername(name).getMajor());
		result.put("grad", users.findByUsername(name).getGrad());
		result.put("school", users.findByUsername(name).getSchool());

		return result.toString();
	}
}
