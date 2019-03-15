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
 
public class QuitGroupAction extends ActionSupport implements Serializable{
	
	private int currentpage;
	private int pagesize;
	private int startindex;
	private int groupid;
	


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

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}
	
	public String quitGroup(){	
		   //判断该用户是否属于该群组
		   try{
			   String username = (String) ActionContext.getContext().getSession().get("user_name");
				int userid=userservice.getUserIdByname(username);
			   relation.setGroupid(groupid);
			   relation.setUserid(userid);
			   int relationid = relationservice.checkRelation(relation);
			   //有点不确定
			   if(relationid==0 || relationid<1) {
					ServletActionContext.getRequest().setAttribute("globalmessage", "你可能不属于该群组");
					return ERROR;
			   }
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
			   ServletActionContext.getRequest().setAttribute("globalmessage", "你可能不属于该群组");
			   return ERROR;
		   }
		   return SUCCESS;
		}

	   
}
