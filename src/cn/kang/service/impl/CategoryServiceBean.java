package cn.kang.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.kang.bean.Category;
import cn.kang.service.CategoryService;
import cn.kang.service.base.DaoSupport;
@Service @Transactional
public class CategoryServiceBean extends DaoSupport<Category> implements CategoryService {
 

}
