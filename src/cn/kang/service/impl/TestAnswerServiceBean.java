package cn.kang.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.kang.bean.test.TestAnswer;
import cn.kang.service.TestAnswerService;
import cn.kang.service.base.DaoSupport;
@Service @Transactional
public class TestAnswerServiceBean extends DaoSupport<TestAnswer> implements TestAnswerService {
 

}
