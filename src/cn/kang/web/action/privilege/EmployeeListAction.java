package cn.kang.web.action.privilege;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.kang.bean.PageView;
import cn.kang.bean.privilege.Employee;
import cn.kang.service.privilege.EmployeeService;
import cn.kang.web.formbean.privilege.EmployeeForm;
 
/**
 * Ա����ҳ�б�
 */
@Controller("/control/employee/list")
public class EmployeeListAction extends Action {
	@Resource EmployeeService employeeService;

	@Override @Permission(module="employee", privilege="view")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm formbean = (EmployeeForm) form;
		PageView<Employee> pageView = new PageView<Employee>(12, formbean.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("realname", "desc");
		if("true".equals(formbean.getQuery())){//���4�Բ�ѯҳ��
			StringBuilder jpql = new StringBuilder();
			List<Object> params = new ArrayList<Object>();
			if(formbean.getUsername()!=null && !"".equals(formbean.getUsername().trim())){
				params.add("%"+ formbean.getUsername().trim() +"%");
				jpql.append("o.username like ?").append(params.size());
			}
			if(formbean.getRealname()!=null && !"".equals(formbean.getRealname().trim())){
				if(!params.isEmpty()) jpql.append(" and ");
				params.add("%"+ formbean.getRealname().trim() +"%");
				jpql.append("o.realname like ?").append(params.size());
			}
			if(formbean.getDepartmentid()!=null && !"".equals(formbean.getDepartmentid().trim())){
				if(!params.isEmpty()) jpql.append(" and ");
				params.add(formbean.getDepartmentid());
				jpql.append("o.department.departmentid=?").append(params.size());
			}
			pageView.setQueryResult(
					employeeService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(),
							jpql.toString(), params.toArray(), orderby));
		}else{
			pageView.setQueryResult(employeeService.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(), orderby));
		}		
		request.setAttribute("pageView", pageView);
		return mapping.findForward("list");
	}

}
