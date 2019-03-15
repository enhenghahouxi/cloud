package cn.zju.action;


import java.io.Serializable;

import org.apache.struts2.ServletActionContext;

import cn.zju.dao.po.Admin;
import cn.zju.service.AdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport implements Serializable{

	private String adminname;
	private String password;
	private AdminService service; 
	private Admin admin;
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setService(AdminService service) {
		this.service = service;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	public void validateLogin(){
		
	    if("".equals(adminname) || "".equals(password)){
			ServletActionContext.getRequest().setAttribute("error", "管理员账号或密码错误");
            addFieldError("", "");
		}
	}
	
	public String login(){
		
		admin.setAdminname(adminname);
		admin.setPassword(password);
		try {
			String admin_name = service.checkAdmin(admin);
			if( admin_name != null && (!"".equals(admin_name)) ){
				//如果登陆成功 把用户名放到session域
				ActionContext.getContext().getSession().put("admin_name", admin_name);
			    return SUCCESS;
			}
			ServletActionContext.getRequest().setAttribute("adminerror", "管理员账号或密码错误");
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
