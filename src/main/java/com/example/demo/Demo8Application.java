package com.example.demo;

import com.example.demo.config.DemoConfig;
import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;
import com.example.demo.service.TrafficFortuneService;
import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

@EnableAutoConfiguration(exclude ={HibernateJpaAutoConfiguration.class	} )
@SpringBootApplication()
public class Demo8Application {
	private static Logger myLogger=Logger.getLogger(Demo8Application.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(Demo8Application.class, args);

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);


		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");

		myLogger.info("Calling getFortune");
		boolean tripWire=true;
		String data = theFortuneService.getFortune(tripWire);

		myLogger.info("\nMy fortune is: " + data);

		myLogger.info("Finished");

		AccountDAO theDAO=context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMembershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
		Account myAccount = new Account();
		myAccount.setName("louey");
		myAccount.setLevel("Haouari");
		theDAO.addAccount(myAccount, true);
		theDAO.doWork();
		theDAO.setName("fooBar");
		theDAO.setServiceCode("silver");
		String name=theDAO.getName();
		String code=theDAO.getServiceCode();
		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		context.close();
	}

}
