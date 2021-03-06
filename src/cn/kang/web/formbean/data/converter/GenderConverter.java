package cn.kang.web.formbean.data.converter;

import org.apache.commons.beanutils.Converter;

import cn.kang.bean.Gender;
 

public class GenderConverter implements Converter{

	@SuppressWarnings("unchecked")
	public Object convert(Class clazz, Object value) {
		if(value instanceof Gender) return value;
		try{
			return Gender.valueOf((String) value);
		}catch (Exception e) {}
		return null;
	}
}
