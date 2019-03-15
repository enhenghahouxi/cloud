package cn.zju.action;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.zju.service.UserService;

import cn.zju.dao.po.Group;
import cn.zju.dao.po.Relation;
import cn.zju.service.GroupService;
import cn.zju.service.RelationService;


public class CreateGroupAction extends ActionSupport implements Serializable{
	
	private String groupname;
	private String invitecode;
	private String invitecode2;

	private GroupService groupservice; 
	private Group group;
	private RelationService relationservice; 
	private Relation relation;
	private UserService userservice; 
	
	public GroupService getGroupservice() {
		return groupservice;
	}

	public void setGroupservice(GroupService groupservice) {
		this.groupservice = groupservice;
	}

	public RelationService getRelationservice() {
		return relationservice;
	}

	public void setRelationservice(RelationService relationservice) {
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


	public String getInvitecode() {
		return invitecode;
	}
	
	public void setInvitecode(String invitecode) {
		this.invitecode = invitecode;
	}
	
	public String getInvitecode2() {
		return invitecode2;
	}

	public void setInvitecode2(String invitecode2) {
		this.invitecode2 = invitecode2;
	}

	public void setGroup(Group group) {
		this.group =group;
	}
	
	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Group getGroup() {
		return group;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	//当进行创建群组前，检查参数是否正确
	public void validateCreategroup(){
		
		if("".equals(groupname) || "".equals(invitecode) || "".equals(invitecode2)){
			ServletActionContext.getRequest().setAttribute("groupnameerror", "群组名必须6-20位");
			ServletActionContext.getRequest().setAttribute("invitecodeerror", "入群暗号必须4-16位");
		    addFieldError("", "");
	    }else if(groupname.length() > 20 || groupname.length() < 6){
			ServletActionContext.getRequest().setAttribute("groupnameerror", "群组名必须6-20位");
	        addFieldError("", "");
		}else if(invitecode.length() > 16 || invitecode.length() < 4 || invitecode2.length() > 16 || invitecode2.length() < 4){
			ServletActionContext.getRequest().setAttribute("invitecoodeerror", "入群暗号必须4-16位");
			addFieldError("", "");
		}
		if(!invitecode2.equals(invitecode)) {
			ServletActionContext.getRequest().setAttribute("invitecodeerror", "入群暗号前后必须一致");
			addFieldError("", "");
		}
	}
	
	public String creategroup(){	
		//Date time=(Date) new java.util.Date();
		try {
			if("".equals(groupname) || "".equals(invitecode) || "".equals(invitecode2)){
				ServletActionContext.getRequest().setAttribute("groupnameerror", "群组名必须6-20位");
				ServletActionContext.getRequest().setAttribute("invitecodeerror", "入群暗号必须4-16位");
			    addFieldError("", "");
		    }else if(groupname.length() > 20 || groupname.length() < 6){
				ServletActionContext.getRequest().setAttribute("groupnameerror", "群组名必须6-20位");
		        addFieldError("", "");
			}else if(invitecode.length() > 16 || invitecode.length() < 4 || invitecode2.length() > 16 || invitecode2.length() < 4){
				ServletActionContext.getRequest().setAttribute("invitecoodeerror", "入群暗号必须4-16位");
				addFieldError("", "");
			}
			if(!invitecode2.equals(invitecode)) {
				ServletActionContext.getRequest().setAttribute("invitecodeerror", "入群暗号前后必须一致");
				addFieldError("", "");
			}
			String username = (String) ActionContext.getContext().getSession().get("user_name");
			//session没有用户名说明没有登陆，让他转去主页
			if(username==null || "".equals(username)){
				return INPUT;
			}
			
			if(userservice.findUser(groupname)==true) {
				//判断是否和用户名重名，如果重名不能创建
				ServletActionContext.getRequest().setAttribute("groupnameerror", "该群组名已经被使用了！" );
				return ERROR;
			}
			
				group.setGroupname(groupname);
				//String groupname=group.getGroupname();
				group.setInvitecode(invitecode);
				group.setCreatetime(new java.util.Date());
				group.setArceus(username);
				groupservice.createGroup(group); //如果群组已注册 下层的service会抛出异常

			
				int userid=userservice.getUserIdByname(username);
				int groupid=groupservice.getGroupId(groupname);
				relation.setGroupid(groupid);
				relation.setUserid(userid);
				relation.setJointime(new java.util.Date());
				relationservice.insertRelation(relation); //如果已经有该条‘群组－组员’的关系记录，下层的service会抛出异常

			
			
			
			//注册成功，就在upload下分配一个群组文件夹
			String path = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
			File file = new File(path+File.separator+groupname);
			file.mkdir();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("groupnameerror", "该群组名已经被使用！" );
			return ERROR;
		}
	}
}
