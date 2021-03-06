package es.upv.pros.pvalderas.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
 
@SpringBootApplication
@EnableZuulProxy
public class ZuulServer {
	
 
	public static void main(String[] args) {
		SpringApplication.run(ZuulServer.class, args);
	}
	
	 @Bean
	 public FilterRegistrationBean corsFilter() {
	     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	     CorsConfiguration config = new CorsConfiguration();
	     config.setAllowCredentials(true);
	     config.addAllowedOrigin("*");
	     config.addAllowedHeader("*");
	     config.addAllowedMethod("*");
	     source.registerCorsConfiguration("/**", config);
	     FilterRegistrationBean bean = new FilterRegistrationBean(new org.springframework.web.filter.CorsFilter(source));
	     bean.setOrder(0);
	     return bean;
	 }
}

				
