package com.gj.demo.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

public class ParamInterceptor implements HandlerInterceptor{
	protected static Log LOG = LogFactory.getLog(ParamInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		handleRequestLog(request);
		return true;
	}

	protected void handleRequestLog(HttpServletRequest request) {
		LOG.debug("----------------->requestUrl:" + request.getRequestURL().toString() + ",params：" + new Gson().toJson(request.getParameterMap()));
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
}
