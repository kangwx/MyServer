package cn.kang.service;
 
import cn.kang.bean.Institution;
import cn.kang.bean.QueryResult;
import cn.kang.service.base.DAO;

public interface InstitutionService extends DAO<Institution> {

	public QueryResult<Institution>  getScrollDataByPage(int page);
	
}
