package com.utc.config;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.utc.interceptors.ServiceInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource rsb= new ReloadableResourceBundleMessageSource();
		rsb.setBasename("WEB-INF/studentmessages");
		rsb.setCacheSeconds(1);
		return rsb;
		
		
	}
	
	@Bean 
	public ServiceInterceptor getInterceptor()
	{
		return new ServiceInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getInterceptor())
		.addPathPatterns(new String[] {"/reg"});
	}
	
	@Bean 
	public SimpleMappingExceptionResolver getMappingResolver()
	{
		SimpleMappingExceptionResolver smp= new SimpleMappingExceptionResolver();
		Properties p = new Properties();
		p.setProperty(NullPointerException.class.getName(),"Nullpointer");
		p.setProperty(ArithmeticException.class.getName(),"Arithematic");
		smp.setExceptionMappings(p);
		smp.addStatusCode("Nullpointer",404);
		smp.addStatusCode("Arithematic", 404);
		smp.setDefaultErrorView("GlobalException");
//		smp.setDefaultStatusCode(400);
		return smp;
		
		
	}
	
	 
}
