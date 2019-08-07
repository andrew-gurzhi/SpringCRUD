package testgroup.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

	@Configuration
	@EnableWebMvc
	public class MvcConfig implements WebMvcConfigurer {
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler(
					"/webjars/**",
					"/img/**",
					"/css/**",
					"/static/js/**")
					.addResourceLocations(
							"classpath:/sources/templates/",
							"classpath:/static/img/",
							"classpath:/static/css/",
							"classpath:/static/js/");
		}
	}


