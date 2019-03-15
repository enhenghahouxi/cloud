package cn.zju.action;

import java.io.File;
import java.io.Serializable;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.zju.dao.po.Relation;
import cn.zju.service.FileService;
import cn.zju.service.GroupService;
import cn.zju.service.RelationService;
import cn.zju.service.UserService;
 
public class DismissGroupAction extends ActionSupport implements Serializable{
	
	private int currentpage;
	private int pagesize;
	private int startindex;
	private int groupid;

	private FileService fileservice; 
	private UserService userservice; 
	private GroupService groupservice; 
	private RelationService relationservice; 
	private Relation relation;
	
	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
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
	
	
	public RelationService getRelationservice() {
		return relationservice;
	}

	public void setRelationservice(RelationService relationservice) {
		this.relationservice = relationservice;
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

	
	
	//删除文件夹
	//param folderPath 文件夹完整绝对路径

     public static void delFolder(String folderPath) {
	     try {
	        delAllFile(folderPath); //删除完里面所有内容
	        String filePath = folderPath;
	        filePath = filePath.toString();
	        java.io.File myFilePath = new java.io.File(filePath);
	        myFilePath.delete(); //删除空文件夹
	     } catch (Exception e) {
	       e.printStackTrace(); 
	     }
	}

	//删除指定文件夹下所有文件
	//param path 文件夹完整绝对路径
	   public static boolean delAllFile(String path) {
	       boolean flag = false;
	       File file = new File(path);
	       if (!file.exists()) {
	         return flag;
	       }
	       if (!file.isDirectory()) {
	         return flag;
	       }
	       String[] tempList = file.list();
	       File temp = null;
	       for (int i = 0; i < tempList.length; i++) {
	          if (path.endsWith(File.separator)) {
	             temp = new File(path + tempList[i]);
	          } else {
	              temp = new File(path + File.separator + tempList[i]);
	          }
	          if (temp.isFile()) {
	             temp.delete();
	          }
	          if (temp.isDirectory()) {
	             delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
	             delFolder(path + "/" + tempList[i]);//再删除空文件夹
	             flag = true;
	          }
	       }
	       return flag;
	  }
	
	public String dismissGroup(){
		//判断该用户是否属于该群组
		   try{
			   String username = (String) ActionContext.getContext().getSession().get("user_name");
				//session没有用户名说明没有登陆，让他转去主页
				//if(username==null || "".equals(username)){
				//	return INPUT;
				//}
				int userid=userservice.getUserIdByname(username);
				relation.setGroupid(groupid);
				relation.setUserid(userid); 
			   int relationid = relationservice.checkRelation(relation);
			   //有点不确定
			   if(relationid<1) {
					ServletActionContext.getRequest().setAttribute("globalmessage", "你可能不属于该群组/或者没有登录");
					return ERROR;
			   }
			   //只有创建者可以解散群组
			   String arceus=groupservice.getArceusById(groupid);
			   if(!arceus.equals(username)) {
					ServletActionContext.getRequest().setAttribute("globalmessage", "你没有权利解散该群组！");
					return ERROR;
			   }
			   
			   //删除群组对应文件和文件夹（硬盘，参考DeleteFileAction）
				//删除群组拥有的文件信息（file表，参考DeleteFileAction）
			   try{    
					   //从硬盘上删除文件
				       String groupname=groupservice.getGroupName(groupid);
					   String storepath = new String("C:"+File.separator+"upload"+File.separator+groupname);
					   System.out.println(storepath);
					   //storepath = storepath+filename;
					   delFolder(storepath);
					   
					   //todo 删除数据库中file记录
					   fileservice.deleteFileByPath(groupname);				  
			   }catch(Exception e){
				   e.printStackTrace();
				   ServletActionContext.getRequest().setAttribute("globalmessage", "无法删除文件记录");
				   return ERROR;
			   }
			   
			   //删除和修改数据库中的信息。（1.relation表中删除对应条目 2.group表中删除对应条目 3.file表中的file信息）
			   groupservice.deleteGroupById(groupid);
			   relationservice.deleteRelationByGroupId(groupid);
			   
			   //groupservice.deleteGroupById(groupid);

		   }catch(Exception e){
			   e.printStackTrace();
			   ServletActionContext.getRequest().setAttribute("globalmessage", "你可能不属于该群组");
			   return ERROR;
		   }
		   return SUCCESS;
		}
}
