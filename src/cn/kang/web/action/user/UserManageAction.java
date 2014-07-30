package cn.kang.web.action.user;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import cn.kang.service.UserService;
import cn.kang.utils.SiteUrl;
import cn.kang.web.formbean.UserForm;

 
@Controller("/control/user/manage")
public class UserManageAction extends DispatchAction {
	@Resource  UserService userService;
 
	public ActionForward enable(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm formbean = (UserForm)form;
		userService.enable((Serializable[])formbean.getUsernames());
		request.setAttribute("message", "成功启用用户");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.user.list"));
		return mapping.findForward("message");
	}
 
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
		UserForm formbean = (UserForm)form;
		userService.delete((Serializable[])formbean.getUsernames());
		request.setAttribute("message", "成功禁用用户");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.user.list"));
		return mapping.findForward("message");
	}
}
