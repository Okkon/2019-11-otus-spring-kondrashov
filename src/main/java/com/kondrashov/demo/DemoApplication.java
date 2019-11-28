package com.kondrashov.demo;

import com.kondrashov.demo.service.NameService;
import com.kondrashov.demo.service.TestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestService testService = context.getBean(TestService.class);
        NameService nameService = context.getBean(NameService.class);
        nameService.askForFirstName();
        nameService.askForLastName();
        testService.startTesting(nameService.getFullName());


    }

}
