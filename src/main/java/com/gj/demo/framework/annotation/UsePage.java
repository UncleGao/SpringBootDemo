package com.gj.demo.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * service需要分页时，使用此注解
 * @author gao
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UsePage {
	int pageSize() default 1;
	int pageNum() default 1;
}
