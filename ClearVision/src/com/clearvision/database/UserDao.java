
package com.clearvision.database;

import java.util.List;

import com.clearvision.model.User;

public interface UserDao {
	
	public User getUserFromDb(String email);
	public void updateUserInDb(int userId);
	public void deleteUserFromDb(String email);
	public void addUserToDb(User user);
}
