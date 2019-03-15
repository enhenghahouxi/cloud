package cn.zju.action;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.zju.dao.po.File;
import cn.zju.dao.po.Group;
import cn.zju.dao.po.PageBean;
import cn.zju.dao.po.User;
import cn.zju.service.FileService;
import cn.zju.service.GroupService;
import cn.zju.service.RelationService;
import cn.zju.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchGroupUserAction  extends ActionSupport implements Serializable {
	
	//private String searchcontent; //搜索的内容

	private int currentpage = 1; //用户想看的页(用户点击的那一页)，默认是第1页
	private int pagesize = 5 ;   //每一个页面呈现几条数据，默认一页是5条数据
	private int startindex;      //用户想看的页的数据在数据库的起始位置
	private int groupid;
	
	private PageBean pageBean_groupuser;
	private GroupService groupservice; 
	private RelationService relationservice; 
	private String username;
	private String groupname;
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public RelationService getRelationservice() {
		return relationservice;
	}

	public void setRelationservice(RelationService relationservice) {
		this.relationservice = relationservice;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

		
	public PageBean getPageBean_groupuser() {
		return pageBean_groupuser;
	}

	public void setPageBean_groupuser(PageBean pageBean_groupuser) {
		this.pageBean_groupuser = pageBean_groupuser;
	}

	public GroupService getGroupservice() {
		return groupservice;
	}

	public void setGroupservice(GroupService groupservice) {
		this.groupservice = groupservice;
	}

	/*public String getSearchcontent() {
		return searchcontent;
	}
	public void setSearchcontent(String searchcontent) {
		this.searchcontent = searchcontent;
	}*/
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
		//比如用户想看第2页，每页10条数据，那么数据在数据库里的起始位置是 10
		this.startindex = (this.currentpage-1)*this.pagesize; 
		return startindex;
	}
	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}
		
	public String listUsers() throws Exception{
		//解决get参数乱码
		//searchcontent = new String(searchcontent.getBytes("iso8859-1"),"utf-8");
		return execute();
	}

	public void validateExecute(){
		//if("".equals(searchcontent) || searchcontent==null){
		//	addFieldError("", "");
		//}
	}
	
	@Override
	public String execute() throws Exception  {
		
		List<User> list;
		this.setGroupid(groupservice.getGroupId(groupname)); 
		try {
			//session域存的username和传进来的username一致，说明用户名没有造假
			String user_name = (String) ActionContext.getContext().getSession().get("user_name");
			if(user_name == null || "".equals(user_name) || !user_name.equals(this.username))
				 return INPUT;
			System.out.println("!@#"+groupid+"#@!");
			list = groupservice.getGroupAllUsers(this);
		} catch (Exception e) {
			e.printStackTrace();
			return SUCCESS;
		} 
		//拿到每页的数据，每个元素就是一条记录
		pageBean_groupuser.setList(list);
		pageBean_groupuser.setCurrentpage(currentpage);
		pageBean_groupuser.setPagesize(pagesize);
		pageBean_groupuser.setTotalrecord(groupservice.hasMemberNum(groupname));
		
		ServletActionContext.getRequest().setAttribute("pagebean_groupuser", pageBean_groupuser);
		//ServletActionContext.getRequest().setAttribute("searchcontent", "所有用户");
		
		return SUCCESS;
	}
}
