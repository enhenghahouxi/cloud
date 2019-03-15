package cn.zju.dao.mapper;

import java.util.List;

import cn.zju.action.DeleteFileAction;
import cn.zju.action.SearchUserAction;
import cn.zju.action.UploadAction;
import cn.zju.dao.po.User;

public interface UserMapper {
	
	public void createUser(User user) throws Exception;
	public String checkUser(User user) throws Exception;
	public Integer findUser(String username) throws Exception;
	public Integer getUserIdByname(String username)throws Exception;
	public int isVip(String username)throws Exception;
	public Integer totalCapa(String username)throws Exception;
	public Integer usedCapa(String username)throws Exception;
	public List<User> getAllUsers(SearchUserAction searchUserAction)throws Exception;
	public Integer countUsers(SearchUserAction searchUserAction)throws Exception;
	public void plusUsedCapa(UploadAction uploadaction)throws Exception;
	public void minusUsedCapa(DeleteFileAction deletefileaction)throws Exception;
	public int getUsedCapaByName(String username)throws Exception;
	public Integer findPhone(String phone)throws Exception;	
	
}

