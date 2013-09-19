package de.dennishoersch.web.springframework;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import de.dennishoersch.web.springframework.profile.SetProfileContextListener;
import de.dennishoersch.web.wicket.WebConfiguration;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setServletContext(servletContext);
		context.register(WebConfiguration.class);

		new SetProfileContextListener().initialize(context);

		new ContextLoader(context).initWebApplicationContext(servletContext);

		setUpSpringMVC(servletContext, context);

		setUpWicket(servletContext);
	}

	private void setUpSpringMVC(ServletContext servletContext, WebApplicationContext context) {
		ServletRegistration.Dynamic springServletDef = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		springServletDef.addMapping("/mvc/*");
		springServletDef.setLoadOnStartup(1);
	}

	private void setUpWicket(ServletContext servletContext) {
		WicketFilter wicketFilter = new WicketFilter();
		javax.servlet.FilterRegistration.Dynamic wicketFilterDef = servletContext.addFilter("WicketSpring", wicketFilter);
		wicketFilterDef.addMappingForUrlPatterns(null, false, "/wicket/*");
		wicketFilter.setFilterPath("/wicket");
		wicketFilterDef.setInitParameter(WicketFilter.APP_FACT_PARAM, org.apache.wicket.spring.SpringWebApplicationFactory.class.getName());
	}

}
