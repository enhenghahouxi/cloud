package cn.zju.action;

import cn.zju.service.UserService;

public class Check {
	private String phone;
	private UserService userservice; 
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	
	
	public Boolean checkphone() {
		
		try {
			return userservice.findPhone(phone);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
