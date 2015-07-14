package com.myproject.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;


@SpringBootApplication
public class ApplicationStarter {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStarter.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationStarter.class, args);    

		ClassPathScanningCandidateComponentProvider provider =
				new ClassPathScanningCandidateComponentProvider(true);
		String basePackage = "com.myproject.controller";
		Set<BeanDefinition> components = provider.findCandidateComponents(basePackage);
		for (BeanDefinition component : components) {
			LOGGER.info("Component: "+component.getBeanClassName());       
		}
	}

}