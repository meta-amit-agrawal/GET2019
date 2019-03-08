package com.metacube.EAD_Assignment_8.configurator;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//all the request are mapped to the Dispatcher Servlet with the help of this class
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { MvcWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		 return new String[] { "/" };
	}

}
