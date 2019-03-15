package cn.zju.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zju.action.SearchAllGroupAction;
//import cn.zju.action.SearchFileAction;
import cn.zju.action.SearchGroupAction;
import cn.zju.action.SearchGroupUserAction;
//import cn.zju.action.SearchGroupFileAction;
//import cn.zju.action.SearchUserFileAction;
import cn.zju.action.SearchUserGroupAction;
//import cn.zju.dao.mapper.FileMapper;
import cn.zju.dao.mapper.GroupMapper;
import cn.zju.dao.mapper.UserMapper;
//import cn.zju.dao.mapper.UserMapper;
//import cn.zju.dao.po.File;
import cn.zju.dao.po.Group;
import cn.zju.dao.po.User;

public class GroupDao {
			//创建组
			public void createGroup(Group group) throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				mapper.createGroup(group);
				session.commit();
				session.close();
			}
			
			//查看数据库里是否存在小组名字匹配的记录 
			public String checkGroup(Group group)throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				String group_name = mapper.checkGroup(group);
				session.close();
				return group_name;
			}
			
			//查找指定群组名的群组是否存在
			public boolean findGroup(String groupname)throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				Integer found = mapper.findGroup(groupname);
				session.close();
				if(found==null || found<1)  return false;
				return true;
			}
			
			public int getGroupId(String groupname)throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				Integer found = mapper.getGroupId(groupname);
				session.close();
				return found;
			}
			public String getGroupName(int groupid)throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				String found = mapper.getGroupName(groupid);
				session.close();
				return found;
			}
			public String getArceusById(int groupid)throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				String found = mapper.getArceusById(groupid);
				session.close();
				return found;
			}
			
			//符合搜索内容的所有群组
			public List<Group> getAllGroups(SearchGroupAction searchGroupAction) throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				List<Group> allGroups = mapper.getAllGroups(searchGroupAction);
				session.close();
				return allGroups;
			}
			public List<Group> searchAllGroups(SearchAllGroupAction searchAllGroupAction)throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				List<Group> allGroups = mapper.searchAllGroups(searchAllGroupAction);
				session.close();
				return allGroups;
			}
			//根据用户名得群组
			public List<Group> getUserGroups(SearchUserGroupAction action) throws Exception{
				   SqlSession session = DaoUtil.getSqlSession();
				   GroupMapper mapper = session.getMapper(GroupMapper.class);
				   List<Group> userGroups = mapper.getUserGroups(action);
				   session.close();
				   return userGroups;
			}
			
			//统计一个用户一共多少群组
			public int countUserGroups(SearchUserGroupAction action) throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				int count = mapper.countUserGroups(action);
				session.close();
				return count;
			}
			
			//统计全站一共有多少群组
			public int countAllGroups(SearchAllGroupAction action) throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				int count = mapper.countAllGroups(action);
				session.close();
				return count;
			}
			
			public int hasMemberNum(String username) throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				Integer hasMemberNum = mapper.hasMemberNum(username);
				session.close();
				if(hasMemberNum==null || hasMemberNum == 0)  return 0;
				else return hasMemberNum;
			}
			public int limitMemberNum(String username) throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				Integer limitMemberNum = mapper.limitMemberNum(username);
				session.close();
				if(limitMemberNum==null || limitMemberNum == 0)  return 10;
				else return limitMemberNum;
			}
			
			public String inviteCode(String username) throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				String inviteCode = mapper.inviteCode(username);
				session.close();
				return inviteCode;
			}
			
			
			//不知道返回值是用boolean还是void
			public boolean minusHasMemberNum(String username)throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				mapper.minusHasMemberNum(username);
				session.commit();
				session.close();
				return true;
			}
			public boolean plusHasMemberNum(String username)throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				mapper.plusHasMemberNum(username);
				session.commit();
				session.close();
				return true;
			}
			public void deleteGroupById(int groupid)throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				mapper.deleteGroupById(groupid);
				session.commit();
				session.close();
			}
			
			public int getUsedCapaByName(String groupname) throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				int usedcapa = mapper.usedCapa(groupname);
				session.close();
				if(usedcapa <= 0)  return 0;
				else return usedcapa;
			}
			
			public List<User> getGroupAllUsers(SearchGroupUserAction searchGroupUserAction)throws Exception{
				SqlSession session = DaoUtil.getSqlSession();
				GroupMapper mapper = session.getMapper(GroupMapper.class);
				List<User> allGroupUser = mapper.getGroupAllUsers(searchGroupUserAction);
				session.close();
				return allGroupUser;
			}
}
