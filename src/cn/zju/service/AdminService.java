package cn.zju.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.zju.dao.mapper.AdminMapper;
import cn.zju.dao.po.Admin;

@Service(value="adminService")
public class AdminService {
	
	@Autowired
	private AdminMapper dao;

	public void createAdmin(Admin admin) throws Exception{
		Boolean found = findUser(admin.getAdminname());
		if(!found)
		   dao.createAdmin(admin);
		else
			throw new RuntimeException();
	}
	
	public String checkAdmin(Admin admin ) throws Exception{
		return dao.checkAdmin(admin);
	}
	
	public boolean findUser(String adminname) throws Exception{
		Integer found = dao.findAdmin(adminname);
		if(found==null || found<1)  return false;
		return true;
	}

	//public int isVip(String admin_name)throws Exception {
	//	return dao.isVip(admin_name);
	//}
}
