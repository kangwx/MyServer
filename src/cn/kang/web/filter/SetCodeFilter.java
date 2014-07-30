package cn.kang.web.filter;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.velocity.app.Velocity;

import cn.kang.bean.Gender;
import cn.kang.bean.privilege.SystemPrivilegePK;
import cn.kang.web.formbean.data.converter.DateConverter;
import cn.kang.web.formbean.data.converter.GenderConverter;
import cn.kang.web.formbean.data.converter.SystemPrivilegePKConverter;


public class SetCodeFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterchain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding("UTF-8");
		filterchain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		/*
		ConvertUtils.register(new SexConverter(), Sex.class);
		ConvertUtils.register(new DeliverWayConverter(), DeliverWay.class);
		ConvertUtils.register(new PaymentWayConverter(), PaymentWay.class);
		ConvertUtils.register(new OrderStateConverter(), OrderState.class);
		*/
		ConvertUtils.register(new DateConverter(), Date.class);
		ConvertUtils.register(new GenderConverter(), Gender.class);
		ConvertUtils.register(new SystemPrivilegePKConverter(), SystemPrivilegePK.class);
		
		try{
			Properties prop = new Properties();
			prop.put("runtime.log", config.getServletContext().getRealPath("/WEB-INF/log/velocity.log"));
			prop.put("file.resource.loader.path", config.getServletContext().getRealPath("/WEB-INF/vm"));
			prop.put("input.encoding", "UTF-8");
			prop.put("output.encoding", "UTF-8");
			Velocity.init(prop);
		}catch( Exception e ){
			e.printStackTrace();
		}
	}

}
