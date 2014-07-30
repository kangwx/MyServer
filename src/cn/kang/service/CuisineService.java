package cn.kang.service;

import cn.kang.bean.Cuisine;
import cn.kang.bean.QueryResult;
import cn.kang.service.base.DAO;

public interface CuisineService extends DAO<Cuisine> {

	public QueryResult<Cuisine>  getScrollDataByPage(int page);
	
}
