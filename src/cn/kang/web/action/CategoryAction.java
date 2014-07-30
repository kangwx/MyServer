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

import cn.kang.bean.Category;
import cn.kang.bean.QueryResult;
import cn.kang.service.CategoryService;
import cn.kang.web.formbean.CategoryForm;

@Controller("/category")
public class CategoryAction extends DispatchAction {
	@Resource
	CategoryService categoryService;

	public ActionForward showList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("show category list");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		CategoryForm cuisineForm = (CategoryForm) form;
		int page = cuisineForm.getPage();
		System.out.println("page:" + page);
		QueryResult<Category> query = categoryService.getScrollData();
		JSONArray array = null;
		if (query != null) {
			List<Category> list = query.getResultlist();
			System.out.println("cuisine list size:" + list.size());

			// 生成json数据，发送给客户端
			array = makeJsonStr(list);
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

	private JSONArray makeJsonStr(List<Category> list) {
		JSONArray array = new JSONArray();
		for (Category bean : list) {
			JSONObject obj = new JSONObject();
			 
			obj.put("id", bean.get_id());
			obj.put("channel_id", bean.get_channel_id()); 
			obj.put("title", bean.get_title());
			obj.put("author", bean.get_call_index());
			obj.put("from", bean.get_parent_id());
			obj.put("zhaiyao", bean.get_class_list());
			obj.put("link_url", bean.get_class_layer());
			obj.put("img_url", bean.get_sort_id());
			obj.put("seo_title", bean.get_sort_id());
			obj.put("seo_keywords", bean.get_link_url());
			obj.put("seo_description", bean.get_img_url());
			obj.put("content", bean.get_content());
			obj.put("sort_id", bean.get_seo_title());
			obj.put("click", bean.get_seo_keywords());
			obj.put("is_msg", bean.get_seo_description());
			  
			array.add(obj);

		}
		return array;
	}

}
