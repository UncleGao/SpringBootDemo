package com.gj.demo.framework.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.gj.demo.framework.annotation.UsePage;

/**
 *  自动分页切点，参数顺序固定
 * @author gao
 *
 */
@Aspect
@Component
public class PageAspect {
	protected static Logger log = LoggerFactory.getLogger(PageAspect.class);
    @Before("execution(* com.gj.demo..*.*(..)) && @annotation(rl)")  
    public void doPage(JoinPoint jp, UsePage rl){ 
        Object[] parames = jp.getArgs();//获取目标方法体参数  
        PageHelper.startPage(Integer.parseInt(parames[0].toString()), Integer.parseInt(parames[1].toString()));
    }  
}
