package com.utc.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ServiceInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		Calendar cal= Calendar.getInstance();
		int dayOfWeek= cal.get(cal.DAY_OF_WEEK);
		if(dayOfWeek==2)
		{
			response.getWriter().write("This website is closed for now ... please login on some another day");
			return false;
		}
		return true;
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("inside post handle method..");
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("inside aftercompletion method...");
	}
	
}
