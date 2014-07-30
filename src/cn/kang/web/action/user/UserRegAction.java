package cn.kang.web.action.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import cn.kang.bean.User;
import cn.kang.service.UserService;
import cn.kang.web.formbean.UserForm;

@Controller("/user/reg")
public class UserRegAction extends DispatchAction {
	@Resource UserService userService;

	public ActionForward regUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("go to register user page"); 
		return mapping.findForward("regUI");
	}
	
	public ActionForward isUserExsit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("register user");
		UserForm formbean = (UserForm) form;
		request.setAttribute("exsit", userService.exsit(formbean.getUsername()));
		return mapping.findForward("checkuser");
	}
	 
	public ActionForward reg(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm formbean = (UserForm) form;
		if(!userService.exsit(formbean.getUsername())){
			User user = new User(formbean.getUsername(),formbean.getPassword(), formbean.getEmail());
			userService.save(user);
			request.getSession().setAttribute("user", user);		
			request.setAttribute("message", "注册成功");
			String url = "/user/logon.do";
			if(formbean.getDirectUrl()!=null) url = formbean.getDirectUrl();
			request.setAttribute("urladdress", url);
			return mapping.findForward("message");
		}else{
			request.setAttribute("message", "该用户已经存在");
			return mapping.findForward("reg");
		}
	}
}
