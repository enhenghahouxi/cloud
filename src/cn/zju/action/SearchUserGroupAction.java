package cn.zju.action;


import java.io.Serializable;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.zju.dao.po.File;
import cn.zju.dao.po.Group;
import cn.zju.dao.po.PageBean;
import cn.zju.service.FileService;
import cn.zju.service.GroupService;
import cn.zju.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

 public class SearchUserGroupAction extends ActionSupport implements Serializable{

	private int currentpage = 1; //用户想看的页(用户点击的那一页)，默认是第1页
	private int pagesize = 5 ;   //每一个页面呈现几条数据，默认一页是5条数据
	private int startindex;      //用户想看的页的数据在数据库的起始位置 由上面的值计算
	
	//private String filepath; //file表的文件路径就是所属的群组的群组名
	private int userid; //根据userid查找所有的组
	private PageBean pageBean_usergroup;
	
	private GroupService groupservice; 
	private UserService userservice; 
	
	
	

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		if(currentpage <= 0)
			this.currentpage = 1;
		else
			this.currentpage = currentpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
	    if(pagesize<=0)
	    	this.pagesize = 5;
	    else
		    this.pagesize = pagesize;
	}

	public int getStartindex() {
		this.startindex = (this.currentpage-1)*this.pagesize; 
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public PageBean getPageBean_usergroup() {
		return pageBean_usergroup;
	}

	public void setPageBean_usergroup(PageBean pageBean_usergroup) {
		this.pageBean_usergroup = pageBean_usergroup;
	}

	public GroupService getGroupservice() {
		return groupservice;
	}

	public void setGroupservice(GroupService groupservice) {
		this.groupservice = groupservice;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public void validateExecute(){
		String username = (String) ActionContext.getContext().getSession().get("user_name");
		if("".equals(username) || username==null){
			addFieldError("", "");
		}
	}
	
	@Override
	public String execute() throws Exception  {
		//根据用户查找出它所有的群组
		List<Group> list;
		try {
			String username = (String) ActionContext.getContext().getSession().get("user_name");
			//session没有用户名说明没有登陆，让他转去主页
			if(username==null || "".equals(username)){
				return INPUT;
			}
			int i=userservice.getUserIdByname(username);//出错
			if(i!=-1)
				this.userid = i;
			list = groupservice.getUserGroups(this);
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		} 
		
		//拿到每页的数据，每个元素就是一条记录
		pageBean_usergroup.setList(list);
		pageBean_usergroup.setCurrentpage(currentpage);
	    pageBean_usergroup.setPagesize(pagesize);
		pageBean_usergroup.setTotalrecord(groupservice.countUserGroups(this));
		
		ServletActionContext.getRequest().setAttribute("pagebean_usergroup", pageBean_usergroup);
		
		return SUCCESS;
	}

		
}
