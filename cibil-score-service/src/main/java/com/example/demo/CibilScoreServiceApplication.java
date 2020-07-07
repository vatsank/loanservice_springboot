package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.example.demo.entity.CibilScore;
import com.example.demo.ifaces.CibilScoreRepository;


@SpringBootApplication
public class CibilScoreServiceApplication {

	public static void main(String[] args) {
	
		ConfigurableApplicationContext ctx=	SpringApplication.run(CibilScoreServiceApplication.class, args);
	

		
//	  CibilScore rameshScore = ctx.getBean("ramesh",CibilScore.class);
//	  
//	  System.out.println(rameshScore);
//	 
//	  
//	  
//    CibilScore defaScore = ctx.getBean("cibilScore",CibilScore.class);
//	  
//	  System.out.println(defaScore);
	  
		
//		CibilScore sureshScore = ctx.getBean("suresh",CibilScore.class);
//		  
//		  System.out.println(sureshScore);
//		  
//		  System.out.println("is Singleton"+ctx.isSingleton("suresh"));
//		  
//		  System.out.println("is Prototype"+ctx.isPrototype("suresh"));
//		  
//		  
//      CibilScore sureshScore2 = ctx.getBean("suresh",CibilScore.class);
//		  
//		  System.out.println(sureshScore2);
//		  
//		  System.out.println("Hash code of Suresh -1 "+ sureshScore.hashCode());
//		  
//		  System.out.println("Hash code of Suresh -2 "+ sureshScore2.hashCode());
//		  
//	   ctx.close();
	
	}

	
	// Factory Method to be used by IoC Container
	
	// Constructor Dependency Injection is used
	@Bean
	public CibilScore ramesh() {
		
		return new CibilScore(1010, "AAXPAB449S", "Ramesh", "kumar", "chennai", 755);
	}
	

	// Factory Method to be used by IoC Container
	
		// Setter  Dependency Injection is used

	@Bean
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public CibilScore suresh() {
		
		CibilScore sureshScore = new CibilScore();
		
		 sureshScore.setId(2020);
		 sureshScore.setFirstName("Suresh");
		 sureshScore.setLastName("Reddy");
		 sureshScore.setLocation("Hyderabad");
		 sureshScore.setPanNumber("AAXXS45");
		 sureshScore.setScore(732);
		 
		 
		 return sureshScore;
	}
	
	@Bean
	public CommandLineRunner runner() {
		
		
		return new CommandLineRunner() {

			@Autowired
			CibilScoreRepository repo;

			@Override
			public void run(String... args) throws Exception {
				
			  repo.save(new CibilScore(1010, "AAXPAB449S", "Ramesh", "kumar", "chennai", 755));
				
			}
		};
		
	}
}
