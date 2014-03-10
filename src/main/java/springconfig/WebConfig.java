package springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan({ "controllers", "services" })
public class WebConfig {



	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/views/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewNames(new String[] { "jsp_*" });
		resolver.setOrder(2);

		return resolver;
	}

	@Bean
	public ViewResolver thymeLeafViewResolver() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(getThymeleafTemplateResolver());
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		viewResolver.setOrder(1);
		viewResolver.setViewNames(new String[] { "th_*" });
		viewResolver.setCache(false);
		return viewResolver;
	}
	
	private ServletContextTemplateResolver getThymeleafTemplateResolver() {
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
		resolver.setPrefix("/views/thymeleaf/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		resolver.setCacheable(false);
		return resolver;

	}

}