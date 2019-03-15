package cn.zju.action;

import java.io.File;
import java.io.Serializable;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.zju.service.FileService;
import cn.zju.service.GroupService;
import cn.zju.service.RelationService;
import cn.zju.service.UserService;
 
public class DeleteUserAction extends ActionSupport implements Serializable{
	
	private int currentpage;
	private int pagesize;
	private int startindex;
	private int id; //文件id
	private FileService service; 
	private UserService userservice;
	private GroupService groupservice;
	private RelationService relationservice;
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
	
	
	public String deleteFile(){   
		/*
			//删除用户步骤：
			//1.删除用户对应文件夹（硬盘，参考DeleteFileAction）
			//2.删除用户拥有的文件信息（file表，参考DeleteFileAction）
			//2.减少用户所在的群组的人数（groups表，参考QuitGroupAction）
			//3.删除群组－用户关系表中的相关记录（relation表，参考QuitGroupAction）
			//4.删除用户的信息（user表）
		*/
	   
	   //1.删除用户对应文件和文件夹（硬盘，参考DeleteFileAction）
		//2.删除用户拥有的文件信息（file表，参考DeleteFileAction）
	   /*try{
		   String filepath = service.findFilepathById(id);
		   String user_name = (String) ActionContext.getContext().getSession().get("user_name");
		   int userid=userservice.getUserIdByname(user_name);
		   String filename = service.findFilenameById(id); //查出文件名
		   if(filepath!=null && user_name.equals(filepath) ){

			      
			   //从硬盘上删除文件
			   String storepath = new String("C:"+File.separator+"upload"+File.separator+user_name);
			   System.out.println(storepath);
			   //storepath = storepath+filename;
			   delFolder(storepath);
			   
			   //todo 删除数据库中file记录
			   service.deleteFileByPath(user_name);
		   }else{ //不通过，可能是人为篡改数据，转发至全局消息页面
			ServletActionContext.getRequest().setAttribute("globalmessage", "该文件可能不属于你");
			return ERROR;
		   }
	   }catch(Exception e){
		   e.printStackTrace();
		   ServletActionContext.getRequest().setAttribute("globalmessage", "该文件可能不属于你");
		   return ERROR;
	   }
	
	   //2.减少用户所在的群组的人数（groups表，参考QuitGroupAction）
	   try{
		   String username = (String) ActionContext.getContext().getSession().get("user_name");
			int userid=userservice.getUserIdByname(username);
		   relation.setGroupid(groupid);
		   relation.setUserid(userid);
		   int relationid = relationservice.checkRelation(relation);
		   //如果退出者正好是创建人（1.本群的创建人不变，但本人离开 2.本群的创建人变为null 3.可选择给出二重提示提醒）
		   String arceus=groupservice.getArceusById(groupid);
		   if(arceus.equals(username)) {
			    ServletActionContext.getRequest().setAttribute("globalmessage", "你不能退出该群，你可能可以解散它");
			    return ERROR;
		   }
		   //删除和修改数据库中的信息。（1.relation表中删除对应条目 2.group表中修改hasmembernum）
		   String groupname=groupservice.getGroupName(groupid);
		   if(!groupservice.minusHasMemberNum(groupname)) {
			    ServletActionContext.getRequest().setAttribute("globalmessage", "你不能退出该群，你可能可以解散它");
			    return ERROR;
		   }
		   relationservice.deleteRelationById(relationid);  
	   }catch(Exception e){
		   e.printStackTrace();
		   ServletActionContext.getRequest().setAttribute("globalmessage", "该文件可能不属于你");
		   return ERROR;
	   }
	
	*/
		return ERROR;
	}
}
