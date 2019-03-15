package cn.zju.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zju.action.DeleteFileAction;
import cn.zju.action.SearchUserAction;
import cn.zju.action.UploadAction;
import cn.zju.dao.DaoUtil;
import cn.zju.dao.mapper.UserMapper;
import cn.zju.dao.po.User;

public class UserDao {
     //创建用户
	public void createUser(User user) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.createUser(user);
		session.commit();
		session.close();
	}
	
	//如果数据库里存在用户名和密码都匹配的记录 代表登陆成功
	public String checkUser(User user)throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		String user_name = mapper.checkUser(user);
		session.close();
		return user_name;
	}
	
	//查找指定用户名的用户是否存在
	public boolean findUser(String username)throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer found = mapper.findUser(username);
		session.close();
		if(found==null || found<1)  return false;
		return true;
	}
	
	//查找指定用户名的用户是否存在
	public boolean findPhone(String phone)throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer found = mapper.findPhone(phone);
		session.close();
		if(found==null || found<1)  return false;
		return true;
	}
	//获得指定用户名的用户的id
	public int getUserIdByname(String username)throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer id = mapper.getUserIdByname(username);
		session.close();
		if(id==null || id<1) return -1;
		return id;
	}
	
	//获得所有用户及其信息
	public  List<User> getAllUsers(SearchUserAction action) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User>  allUsers= mapper.getAllUsers(action);
		session.close();
		return allUsers;
	}
	
	public int isVip(String username) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer isvip = mapper.isVip(username);
		session.close();
		if(isvip==null || isvip == 0)  return 0;
		else return 1;
	}
	public int totalCapa(String username) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer totalcapa = mapper.totalCapa(username);
		session.close();
		if(totalcapa==null || totalcapa == 0)  return 102400;
		else return totalcapa;
	}
	
	public int usedCapa(String username) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Integer usedcapa = mapper.usedCapa(username);
		session.close();
		if(usedcapa==null || usedcapa <= 0)  return 0;
		else return usedcapa;
	}
	
	public int getUsedCapaByName(String username) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int usedcapa = mapper.usedCapa(username);
		session.close();
		if(usedcapa <= 0)  return 0;
		else return usedcapa;
	}
	
	//查找所有用户的数量
	public int countUsers(SearchUserAction action) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int count = mapper.countUsers(action);
		session.close();
		return count;
	}
	
	public void plusUsedCapa(UploadAction uploadaction)throws Exception {
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.plusUsedCapa(uploadaction);
		session.commit();
		session.close();
	}
	public void minusUsedCapa(DeleteFileAction deletefileaction)throws Exception {
		SqlSession session = DaoUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.minusUsedCapa(deletefileaction);
		session.commit();
		session.close();
	}
}
