package cn.zju.action;

import java.io.File;
import java.io.Serializable;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.zju.dao.po.User;
import cn.zju.service.UserService;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogupAction extends ActionSupport implements Serializable{

	private String username;
	private String password;
	private String password2;
	private String phone;//手机号码
	private String code;//验证码
	
	private UserService service; 
	private User user;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	//当进行注册前，检查参数是否正确
	public void validateLogup(){

		if("".equals(username) || "".equals(password)||"".equals(code)){
			ServletActionContext.getRequest().setAttribute("usernameerror", "用户名必须6-20位");
			ServletActionContext.getRequest().setAttribute("passworderror", "密码必须6-20位");
			ServletActionContext.getRequest().setAttribute("codeerror", "验证码必须6位");
		    addFieldError("", "");
	    }else if(username.length() > 20 || username.length() < 6){
			ServletActionContext.getRequest().setAttribute("usernameerror", "用户名必须6-20位");
	        addFieldError("", "");
		}else if(password.length() > 20 || password.length() < 6){
			ServletActionContext.getRequest().setAttribute("passworderror", "密码必须6-20位");
			addFieldError("", "");
		}else if(code.length() != 6 ){
			ServletActionContext.getRequest().setAttribute("codeerror", "验证码必须6位");
			addFieldError("", "");
		}
		if(!password2.equals(password)) {
			ServletActionContext.getRequest().setAttribute("passworderror", "密码前后必须一致");
			addFieldError("", "");
		}
	}
	
	public String logup(){
		try {
			{
    			if(service.findPhone(phone)) {
    				ServletActionContext.getRequest().setAttribute("codeerror", "该手机号码已经注册过，不能再注册了");
    				return ERROR;
    			}
			}
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("codeerror", "该手机号码已经注册过，不能再注册了");
			return ERROR;
		}
		
		String realphone = "123456789";
		String realcode ="1234";
		realphone = (String) ActionContext.getContext().getSession().get("phonenumber");
		realcode = (String) ActionContext.getContext().getSession().get("codenumber");
		try {
			if("".equals(realcode)||null==realcode||"".equals(realphone)||realphone==null)
			{
				ServletActionContext.getRequest().setAttribute("codeerror", "session为空");
				return ERROR;
			}
			if(!realphone.equals(phone)||!realcode.equals(code)) {
				ServletActionContext.getRequest().setAttribute("codeerror", "验证码不正确");
				return ERROR;
			}
		}catch (Exception e) {
			e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("usernameerror", "session有问题");
			return ERROR;
		}
		
		
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		try {
			service.createUser(user); //如果用户已注册 下层的service会抛出异常
			//注册成功，就在upload下分配一个私人的文件夹
			String path = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
			File file = new File(path+File.separator+username);
			file.mkdir();
			ServletActionContext.getRequest().setAttribute("globalmessage", "规定时间内已经注册过一次了");
			ActionContext.getContext().getSession().put("globalmessage", "规定时间内已经注册过一次了");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("usernameerror", "该用户已注册");
			return ERROR;
		}
	}
}
