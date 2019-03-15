package cn.zju.dao.mapper;

import cn.zju.dao.po.Admin;

public interface AdminMapper {
	public void createAdmin(Admin admin) throws Exception;
	public String checkAdmin(Admin admin) throws Exception;
	public Integer findAdmin(String adminname) throws Exception;
	//public Integer isVip(String user_name)throws Exception;
}
