package cn.zju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.zju.action.DeleteFileAction;
import cn.zju.action.SearchUserAction;
import cn.zju.action.UploadAction;
import cn.zju.dao.mapper.UserMapper;
import cn.zju.dao.po.User;

@Service(value="userService")
public class UserService {
	
	@Autowired
	private UserMapper dao;

	public void createUser(User user) throws Exception{
		Boolean found = findUser(user.getUsername());
		if(!found)
		   dao.createUser(user);
		else
			throw new RuntimeException();
	}
	
	public String checkUser(User user ) throws Exception{
		return dao.checkUser(user);
	}
	
	public boolean findUser(String username) throws Exception{
		Integer found = dao.findUser(username);
		if(found==null || found<1)  return false;
		return true;
	}
	public boolean findPhone(String phone) throws Exception{
		Integer found = dao.findPhone(phone);
		if(found==null || found<1)  return false;
		return true;
	}
	
	public int getUserIdByname(String username) throws Exception{
		Integer id = dao.getUserIdByname(username);
		if(id==null || id<1)  return -1;
		return id;
	}
	
	public  List<User> getAllUsers(SearchUserAction searchUserAction) throws Exception{
		return dao.getAllUsers(searchUserAction);
	}

	public int isVip(String user_name)throws Exception {
		return dao.isVip(user_name);
	}
	
	public int totalCapa(String user_name)throws Exception{
		Boolean found = findUser(user_name);
		if(found)
			return dao.totalCapa(user_name);
		else
			throw new RuntimeException();
		
	}
	
	public int usedCapa(String username)throws Exception{
		Boolean found = findUser(username);
		if(found)
			return dao.usedCapa(username);
		else
			throw new RuntimeException();
		
	}

	public int countUsers(SearchUserAction searchUserAction)throws Exception {
		// TODO Auto-generated method stub
		return dao.countUsers(searchUserAction);
	}

	public void plusUsedCapa(UploadAction uploadaction)throws Exception {
		// TODO Auto-generated method stub
			dao.plusUsedCapa(uploadaction);
	}
	public void minusUsedCapa(DeleteFileAction deletefileaction)throws Exception {
		// TODO Auto-generated method stub
			dao.minusUsedCapa(deletefileaction);	
	}

	public int getUsedCapaByName(String username)throws Exception {
		// TODO Auto-generated method stub
		return dao.getUsedCapaByName(username);
	}
}
