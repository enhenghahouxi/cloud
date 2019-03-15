package cn.zju.dao.po;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("user")
@Scope("prototype")
public class User  {
	private int id;
	private String password;
	private String username;
	private int isvip;
	private int totalcapa;
	private int usedcapa;
	private Date createtime;
	private String phone;
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getIsvip() {
		return isvip;
	}
	public void setIsvip(int isvip) {
		this.isvip = isvip;
	}
	public int getTotalcapa() {
		return totalcapa;
	}
	public void setTotalcapa(int totalcapa) {
		this.totalcapa = totalcapa;
	}
	public int getUsedcapa() {
		return usedcapa;
	}
	public void setUsedcapa(int usedcapa) {
		this.usedcapa = usedcapa;
	}

}
