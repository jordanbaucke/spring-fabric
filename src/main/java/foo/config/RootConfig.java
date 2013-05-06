package foo.config;

import org.springframework.context.annotation.*;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import foo.api.MonitorService;
import foo.api.ServiceUsageAop;

@Configuration
@ComponentScan(basePackages = { "foo" })
@EnableAspectJAutoProxy
public class RootConfig {
	
	@Bean 
	public static MonitorService monitorService(){
		return new MonitorService();
	}
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("/persistence.properties"));
		return ppc;
	}
	
}