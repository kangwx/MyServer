package cn.kang.service.privilege.impl;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cn.kang.bean.privilege.Department;
import cn.kang.bean.privilege.Employee;
import cn.kang.service.base.DaoSupport;
import cn.kang.service.privilege.DepartmentService;
 

@Service
public class DepartmentServiceBean extends DaoSupport<Department> implements DepartmentService {

	@Override
	public void delete(Serializable... entityids) {
		for(Serializable id : entityids){
			Department department = this.find(id);
			for(Employee employee : department.getEmployees()){
				employee.setDepartment(null);
			}
			em.remove(department);
		}
	}

	@Override
	public void save(Department entity) {
		entity.setDepartmentid(UUID.randomUUID().toString());
		super.save(entity);
	}

}
