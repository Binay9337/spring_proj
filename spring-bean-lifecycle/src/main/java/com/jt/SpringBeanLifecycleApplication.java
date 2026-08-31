package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBeanLifecycleApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringBeanLifecycleApplication.class, args);

		var greet = context.getBean(Greet.class);
		greet.greet();

	}

}
/*
 * Bean LifeCycle
 * 
 * 1. Bean Instanciated -->> Object is created
 * 2. Dependency Injection(If available) ------>>>>> by any way of
 * 3. Bean Initialized ======>>>> @PostConstruct
 * 4. Bean Used
 * 5. Bean Destroyed =============>>>>> @PreDestroy
 * 
 * --Managed By Spring Container
 */