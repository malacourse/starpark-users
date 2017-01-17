package org.openpersuasion.starpark.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@Autowired
	private UserRepository repo;

	@RequestMapping(value = "api/v1/users", method = RequestMethod.GET)
	public List<User> getAll() {
		return repo.findAll();
	}
	
	@RequestMapping(value = "api/v1/user/{id}", method = RequestMethod.GET)
	public User get(@PathVariable String id) {
		return repo.findOne(id);
	}

	@RequestMapping(value = "api/v1/user", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return repo.save(user);
	}

	@RequestMapping(value = "api/v1/user/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		repo.delete(id);
	}

	@RequestMapping(value = "api/v1/user/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable String id, @RequestBody User user) {
		User update = repo.findOne(id);
		update.setName(user.getName());
		return repo.save(update);
	}

}
