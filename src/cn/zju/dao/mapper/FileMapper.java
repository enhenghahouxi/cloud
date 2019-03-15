package cn.zju.dao.mapper;

import java.util.List;

import cn.zju.action.ChangeFileStatusAction;

import cn.zju.action.SearchFileAction;
import cn.zju.action.SearchGroupFileAction;
import cn.zju.action.SearchUserFileAction;
import cn.zju.dao.po.File;

public interface FileMapper {
	
	public List<File> getAllFiles(SearchFileAction searchFileAction) throws Exception;
	public int countFiles(SearchFileAction searchFileAction) throws Exception;
	public String findFilepathById(int id) throws Exception;
	public Integer insertFile(File file) throws Exception;
	public List<File> getUserFiles(SearchUserFileAction action)throws Exception;

	public List<File> getGroupFiles(SearchGroupFileAction action)throws Exception;
	public int countUserFiles(SearchUserFileAction action) throws Exception;

	public int countGroupFiles(SearchGroupFileAction action) throws Exception;
	public void updateFileById(ChangeFileStatusAction changeFileStatusAction) throws Exception;
	public void deleteFileById(int id)throws Exception;
	public String findFilenameById(int id)throws Exception;
	public int getFilesizeByName(String filename)throws Exception;
	public int getFilesizeById(int id)throws Exception;
	public void deleteFileByPath(String path)throws Exception;
	
}
