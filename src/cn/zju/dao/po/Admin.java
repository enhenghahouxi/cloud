package cn.zju.dao.po;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("admin")
@Scope("prototype")
public class Admin {
		private int id;
		private String password;
		private String adminname;
		//private int isvip;
		
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
		public String getAdminname() {
			return adminname;
		}
		public void setAdminname(String adminname) {
			this.adminname = adminname;
		}
/*		
 		public int getIsvip() {
			return isvip;
		}
		public void setIsvip(int isvip) {
			this.isvip = isvip;
		}
*/
		
}
