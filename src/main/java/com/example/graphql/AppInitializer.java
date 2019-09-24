package com.example.graphql;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
	public void onStartup(ServletContext ctx) throws ServletException {
	
		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
		webCtx.setConfigLocation("com.example.graphql");
		webCtx.register(AppInitializer.class);
        webCtx.setServletContext(ctx);
		ServletRegistration.Dynamic dispatcher = ctx.addServlet("DispatcherServlet",new DispatcherServlet(webCtx));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/*");

	}

}
