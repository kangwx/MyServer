package cn.kang.service.privilege.impl;

import java.util.List;

import org.springframework.stereotype.Service;
 
import cn.kang.bean.privilege.SystemPrivilege;
import cn.kang.service.base.DaoSupport;
import cn.kang.service.privilege.SystemPrivilegeService;

@Service
public class SystemPrivilegeServiceBean extends DaoSupport<SystemPrivilege> implements SystemPrivilegeService {
	
	public void batchSave(List<SystemPrivilege> privileges){
		for(SystemPrivilege p : privileges){
			save(p);
		}
	}
}
