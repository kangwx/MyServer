package cn.kang.service.uploadfile;

import java.util.List;

import cn.kang.bean.uploadfile.UploadFile;
import cn.kang.service.base.DAO;
 

public interface UploadFileService extends DAO<UploadFile> {
	/**
	 * 获取文件路径
	 * @param ids
	 * @return
	 */
	public List<String> getFilepath(Integer[] ids);
}
