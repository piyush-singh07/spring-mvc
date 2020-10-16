/*package com.crs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

*//**
 * Servlet Filter implementation class CORSFilter
 *//*
@WebFilter("/*")
@Component
public class CORSFilter implements Filter {

    *//**
     * Default constructor. 
     *//*
    public CORSFilter() {
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see Filter#destroy()
	 *//*
	public void destroy() {
		// TODO Auto-generated method stub
	}

	*//**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 *//*
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res=(HttpServletResponse) response;
		HttpServletRequest req=(HttpServletRequest) request;
		System.out.println("******* Filter Executed ********");
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Credentials", "false");
		res.addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST, DELETE");
		res.addHeader("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type, Accept");
		if("OPTIONS".equals(req.getMethod()))
			res.setStatus(200);
		else
		{
			chain.doFilter(request, res);
		}
	}

	*//**
	 * @see Filter#init(FilterConfig)
	 *//*
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
*/