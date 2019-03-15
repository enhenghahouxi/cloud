package cn.zju.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zju.dao.mapper.RelationMapper;
import cn.zju.dao.po.Relation;



@Service(value="relationService")
public class RelationService {
	
	@Autowired
	private RelationMapper dao;

	public void insertRelation(Relation relation) throws Exception{
		Boolean found = findRelation(relation);
		if(!found)
		   dao.insertRelation(relation);
		else
			throw new RuntimeException();
	}
	
	public Integer checkRelation(Relation relation) throws Exception{
		return dao.checkRelation(relation);
	}
	
	public boolean findRelation(Relation relation) throws Exception{
		Integer found = dao.findRelation(relation);
		if(found==null || found<1)  return false;
		return true;
	}

	public void deleteRelationById(int relationid) throws Exception{
		dao.deleteRelationById(relationid);
	}
	
	public void deleteRelationByGroupId(int groupid) throws Exception{
		dao.deleteRelationByGroupId(groupid);
	}
}
