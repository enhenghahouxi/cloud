package cn.zju.dao;


import org.apache.ibatis.session.SqlSession;
import cn.zju.dao.mapper.RelationMapper;
import cn.zju.dao.po.Relation;


public class RelationDao {
	
	//创建关系
	public void insertRelation(Relation relation) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		RelationMapper mapper = session.getMapper(RelationMapper.class);
		mapper.insertRelation(relation);
		session.commit();
		session.close();
	}
	
	//查看数据库里是否存在匹配的关系记录 
	public int checkRelation(Relation relation)throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		RelationMapper mapper = session.getMapper(RelationMapper.class);
		int userid = mapper.checkRelation(relation);
		session.close();
		return userid;
	}
	
	//查找指定的关系是否存在
	public Boolean findRelation(Relation relation) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		RelationMapper mapper = session.getMapper(RelationMapper.class);
		Integer found = mapper.findRelation(relation);
		session.close();
		if(found==null || found<1)  return false;
		return true;
	}
	
	public void deleteRelationById(int relationid) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		RelationMapper mapper = session.getMapper(RelationMapper.class);
		mapper.deleteRelationById(relationid);
		session.commit();
		session.close();
	}
	
	public void deleteRelationByGroupId(int groupid) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		RelationMapper mapper = session.getMapper(RelationMapper.class);
		mapper.deleteRelationByGroupId(groupid);
		session.commit();
		session.close();
	}
}