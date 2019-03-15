package cn.zju.dao.mapper;

import cn.zju.dao.po.Relation;


public interface RelationMapper {
	public void insertRelation(Relation relation) throws Exception;
	public Integer findRelation(Relation relation) throws Exception;
	public Integer checkRelation(Relation relation) throws Exception;
	public void deleteRelationById(int relationid) throws Exception;
	public void deleteRelationByGroupId(int groupid) throws Exception;
}
