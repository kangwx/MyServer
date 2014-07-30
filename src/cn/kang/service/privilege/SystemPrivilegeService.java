package cn.kang.service.privilege;

import java.util.List;

import cn.kang.bean.privilege.SystemPrivilege;
import cn.kang.service.base.DAO;

public interface SystemPrivilegeService extends DAO<SystemPrivilege> {
 
	public void batchSave(List<SystemPrivilege> privileges);
}
