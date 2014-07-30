package cn.kang.web.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import cn.kang.bean.Cuisine;
import cn.kang.bean.Institution;
import cn.kang.bean.QueryResult;
import cn.kang.service.InstitutionService;
import cn.kang.web.formbean.InstitutionForm;

@Controller("/institution/showList")
public class InstitutionAction extends DispatchAction {
	@Resource
	InstitutionService institutionService;

	public ActionForward showList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("show instituion list");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		InstitutionForm instituionForm = (InstitutionForm) form;
		int page = instituionForm.getPage();
		System.out.println("page:" + page);
		QueryResult<Institution> query = institutionService.getScrollDataByPage(page);
		JSONArray array = null;
		if (query != null) {
			List<Institution> list = query.getResultlist();
			System.out.println("cuisine list size:" + list.size());

			// 生成json数据，发送给客户端
			//array = makeJsonStr(list);
			//输出
			out.write(array.toString());
		} else {
			System.out.println("no result");
			out.write("");
		}

		out.flush();
		out.close();

		/*
		UserForm formbean = (UserForm)form;
		if(userService.exsit(formbean.getUsername().trim())){
			System.out.println("user is exist");
		}else{
			User user =new User();
			user.setUsername(formbean.getUsername());
			user.setPassword(formbean.getPassword());
			user.setEmail(formbean.getEmail());
			userService.save(user);
		}
		 */
		return null;//mapping.findForward("result");
	}

	private JSONArray makeJsonStr(List<Cuisine> list) {
		JSONArray array = new JSONArray();
		for (Cuisine bean : list) {
			JSONObject obj = new JSONObject();
			obj.put("id", bean.getId());
			obj.put("channel_id", bean.getChannelId());
			obj.put("category_id", bean.getCategoryId());
			obj.put("title", bean.getTitle());
			obj.put("author", bean.getAuthor());
			obj.put("from", bean.getFromPlace());
			obj.put("zhaiyao", bean.getZhaiyao());
			obj.put("link_url", bean.getLinkUrl());
			obj.put("img_url", bean.getImgUrl());
			obj.put("seo_title", bean.getSeoTitle());
			obj.put("seo_keywords", bean.getSeoKeywords());
			obj.put("seo_description", bean.getSeoDescription());
			obj.put("content", bean.getContent());
			obj.put("sort_id", bean.getSortId());
			obj.put("click", bean.getClick());
			obj.put("is_msg", bean.getIsMsg());
			obj.put("is_top", bean.getIsTop());
			obj.put("is_red", bean.getIsRed());
			obj.put("is_hot", bean.getIsHot());
			obj.put("is_slide", bean.getIsSlide());
			obj.put("is_lock", bean.getIsLock());
			obj.put("user_id", bean.getUserId());
			obj.put("add_time", "2013");// bean.getAddTime());
			obj.put("digg_good", bean.getDiggGood());
			obj.put("digg_bad", bean.getDiggBad());
			array.add(obj);

		}
		return array;
	}

}
