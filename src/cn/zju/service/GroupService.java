package cn.zju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zju.action.DeleteFileAction;
import cn.zju.action.NewDeleteFileAction;
import cn.zju.action.NewUploadAction;
import cn.zju.action.SearchAllGroupAction;
//import cn.zju.action.SearchFileAction;
import cn.zju.action.SearchGroupAction;
import cn.zju.action.SearchGroupUserAction;
//import cn.zju.action.SearchUserFileAction;
import cn.zju.action.SearchUserGroupAction;
import cn.zju.action.UploadAction;
import cn.zju.dao.mapper.GroupMapper;
//import cn.zju.dao.po.File;
import cn.zju.dao.po.Group;
import cn.zju.dao.po.User;

@Service(value="groupService")
public class GroupService {
	
	@Autowired
	private GroupMapper dao;

	public void createGroup(Group group) throws Exception{
		Boolean found = findGroup(group.getGroupname());
		if(!found)
		   dao.createGroup(group);
		else
			throw new RuntimeException();
	}
	
	public String checkGroup(Group group) throws Exception{
		return dao.checkGroup(group);
	}
	
	public boolean findGroup(String groupname) throws Exception{
		Integer found = dao.findGroup(groupname);
		if(found==null || found<1)  return false;
		return true;
	}
	
	public int getGroupId(String groupname) throws Exception{
		Integer found = dao.getGroupId(groupname);
		if(found==null || found<1)  return 0;
		return found;
	}
	
	public String getGroupName(int groupid) throws Exception{
		String found = dao.getGroupName(groupid);
		if(found==null || "".equals(found)) return null;
		return found;
	}

	public  List<Group> getUserGroups(SearchUserGroupAction action) throws Exception {
		return dao.getUserGroups(action);
	}
	
	public  List<Group> getAllGroups(SearchGroupAction searchGroupAction) throws Exception{
		return dao.getAllGroups(searchGroupAction);
	}
	
	public  List<Group> searchAllGroups(SearchAllGroupAction searchAllGroupAction) throws Exception{
		return dao.searchAllGroups(searchAllGroupAction);
	}
	
	public  int countGroups(SearchGroupAction searchGroupAction)throws Exception{
		return dao.countGroups(searchGroupAction);
	}
	
	public  int countUserGroups(SearchUserGroupAction action) throws Exception {
		return dao.countUserGroups(action);
	}
	
	public int hasMemberNum(String group_name)throws Exception {
		return dao.hasMemberNum(group_name);
	}
	
	public int limitMemberNum(String group_name)throws Exception{
		return dao.limitMemberNum(group_name);
	}
	
	public String inviteCode(String group_name)throws Exception{
		return dao.inviteCode(group_name);
	}

	public  boolean minusHasMemberNum(String group_name)throws Exception {
		Integer found = dao.hasMemberNum(group_name);
		if(found==null || found<=1)  return false;//当群内没人或者只有一个人是不能退群的，只有在另一个模块解散群才行
		dao.minusHasMemberNum(group_name);	
		return true;
	}

	public boolean plusHasMemberNum(String group_name)throws Exception {
		Integer found1 = dao.hasMemberNum(group_name);
		Integer found2 = dao.limitMemberNum(group_name);
		if(found1==null || found2==null  || found1>=found2)  return false;//当群内没人或者群成员已经满的话不能加群（只有升级为vip才可以有更多特权）
		dao.plusHasMemberNum(group_name);	
		return true;
	}
	
	public String getArceusById(int groupid) throws Exception{
		String found = dao.getArceusById(groupid);
		if(found==null || "".equals(found)) return null;
		return found;
	}
	
	
	public void deleteGroupById(int groupid)throws Exception {
		dao.deleteGroupById(groupid);
	}

	public int usedCapa(String group_name)throws Exception{
		// TODO Auto-generated method stub
		Boolean found = findGroup(group_name);
		if(found)
			return dao.usedCapa(group_name);
		else
			throw new RuntimeException();
	}
	public int totalCapa(String group_name)throws Exception{
		Boolean found = findGroup(group_name);
		if(found)
			return dao.totalCapa(group_name);
		else
			throw new RuntimeException();
		
	}

	public void plusUsedCapa(NewUploadAction newuploadaction)throws Exception{
		// TODO Auto-generated method stub
		dao.plusUsedCapa(newuploadaction);
	}
	public void minusUsedCapa(NewDeleteFileAction newdeletefileaction)throws Exception {
		// TODO Auto-generated method stub
		dao.minusUsedCapa(newdeletefileaction);	
	}

	public int getUsedCapaByName(String groupname) throws Exception{
		// TODO Auto-generated method stub
		return dao.getUsedCapaByName(groupname);
	}

	public int countAllGroups(SearchAllGroupAction searchAllGroupAction)throws Exception {
		// TODO Auto-generated method stub
		return dao.countAllGroups(searchAllGroupAction);
	}

	public List<User> getGroupAllUsers(SearchGroupUserAction searchGroupUserAction) throws Exception{
		// TODO Auto-generated method stub
		return dao.getGroupAllUsers(searchGroupUserAction) ;
	}

}
