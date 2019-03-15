package cn.zju.dao.po;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("group")
@Scope("prototype")
public class Group{
		private int id;
		private String groupname;
		private int hasmembernum;
		private String arceus;
		private int limitmembernum;
		private String invitecode;
		private Date createtime;
		private int usedcapa;
		private int totalcapa;

		
		public int getUsedcapa() {
			return usedcapa;
		}
		public void setUsedcapa(int usedcapa) {
			this.usedcapa = usedcapa;
		}
		public int getTotalcapa() {
			return totalcapa;
		}
		public void setTotalcapa(int totalcapa) {
			this.totalcapa = totalcapa;
		}
		public String getInvitecode() {
			return invitecode;
		}
		public void setInvitecode(String invitecode) {
			this.invitecode = invitecode;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getGroupname() {
			return groupname;
		}
		public void setGroupname(String groupname) {
			this.groupname = groupname;
		}
		public int getHasmembernum() {
			return hasmembernum;
		}
		public void setHasmembernum(int hasmembernum) {
			this.hasmembernum = hasmembernum;
		}
		public String getArceus() {
			return arceus;
		}
		public void setArceus(String arceus) {
			this.arceus = arceus;
		}
		public int getLimitmembernum() {
			return limitmembernum;
		}
		public void setLimitmembernum(int limitmembernum) {
			this.limitmembernum = limitmembernum;
		}
		public Date getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}
			
}