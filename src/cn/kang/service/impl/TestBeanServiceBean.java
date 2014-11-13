package cn.kang.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.kang.bean.test.TestBean;
import cn.kang.service.TestBeanService;
import cn.kang.service.base.DaoSupport;
@Service @Transactional
public class TestBeanServiceBean extends DaoSupport<TestBean> implements TestBeanService {
 

}
