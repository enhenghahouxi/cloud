package cn.zju.action;

import java.io.Serializable;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.zju.dao.po.File;
import cn.zju.dao.po.PageBean;
import cn.zju.service.FileService;
import cn.zju.service.GroupService;
import cn.zju.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchGroupFileAction  extends ActionSupport implements Serializable{

	private int currentpage = 1; //用户想看的页(用户点击的那一页)，默认是第1页
	private int pagesize = 5 ;   //每一个页面呈现几条数据，默认一页是5条数据
	private int startindex;      //用户想看的页的数据在数据库的起始位置 由上面的值计算
	
	private String filepath; //file表的文件路径就是所属的群组的群组名
	private String groupname;
	private PageBean pageBean_groupfile;
	
	private FileService fileservice; 
	private UserService userservice; 
	private GroupService groupservice;
	

	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public FileService getFileservice() {
		return fileservice;
	}
	public void setFileservice(FileService fileservice) {
		this.fileservice = fileservice;
	}
	public UserService getUserservice() {
		return userservice;
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	public GroupService getGroupservice() {
		return groupservice;
	}
	public void setGroupservice(GroupService groupservice) {
		this.groupservice = groupservice;
	}
	public GroupService getGroupService() {
		return groupservice;
	}
	public void setGroupService(GroupService groupservice) {
		this.groupservice = groupservice;
	}
	public PageBean getPageBean_groupfile() {
		return pageBean_groupfile;
	}
	public void setPageBean_groupfile(PageBean pageBean_groupfile) {
		this.pageBean_groupfile = pageBean_groupfile;
	}
	public FileService getFileService() {
		return fileservice;
	}
	public UserService getUserService() {
		return userservice;
	}
	public void setFileService(FileService fileservice) {
		this.fileservice = fileservice;
	}
	public void setUserService(UserService userservice) {
		this.userservice = userservice;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
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
		
	
	@Override
	public String execute() throws Exception  {
		//根据群组查找出它所有的文件
		List<File> list;
		try {
			
			String username = (String) ActionContext.getContext().getSession().get("user_name");
			//session没有用户名说明没有登陆，让他转去主页
			if(username==null || "".equals(username)){
				String adminname = (String) ActionContext.getContext().getSession().get("admin_name");
				if(adminname==null||"".equals(adminname))
					return INPUT;
			}
			if(groupname==null||"".equals(groupname)) {
				groupname=(String) ActionContext.getContext().getSession().get("group_name");
			}
			
			this.filepath = groupname;
			list = fileservice.getGroupFiles(this);
			ActionContext.getContext().getSession().put("group_name", groupname);//放到session域
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		} 
		//拿到每页的数据，每个元素就是一条记录
		pageBean_groupfile.setList(list);
		pageBean_groupfile.setCurrentpage(currentpage);
	    pageBean_groupfile.setPagesize(pagesize);
		pageBean_groupfile.setTotalrecord(fileservice.countGroupFiles(this));
		
		ServletActionContext.getRequest().setAttribute("pagebean_groupfile", pageBean_groupfile);
		
		return SUCCESS;
	}
		
}
