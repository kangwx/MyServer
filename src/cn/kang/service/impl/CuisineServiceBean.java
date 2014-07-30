package cn.kang.service.impl;
 

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.kang.bean.Cuisine; 
import cn.kang.bean.QueryResult;
import cn.kang.service.CuisineService;
import cn.kang.service.base.DaoSupport;

@Service @Transactional
public class CuisineServiceBean extends DaoSupport<Cuisine> implements CuisineService {
	private int pageCount = 5; 
	
	public QueryResult<Cuisine> getScrollDataByPage(int page) {
		// TODO Auto-generated method stub
		int firstIndex = (page-1)*pageCount;
		QueryResult<Cuisine> result = this.getScrollData(firstIndex, pageCount);
		if(result.getResultlist().size()<=0){
			System.out.println("cuisine list result is 0 ;return null");
			return null;
		}
		return result;
	}

	 

}
