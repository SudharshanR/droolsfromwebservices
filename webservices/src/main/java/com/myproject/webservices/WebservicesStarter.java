package com.myproject.webservices;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

@SpringBootApplication
@EnableAutoConfiguration
//@EntityScan(basePackageClasses = GlobalPropertiesDAO.class)
public class WebservicesStarter {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebservicesStarter.class);
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(WebservicesStarter.class, args);
        
        ClassPathScanningCandidateComponentProvider provider =
        	    new ClassPathScanningCandidateComponentProvider(true);
        	String basePackage = "com.myproject.webservices.returns";
        	Set<BeanDefinition> components = provider.findCandidateComponents(basePackage);
        	for (BeanDefinition component : components) {
        	    LOGGER.info("Component: "+component.getBeanClassName());       
        	}
        	 
    }

}
