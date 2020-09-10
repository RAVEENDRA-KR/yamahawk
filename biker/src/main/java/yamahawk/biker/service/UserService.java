package yamahawk.biker.service;

import yamahawk.biker.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	 
	 public void saveUser(User user);

}