package springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="controllers")
public class WebConfig {

	/*
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = 
                    new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}*/
	
	/*
	  @Bean public ViewResolver viewResolver() {
	        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	        templateResolver.setTemplateMode("HTML5");
	        templateResolver.setPrefix("/");
	        templateResolver.setSuffix(".html");
	        SpringTemplateEngine engine = new SpringTemplateEngine();
	        engine.setTemplateResolver(templateResolver);
	 
	        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        viewResolver.setTemplateEngine(engine);
	        return viewResolver;
	    }
	 */

	  @Bean
	  public ServletContextTemplateResolver templateResolver() {
	    ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
	    resolver.setPrefix("/views/");
	    resolver.setSuffix(".html");
	    //NB, selecting HTML5 as the template mode.
	    resolver.setTemplateMode("HTML5");
	    resolver.setCacheable(false);
	    return resolver;

	  }

	  public SpringTemplateEngine templateEngine() {
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.setTemplateResolver(templateResolver());
	    return engine;
	  }

	  @Bean
	  public ViewResolver viewResolver() {

	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(templateEngine());
	    viewResolver.setOrder(1);
	    viewResolver.setViewNames(new String[]{"*"});
	    viewResolver.setCache(false);
	    return viewResolver;
	  }

}