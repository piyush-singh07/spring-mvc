package com.utc.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.utc.model.Student;
import com.utc.util.NameEditor;

@Controller
public class MyController {

	@RequestMapping(value="/reg", method=RequestMethod.GET)
	public ModelAndView getRegistraionPage()
	{
//		String err= "arithematicexception";
//		if(err.equals(err))
//		{
//			throw new ArithmeticException();
//		}
		
		return new ModelAndView("registrationpage");
		
	}
	
	@RequestMapping(value="/hellouser" , method=RequestMethod.GET)
	public ModelAndView getHello()
	{
		return new ModelAndView("hello");
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder	) {
//		binder.setDisallowedFields(new String[] {"smobile"});
//		SimpleDateFormat date= new SimpleDateFormat("dd/mm/yyyy");
//		binder.registerCustomEditor(Date.class, "sdob", new CustomDateEditor(date, false));
//	    binder.registerCustomEditor(String.class,"sname",new NameEditor());
	}
	@ModelAttribute
	public void commonObject(Model model)
	{
		model.addAttribute("headermessage", "GCC IT");
	}
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public ModelAndView getSuccessPage(@Valid @ModelAttribute("student") Student student , BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("registrationpage");
		}
		else
		return new ModelAndView("registrationdetails");
		
	}
}
