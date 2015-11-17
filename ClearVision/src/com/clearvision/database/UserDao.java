package com.clearvision.database;

import com.clearvision.model.User;

public interface UserDao {
	
	public User getUserFromDb(String email);
	public void updateUserInDb(String userData);
	public void deleteUserFromDb(String email);
	public void addUserToDb(User user);
	public boolean checkIfUserExistsInDb(String email);
}
