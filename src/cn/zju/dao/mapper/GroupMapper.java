package cn.zju.dao.mapper;

import java.util.List;

import cn.zju.action.DeleteFileAction;
import cn.zju.action.NewDeleteFileAction;
import cn.zju.action.NewUploadAction;
import cn.zju.action.SearchAllGroupAction;
//import cn.zju.action.SearchFileAction;
import cn.zju.action.SearchGroupAction;
import cn.zju.action.SearchGroupUserAction;
//import cn.zju.action.SearchUserFileAction;
import cn.zju.action.SearchUserGroupAction;
//import cn.zju.dao.po.File;
import cn.zju.dao.po.Group;
import cn.zju.dao.po.User;

public interface GroupMapper {
	public void createGroup(Group group) throws Exception;
	public String checkGroup(Group group) throws Exception;
	public Integer findGroup(String groupname) throws Exception;
	public Integer getGroupId(String groupname) throws Exception;
	public List<Group> getUserGroups(SearchUserGroupAction action)throws Exception;
	public List<Group> getAllGroups(SearchGroupAction action)throws Exception;
	public List<Group> searchAllGroups(SearchAllGroupAction searchAllGroupAction)throws Exception;
	public int countGroups(SearchGroupAction searchGroupAction) throws Exception;
	public int countUserGroups(SearchUserGroupAction action) throws Exception;
	public Integer hasMemberNum(String groupname)throws Exception;
	public Integer limitMemberNum(String groupname)throws Exception;
	public String inviteCode(String groupname)throws Exception;
	public void minusHasMemberNum(String groupname)throws Exception;
	public void plusHasMemberNum(String groupname)throws Exception;
	public String getGroupName(int groupid)throws Exception;
	public void deleteGroupById(int groupid)throws Exception;
	public String getArceusById(int groupid)throws Exception;
	public Integer totalCapa(String group_name)throws Exception;
	public Integer usedCapa(String group_name)throws Exception;
	public void plusUsedCapa(NewUploadAction newuploadaction)throws Exception;
	public void minusUsedCapa(NewDeleteFileAction newdeletefileaction)throws Exception;
	public int getUsedCapaByName(String groupname)throws Exception;
	public int countAllGroups(SearchAllGroupAction searchAllGroupAction)throws Exception;
	public List<User> getGroupAllUsers(SearchGroupUserAction searchGroupUserAction)throws Exception;
}
