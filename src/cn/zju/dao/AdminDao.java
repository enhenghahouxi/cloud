package cn.zju.dao;

import org.apache.ibatis.session.SqlSession;

import cn.zju.dao.DaoUtil;
import cn.zju.dao.mapper.AdminMapper;
import cn.zju.dao.po.Admin;

public class AdminDao {
	 //创建用户
		public void createAdmin(Admin admin) throws Exception{
			SqlSession session = DaoUtil.getSqlSession();
			AdminMapper mapper = session.getMapper(AdminMapper.class);
			mapper.createAdmin(admin);
			session.commit();
			session.close();
		}
		//如果数据库里存在用户名和密码都匹配的记录 代表登陆成功
		public String checkAdmin(Admin admin)throws Exception{
			SqlSession session = DaoUtil.getSqlSession();
			AdminMapper mapper = session.getMapper(AdminMapper.class);
			String admin_name = mapper.checkAdmin(admin);
			session.close();
			return admin_name;
		}
		//查找指定用户名的用户是否存在
		public boolean findAdmin(String adminname)throws Exception{
			SqlSession session = DaoUtil.getSqlSession();
			AdminMapper mapper = session.getMapper(AdminMapper.class);
			Integer found = mapper.findAdmin(adminname);
			session.close();
			if(found==null || found<1)  return false;
			return true;
		}

}
