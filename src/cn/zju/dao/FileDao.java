package cn.zju.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zju.action.ChangeFileStatusAction;
import cn.zju.action.SearchFileAction;
import cn.zju.action.SearchGroupFileAction;
import cn.zju.action.SearchUserFileAction;
import cn.zju.dao.DaoUtil;
import cn.zju.dao.mapper.FileMapper;
//import cn.zju.dao.mapper.GroupMapper;
import cn.zju.dao.po.File;

public class FileDao {

	//符合搜索内容的所有共享文件
	public List<File> getAllFiles(SearchFileAction searchFileAction) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		FileMapper mapper = session.getMapper(FileMapper.class);
		List<File> allFiles = mapper.getAllFiles(searchFileAction);
		session.close();
		return allFiles;
	}
	
	//统计符合搜索的内容的文件里 ，有多少文件是共享的
	public int countShareFiles(SearchFileAction searchFileAction )throws Exception{
	   SqlSession session = DaoUtil.getSqlSession();
	   FileMapper mapper = session.getMapper(FileMapper.class);
	   int totalrecord = mapper.countFiles(searchFileAction);
	   session.close();
	   return totalrecord;
	}
	
	public String findFilepathById(int id) throws Exception{
		   SqlSession session = DaoUtil.getSqlSession();
		   FileMapper mapper = session.getMapper(FileMapper.class);
		   String filepath =  mapper.findFilepathById(id);
		   session.close();
		   return filepath;
	}
	//上传的文件信息添加到数据库的表file
	public Integer insertFile(File file)throws Exception{
		   SqlSession session = DaoUtil.getSqlSession();
		   FileMapper mapper = session.getMapper(FileMapper.class);
		   Integer fileid = mapper.insertFile(file);
		   session.commit();
		   session.close();
		   return fileid;
	}
	//根据用户名得用户的文件
	public List<File> getUserFiles(SearchUserFileAction action) throws Exception{
		   SqlSession session = DaoUtil.getSqlSession();
		   FileMapper mapper = session.getMapper(FileMapper.class);
		   List<File> userFiles = mapper.getUserFiles(action);
		   session.close();
		   return userFiles;
	}

	//统计一个用户一共多少文件
	public int countUserFiles(SearchUserFileAction action) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		FileMapper mapper = session.getMapper(FileMapper.class);
		int count = mapper.countUserFiles(action);
		session.close();
		return count;
	}
	
	//根据群组名得群组的文件
	public List<File> getGroupFiles(SearchGroupFileAction action) throws Exception{
		   SqlSession session = DaoUtil.getSqlSession();
		   FileMapper mapper = session.getMapper(FileMapper.class);
		   List<File> groupFiles = mapper.getGroupFiles(action);
		   session.close();
		   return groupFiles;
	}
	
	//统计一个群组一共多少文件
	public int countGroupFiles(SearchGroupFileAction action) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		FileMapper mapper = session.getMapper(FileMapper.class);
		int count = mapper.countGroupFiles(action);
		session.close();
		return count;
	}
	
	public void updateFileById(ChangeFileStatusAction changeFileStatusAction) throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		FileMapper mapper = session.getMapper(FileMapper.class);
		mapper.updateFileById(changeFileStatusAction);
		session.commit();
		session.close();
	}

	public void deleteFileById(int id)throws Exception {
		SqlSession session = DaoUtil.getSqlSession();
		FileMapper mapper = session.getMapper(FileMapper.class);
		mapper.deleteFileById(id);
		session.commit();
		session.close();
	}
	public void deleteFileByPath(String path)throws Exception {
		SqlSession session = DaoUtil.getSqlSession();
		FileMapper mapper = session.getMapper(FileMapper.class);
		mapper.deleteFileByPath(path);
		session.commit();
		session.close();
	}

	public String findFilenameById(int id)throws Exception {
		SqlSession session = DaoUtil.getSqlSession();
		FileMapper mapper = session.getMapper(FileMapper.class);
		String filename = mapper.findFilenameById(id);
		session.close();
	    return filename;
	}
	public int getFilesizeByName(String filename)throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		FileMapper mapper = session.getMapper(FileMapper.class);
		int filesize = mapper.getFilesizeByName(filename);
		session.close();
	    return filesize;
	}
	public int getFilesizeById(int id)throws Exception{
		SqlSession session = DaoUtil.getSqlSession();
		FileMapper mapper = session.getMapper(FileMapper.class);
		int filesize = mapper.getFilesizeById(id);
		session.close();
	    return filesize;
	}
}
