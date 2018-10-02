package com.rky.restfulwebservice.beans.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rky.restfulwebservice.beans.User;


@Component
public class UserServices {
	
	private static List<User> users = new ArrayList<User>();
	private int counter = 3;
	
	static {
		users.add(new User(1, "Rakesh", new Date()));
		users.add(new User(2, "Nishad", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}
	
	
	//Get all the users
	public List<User> findAll(){
		return users;
	}
	
	//save a user
	public User save(User user) {
		
		user.setId(++counter);
		users.add(user);
		return user;
	}
	
	//get a user
	public User findOne(int id) {
		
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
		
	}
	
	//get a user
	public User deleteById(int id) {
		
		Iterator<User> iterator = users.iterator();
		
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
	
	

}
