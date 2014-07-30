package cn.kang.web.action.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.kang.service.UserService;
import cn.kang.web.formbean.UserForm;


@Controller("/user/logon")
public class LogonAction extends Action {
	@Resource UserService userService;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm formbean = (UserForm) form;
		if(formbean.getUsername()!=null && !"".equals(formbean.getUsername().trim())
				&& formbean.getPassword()!=null && !"".equals(formbean.getPassword().trim())){
			if(userService.checkUser(formbean.getUsername().trim(), formbean.getPassword().trim())){				
				request.getSession().setAttribute("user", userService.find(formbean.getUsername().trim()));
				String url = "/user/logon.do";
				request.setAttribute("message", "登录成功");
				if(formbean.getDirectUrl()!=null) url = formbean.getDirectUrl();
				request.setAttribute("urladdress", url);
				return mapping.findForward("message");
			}
			request.setAttribute("message", "登陆失败");
		}
		return mapping.findForward("logon");
	}
}
