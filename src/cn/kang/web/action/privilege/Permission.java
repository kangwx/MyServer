package cn.kang.web.action.privilege;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ȩ������
 *
 */
@Retention(RetentionPolicy.RUNTIME) //���Permissionע�Ᵽ���ڵĽ׶�
@Target(ElementType.METHOD)
public @interface Permission {
	/** ģ�� */
	String module();
	/** Ȩ��ֵ */
	String privilege();
}
