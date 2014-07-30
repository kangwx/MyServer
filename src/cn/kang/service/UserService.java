package cn.kang.service;

import java.io.Serializable;

import cn.kang.bean.User;
import cn.kang.service.base.DAO;

public interface UserService extends DAO<User> {
	/**
	 * 判断用户名是否存在
	 * @param name
	 * @return
	 */
	public boolean exsit(String name);
	
	public boolean checkUser(String username, String password);
	
	public void enable(Serializable ... usernames);
	
	public void updatePassword(String username, String newpassword);
}
