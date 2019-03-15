package cn.zju.action;

import java.io.File;
import java.io.Serializable;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.zju.service.FileService;
import cn.zju.service.UserService;
 
public class DeleteFileAction extends ActionSupport implements Serializable{
	
	private int currentpage;
	private int pagesize;
	private int startindex;
	private int id; //文件id
	private FileService service; 
	private UserService userservice;
	private String username;
	private int size;
	

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public FileService getService() {
		return service;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setService(FileService service) {
		this.service = service;
	}
	
	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	
	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String deleteFile(){   
	   //判断该用户是否拥有此文件
	   try{
		   String filepath = service.findFilepathById(id);
		   String login_user = (String) ActionContext.getContext().getSession().get("user_name");
		   String filename = service.findFilenameById(id); //查出文件名
		   if(filepath!=null && login_user.equals(filepath) ){
			   //todo 修改usedcapa
				//try {		
					int filesize=service.getFilesizeById(id);
					String username=(String) ActionContext.getContext().getSession().get("user_name");
					int usedcapa=userservice.getUsedCapaByName(username);
					
					if((usedcapa-filesize)<0) {
						ServletActionContext.getRequest().setAttribute("message", "删除失败！容量可能出现了问题！");
						return SUCCESS;
					}
					else {
						this.setUsername(login_user);
						this.setSize(filesize);
						//userservice.minusUsedCapa(this);	
						userservice.minusUsedCapa(this);			
					}				
				//}catch(Exception e) {
		    		//	ServletActionContext.getRequest().setAttribute("message", "删除失败！容量可能出问题！");
		    		//	return SUCCESS;
				//}
				
			   service.deleteFileById(id); //删除数据库的该文件记录
			   //从硬盘上删除文件
			   String storepath = new String("C:"+File.separator+"upload"+File.separator+login_user+File.separator);
			   storepath = storepath+filename;
			   System.out.println(storepath);
			   File file = new File(storepath);
			   if(file.exists()){
				   file.delete();
			   }else{
				   ServletActionContext.getRequest().setAttribute("globalmessage", "文件已不存在");
				   return ERROR;
			   }
			   
			   return SUCCESS;
		   }else{ //不通过，可能是人为篡改数据，转发至全局消息页面
			ServletActionContext.getRequest().setAttribute("globalmessage", "该文件可能不属于你");
			return ERROR;
		   }
	   }catch(Exception e){
		   e.printStackTrace();
		   ServletActionContext.getRequest().setAttribute("globalmessage", "该文件可能不属于你");
		   return ERROR;
	   }
	}
}
