package cn.kang.service.privilege;

import cn.kang.bean.privilege.Employee;
import cn.kang.service.base.DAO;
 
 
public interface EmployeeService extends DAO<Employee> {
	/**
	 * �ж��û����Ƿ����
	 * @param username �û���
	 * @return
	 */
	public boolean exist(String username);
	/**
	 * �ж��û��������Ƿ���ȷ
	 * @param username �û���
	 * @param password ����
	 * @return
	 */
	public boolean validate(String username, String password);
}
