package com.example.demo.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class postProcessEnvironment implements EnvironmentPostProcessor  {
	@Override
	public void postProcessEnvironment(final ConfigurableEnvironment environment, final SpringApplication application) {
	    application.setAllowBeanDefinitionOverriding(true);
	  }

}
