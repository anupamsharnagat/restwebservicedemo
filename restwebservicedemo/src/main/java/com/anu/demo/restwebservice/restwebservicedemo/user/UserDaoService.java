package com.anu.demo.restwebservice.restwebservicedemo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users=new ArrayList<>();
	private static int userCount=4;
	
	static {
		
		users.add(new User(1,"Adam",new Date()));
		users.add(new User(2,"Eve",new Date()));
		users.add(new User(3,"Jack",new Date()));
		users.add(new User(4,"mike",new Date()));
	}
	
	//Some method for fetching values
	
	//find all users
	
	public List<User> findAll()
	{
		return users;
	}
	
	// Save user
	
	public User save(User user)
	{
		if(user.getId()==null)
			user.setId(userCount++);
		users.add(user);
		return user;
	}
	
	//find specific user
	
	public User findOne(int id)
	{
		for(User user:users)
		{
			if(user.getId()==id)
			{
				return user;
			}
		}
		return null;
	}
	
	//Delete user for static list
	public User deleteUser(int id)
	{
		Iterator<User> itr=users.iterator();
		
		while(itr.hasNext())
		{
			User user=itr.next();
			if(user.getId()==id)
			{
				itr.remove();
				return user;
			}
		}
		return null;
	}

}
