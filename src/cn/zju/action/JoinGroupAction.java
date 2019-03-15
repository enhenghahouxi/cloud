package cn.zju.action;

import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.zju.dao.po.Group;
import cn.zju.dao.po.Relation;
import cn.zju.dao.po.User;
import cn.zju.service.FileService;
import cn.zju.service.GroupService;
import cn.zju.service.RelationService;
import cn.zju.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JoinGroupAction extends ActionSupport implements Serializable{

	private String invitecode;
	private String groupname;
	

	private RelationService relationservice; 
	private Relation relation;
	private UserService userservice; 
	private User user;
	private GroupService groupservice; 
	private Group group;




	public String getInvitecode() {
		return invitecode;
	}

	public void setInvitecode(String invitecode) {
		this.invitecode = invitecode;
	}


	public RelationService getService() {
		return relationservice;
	}

	public void setService(RelationService service) {
		this.relationservice = relationservice;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public GroupService getGroupservice() {
		return groupservice;
	}

	public void setGroupservice(GroupService groupservice) {
		this.groupservice = groupservice;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public RelationService getRelationservice() {
		return relationservice;
	}

	public void setRelationservice(RelationService relationservice) {
		this.relationservice = relationservice;
	}
	
	@Override
	public String execute() throws Exception {
		String user_name = (String) ActionContext.getContext().getSession().get("user_name");
		int userid = userservice.getUserIdByname(user_name);
		int groupid = groupservice.getGroupId(groupname);
		relation.setUserid(userid);
		relation.setGroupid(groupid);
		if(relationservice.findRelation(relation)==false)
		{
			return SUCCESS;
		}else {
			ServletActionContext.getRequest().setAttribute("globalmessage", "你已经是该组成员或群组不存在");
		    addFieldError("", "");
		}	
		return ERROR;
	}	
	
	//当进行注册前，检查参数是否正确
	public void validateJoingroup(){
		
		if("".equals(invitecode)||invitecode.equals(null)){
			ServletActionContext.getRequest().setAttribute("invitecodeerror", "邀请码必须4-16位");
		    addFieldError("", "");
	    }
		if(invitecode.length() >16 || invitecode.length() < 4){
			ServletActionContext.getRequest().setAttribute("invitecodeerror", "邀请码必须4-16位");
			addFieldError("", "");
		}
		
	}
	
	public String joingroup(){


		try {
			String user_name = (String) ActionContext.getContext().getSession().get("user_name");
			//session没有用户名说明没有登陆，让他转去主页
			if(user_name==null || "".equals(user_name)){
				return INPUT;
			}
			if(groupname.equals("")||groupname.equals(null)) {
				ServletActionContext.getRequest().setAttribute("invitecodeerror", "群组名为空");
				return ERROR;				
			}
			if(!groupservice.findGroup(groupname)) {
				ServletActionContext.getRequest().setAttribute("invitecodeerror", "群组名不正确");
				return ERROR;
			}

			int userid = userservice.getUserIdByname(user_name);
			int groupid = groupservice.getGroupId(groupname);
			
			//如果用户已加入该群组 下层的service会抛出异常
			relation.setUserid(userid);
			relation.setGroupid(groupid);
			relation.setJointime(new java.util.Date());	
			relationservice.insertRelation(relation);//出错   //加入成功，就更新数据库
			
			groupservice.plusHasMemberNum(groupname);
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("invitecodeerror", "该用户已是成员或群组不存在");
			return ERROR;
		}
	}
}
